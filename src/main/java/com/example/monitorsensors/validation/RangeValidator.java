package com.example.monitorsensors.validation;

import com.example.monitorsensors.dto.sensor.RangeDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RangeValidator implements ConstraintValidator<ValidRange, RangeDto> {

    @Override
    public boolean isValid(RangeDto range, ConstraintValidatorContext context) {
        if (range == null || range.getFrom() == null || range.getTo() == null) {
            return false;
        }
        return range.getFrom().compareTo(range.getTo()) < 0;
    }
}
