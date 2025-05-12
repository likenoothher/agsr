package com.example.monitorsensors.service.impl;

import com.example.monitorsensors.dto.SensorTypeDto;
import com.example.monitorsensors.exception.EntityNotFoundException;
import com.example.monitorsensors.mapper.SensorTypeMapper;
import com.example.monitorsensors.model.SensorType;
import com.example.monitorsensors.repository.SensorTypeRepository;
import com.example.monitorsensors.service.SensorTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SensorTypeServiceImpl implements SensorTypeService {

    private final SensorTypeRepository sensorTypeRepository;
    private final SensorTypeMapper sensorTypeMapper;

    @Override
    public List<SensorTypeDto> getAll() {
        return sensorTypeRepository.findAll().stream()
                .map(sensorTypeMapper::toDto)
                .toList();
    }

    @Override
    public SensorType getById(Long id) {
        return sensorTypeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Sensor type not found by id " + id));
    }
}
