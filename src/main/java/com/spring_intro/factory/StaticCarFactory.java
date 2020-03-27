package com.spring_intro.factory;

import com.spring_intro.entity.Car;

import java.util.Map;
import java.util.HashMap;

public class StaticCarFactory {
    private static Map<Long, Car> carMap;
    static {
        carMap = new HashMap<>();
        carMap.put(1L, new Car(1L, "BMW"));
        carMap.put(2L, new Car(2L, "Benz"));
    }

    public static Car getCar(long id) {
        return carMap.get(id);
    }
}
