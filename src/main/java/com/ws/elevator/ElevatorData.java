package com.ws.elevator;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Olatunji O. Longe
 * @since 13 Mar, 2021, 11:18 p.m.
 * <p>
 * Data that would be gathered as the elevator travels
 * from it's starting floor to its final destination floor
 */
public class ElevatorData {

    private int carLoadCount;
    private int stopsCount;
    private int floorCount;
    //Only used for data Visualization
    private final List<Integer> stoppedFloors;
    private int finalFloor;

    public ElevatorData() {
        this.stoppedFloors = new ArrayList<>();
    }

    public void incrementFloorCount() {
        floorCount++;
    }

    public void addStop(int floor) {
        stoppedFloors.add(floor);
        stopsCount++;
    }

    public void setCarLoadCount(int carLoadCount) {
        this.carLoadCount = carLoadCount;
    }

    public void setFinalFloor(int finalFloor) {
        this.finalFloor = finalFloor;
    }

    public int getCarLoadCount() {
        return carLoadCount;
    }

    public int getStopsCount() {
        return stopsCount;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public List<Integer> getStoppedFloors() {
        return stoppedFloors;
    }

    public int getFinalFloor() {
        return finalFloor;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
