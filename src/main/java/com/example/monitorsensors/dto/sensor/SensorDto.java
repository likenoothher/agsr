package com.example.monitorsensors.dto.sensor;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SensorDto {
    private Long id;
    private String name;
    private String model;
    private RangeDto range;
    private String type;
    private String unit;
    private String location;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
} 