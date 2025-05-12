package com.example.monitorsensors.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sensor_types")
public class SensorType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
} 