package com.example.monitorsensors.service.impl;

import com.example.monitorsensors.dto.sensor.SensorCreateUpdateDto;
import com.example.monitorsensors.dto.sensor.SensorDto;
import com.example.monitorsensors.exception.EntityNotFoundException;
import com.example.monitorsensors.mapper.SensorMapper;
import com.example.monitorsensors.model.Sensor;
import com.example.monitorsensors.model.SensorType;
import com.example.monitorsensors.model.Unit;
import com.example.monitorsensors.repository.SensorRepository;
import com.example.monitorsensors.service.SensorService;
import com.example.monitorsensors.service.SensorTypeService;
import com.example.monitorsensors.service.UnitService;
import com.example.monitorsensors.specifications.SensorSpecificationFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;
    private final SensorTypeService sensorTypeService;
    private final UnitService unitService;
    private final SensorMapper sensorMapper;

    @Override
    @Transactional(readOnly = true)
    public List<SensorDto> getAll(String name, String model) {
        Specification<Sensor> specification = SensorSpecificationFactory.build(name, model);
        return sensorRepository.findAll(specification).stream()
                .map(sensorMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public SensorDto getById(Long id) {
        return sensorMapper.toDto(findById(id));
    }

    @Override
    @Transactional
    public void create(SensorCreateUpdateDto request) {
        Sensor sensor = sensorMapper.toEntity(request);
        setUnitAndType(sensor, request.getUnitId(), request.getTypeId());
        sensorRepository.save(sensor);
    }

    @Override
    @Transactional
    public void update(Long id, SensorCreateUpdateDto request) {
        var sensor = findById(id);
        sensorMapper.fill(sensor, request);
        setUnitAndType(sensor, request.getTypeId(), request.getUnitId());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        sensorRepository.deleteById(id);
    }

    private Sensor findById(Long id) {
        return sensorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sensor not found with id " + id));
    }

    private void setUnitAndType(Sensor sensor, Long sensorTypeId, Long unitId) {
        SensorType sensorType = sensorTypeService.getById(sensorTypeId);
        Unit unit = ofNullable(unitId).map(unitService::getById).orElse(null);
        sensor.setUnit(unit);
        sensor.setType(sensorType);
    }
}
