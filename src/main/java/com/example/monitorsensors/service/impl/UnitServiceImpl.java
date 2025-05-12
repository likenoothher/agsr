package com.example.monitorsensors.service.impl;

import com.example.monitorsensors.dto.UnitDto;
import com.example.monitorsensors.exception.EntityNotFoundException;
import com.example.monitorsensors.mapper.UnitMapper;
import com.example.monitorsensors.model.Unit;
import com.example.monitorsensors.repository.UnitRepository;
import com.example.monitorsensors.service.UnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UnitServiceImpl implements UnitService {

    private final UnitRepository unitRepository;
    private final UnitMapper unitMapper;

    @Override
    public List<UnitDto> getAll() {
        return unitRepository.findAll().stream()
                .map(unitMapper::toDto)
                .toList();
    }

    @Override
    public Unit getById(Long id) {
        return unitRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Unit not found by id " + id));
    }
}
