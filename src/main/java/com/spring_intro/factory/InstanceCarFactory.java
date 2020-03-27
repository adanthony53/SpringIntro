package com.spring_intro.factory;

import com.spring_intro.entity.Car;

import java.util.Map;
import java.util.HashMap;

public class InstanceCarFactory {

    private Map<Long, Car> carMap;

    public InstanceCarFactory() {
        carMap = new HashMap<>();
        carMap.put(1L, new Car(1L, "BMW"));
        carMap.put(2L, new Car(2L, "Benz"));
    }

    public Car getCar(long id) {
        return carMap.get(id);
    }
}
