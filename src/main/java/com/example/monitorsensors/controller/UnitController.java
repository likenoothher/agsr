package com.example.monitorsensors.controller;

import com.example.monitorsensors.dto.UnitDto;
import com.example.monitorsensors.service.UnitService;
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
@RequestMapping("/api/v1/units")
@RequiredArgsConstructor
@Tag(name = "Units", description = "Unit management APIs")
@SecurityRequirement(name = "Bearer Authentication")
public class UnitController {

    private final UnitService unitService;

    @Operation(
        summary = "Get all units",
        description = "Returns a list of all available units"
    )
    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UnitDto> getAllUnits() {
        return unitService.getAll();
    }
}
