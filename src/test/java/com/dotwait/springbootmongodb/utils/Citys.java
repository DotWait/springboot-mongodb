package com.dotwait.springbootmongodb.utils;

import java.util.HashMap;
import java.util.Map;

public class Citys {
    private static final Map<Integer, String> citys = new HashMap<>();

    static {
        citys.put(0, "杭州");
        citys.put(1, "北京");
        citys.put(2, "广州");
    }

    public static String getCity(Integer city){
        return citys.get(city);
    }
}
