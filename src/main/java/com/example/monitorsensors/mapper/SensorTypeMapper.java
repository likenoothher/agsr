package com.example.monitorsensors.mapper;

import com.example.monitorsensors.dto.SensorTypeDto;
import com.example.monitorsensors.model.SensorType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SensorTypeMapper {

    SensorTypeDto toDto(SensorType sensorType);
} 