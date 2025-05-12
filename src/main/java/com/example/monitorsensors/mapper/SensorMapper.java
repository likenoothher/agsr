package com.example.monitorsensors.mapper;

import com.example.monitorsensors.dto.sensor.SensorCreateUpdateDto;
import com.example.monitorsensors.dto.sensor.SensorDto;
import com.example.monitorsensors.model.Sensor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SensorMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "type", ignore = true)
    @Mapping(target = "unit", ignore = true)
    @Mapping(target = "rangeFrom", source = "range.from")
    @Mapping(target = "rangeTo", source = "range.to")
    Sensor toEntity(SensorCreateUpdateDto request);

    @Mapping(target = "type", source = "type.name")
    @Mapping(target = "unit", source = "unit.symbol")
    @Mapping(target = "range.from", source = "rangeFrom")
    @Mapping(target = "range.to", source = "rangeTo")
    SensorDto toDto(Sensor sensor);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "type", ignore = true)
    @Mapping(target = "unit", ignore = true)
    @Mapping(target = "rangeFrom", source = "request.range.from")
    @Mapping(target = "rangeTo", source = "request.range.to")
    void fill(@MappingTarget Sensor sensor, SensorCreateUpdateDto request);
}
