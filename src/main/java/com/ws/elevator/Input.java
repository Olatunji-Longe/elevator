package com.ws.elevator;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Olatunji O. Longe
 * @since 13 Mar, 2021, 11:15 p.m.
 */
public class Input {

    final int startFloor;
    final List<List<Integer>> carLoads;

    public Input(int startCount, List<List<Integer>> carLoads) {
        this.startFloor = startCount;
        this.carLoads = carLoads;
    }

    public int getStartFloor() {
        return startFloor;
    }

    public List<List<Integer>> getCarLoads() {
        return carLoads;
    }

    public static List<List<Integer>> toList(String string) {
        Type type = new TypeToken<List<LinkedList<Integer>>>() {
        }.getType();
        return new Gson().fromJson(string, type);
    }

    public static Input parse(String string) {
        return new Gson().fromJson(string, Input.class);
    }


}
