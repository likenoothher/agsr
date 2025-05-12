package com.example.monitorsensors.dto.sensor;

import com.example.monitorsensors.validation.ValidRange;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@ValidRange
public class RangeDto {

    @NotNull
    private Long from;
    @NotNull
    private Long to;
}
