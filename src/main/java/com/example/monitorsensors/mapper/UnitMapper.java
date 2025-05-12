package com.example.monitorsensors.mapper;

import com.example.monitorsensors.dto.UnitDto;
import com.example.monitorsensors.model.Unit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UnitMapper {

    UnitDto toDto(Unit unit);
} 