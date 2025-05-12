package com.example.monitorsensors.repository;

import com.example.monitorsensors.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Long>, JpaSpecificationExecutor<Sensor> {
    @Query("SELECT s FROM Sensor s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(s.model) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<Sensor> searchByNameOrModel(@Param("search") String search);
} 