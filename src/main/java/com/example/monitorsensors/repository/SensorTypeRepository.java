package com.example.monitorsensors.repository;

import com.example.monitorsensors.model.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorTypeRepository extends JpaRepository<SensorType, Long> {
} 