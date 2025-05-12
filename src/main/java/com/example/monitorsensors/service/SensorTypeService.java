package com.example.monitorsensors.service;

import com.example.monitorsensors.dto.SensorTypeDto;
import com.example.monitorsensors.model.SensorType;

import java.util.List;

public interface SensorTypeService {

    List<SensorTypeDto> getAll();

    SensorType getById(Long id);
}
