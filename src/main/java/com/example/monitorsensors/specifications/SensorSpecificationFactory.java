package com.example.monitorsensors.specifications;

import com.example.monitorsensors.model.Sensor;
import com.example.monitorsensors.model.Sensor_;
import org.springframework.data.jpa.domain.Specification;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class SensorSpecificationFactory {

    public static Specification<Sensor> build(String name, String model) {
        Specification<Sensor> specification = Specification.where(null);
        if (isNotBlank(name)) {
            specification = specification.and(filterByName(name));
        }

        if (isNotBlank(model)) {
            specification = specification.and(filterByModel(model));
        }
        return specification;
    }

    private static Specification<Sensor> filterByName(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Sensor_.name), "%" + name + "%");
    }

    private static Specification<Sensor> filterByModel(String model) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Sensor_.name), "%" + model + "%");
    }
}
