package com.example.monitorsensors.service;

import com.example.monitorsensors.dto.UnitDto;
import com.example.monitorsensors.model.Unit;

import java.util.List;

public interface UnitService {

    List<UnitDto> getAll();

    Unit getById(Long id);
}
