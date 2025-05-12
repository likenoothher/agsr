package com.example.monitorsensors.controller;

import com.example.monitorsensors.dto.SensorTypeDto;
import com.example.monitorsensors.service.SensorTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sensor-types")
@RequiredArgsConstructor
@Tag(name = "Sensor Types", description = "Sensor type management APIs")
@SecurityRequirement(name = "Bearer Authentication")
public class SensorTypeController {

    private final SensorTypeService sensorTypeService;

    @Operation(
        summary = "Get all sensor types",
        description = "Returns a list of all available sensor types"
    )
    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<SensorTypeDto> getAllSensorTypes() {
        return sensorTypeService.getAll();
    }
}
