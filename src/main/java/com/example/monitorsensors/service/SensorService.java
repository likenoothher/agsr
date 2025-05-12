package com.example.monitorsensors.service;

import com.example.monitorsensors.dto.sensor.SensorCreateUpdateDto;
import com.example.monitorsensors.dto.sensor.SensorDto;

import java.util.List;

public interface SensorService {

    List<SensorDto> getAll(String name, String model);

    SensorDto getById(Long id);

    void create(SensorCreateUpdateDto request);

    void update(Long id, SensorCreateUpdateDto request);

    void delete(Long id);
}
