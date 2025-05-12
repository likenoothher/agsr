package com.example.monitorsensors.controller;

import com.example.monitorsensors.dto.sensor.SensorCreateUpdateDto;
import com.example.monitorsensors.dto.sensor.SensorDto;
import com.example.monitorsensors.service.SensorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sensors")
@RequiredArgsConstructor
@Tag(name = "Sensors", description = "Sensor management APIs")
@SecurityRequirement(name = "Bearer Authentication")
public class SensorController {

    private final SensorService sensorService;

    @Operation(
        summary = "Get all sensors",
        description = "Returns a list of all sensors. Can be filtered by name and model."
    )
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_VIEWER')")
    public List<SensorDto> getAllSensors(
            @Parameter(description = "Filter sensors by name") @RequestParam(required = false) String name,
            @Parameter(description = "Filter sensors by model") @RequestParam(required = false) String model) {
        return sensorService.getAll(name, model);
    }

    @Operation(
        summary = "Get sensor by ID",
        description = "Returns a sensor by its ID"
    )
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_VIEWER')")
    public SensorDto getSensorById(
            @Parameter(description = "ID of the sensor to retrieve", required = true) @PathVariable Long id) {
        return sensorService.getById(id);
    }

    @Operation(
        summary = "Create new sensor",
        description = "Creates a new sensor with the provided data. Requires ADMIN role."
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void createSensor(@Valid @RequestBody SensorCreateUpdateDto request) {
        sensorService.create(request);
    }

    @Operation(
        summary = "Update sensor",
        description = "Updates an existing sensor with the provided data. Requires ADMIN role."
    )
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateSensor(
            @Parameter(description = "ID of the sensor to update", required = true) @PathVariable Long id,
            @Valid @RequestBody SensorCreateUpdateDto request) {
        sensorService.update(id, request);
    }

    @Operation(
        summary = "Delete sensor",
        description = "Deletes a sensor by its ID. Requires ADMIN role."
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteSensor(
            @Parameter(description = "ID of the sensor to delete", required = true) @PathVariable Long id) {
        sensorService.delete(id);
    }
}
