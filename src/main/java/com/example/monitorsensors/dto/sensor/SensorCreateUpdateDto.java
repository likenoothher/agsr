package com.example.monitorsensors.dto.sensor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SensorCreateUpdateDto {

    @NotBlank
    @Size(min = 3, max = 30, message = "Min allowed size is 3, max allowed size is 30")
    private String name;

    @NotBlank
    @Size(max = 15, message = "Max allowed size is 30")
    private String model;

    @Valid
    @NotNull
    private RangeDto range;

    @NotNull
    private Long typeId;

    private Long unitId;

    @Size(max = 40, message = "Max allowed size is 40")
    private String location;

    @Size(max = 200, message = "Max allowed size is 200")
    private String description;
}
