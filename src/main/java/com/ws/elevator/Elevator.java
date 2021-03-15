package com.ws.elevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Olatunji O. Longe
 * @since 13 Mar, 2021, 1:04 p.m.
 */
public class Elevator {

    private final ElevatorData data;

    public Elevator() {
        data = new ElevatorData();
    }

    /**
     * Handles how the elevator travels starting from the {@code startFloor}
     * based on the specified {@code carLoads}
     *
     * @param startFloor floor where the elevator begins travel
     * @param carLoads   dataset that specifies button pushes per group of occupants
     * @return data that was gathered all through the elevator's journey
     */
    public ElevatorData travel(int startFloor, List<List<Integer>> carLoads) {
        if (null != carLoads) {
            data.setCarLoadCount(carLoads.size());
            int currentFloor = startFloor;
            for (List<Integer> carLoad : carLoads) {
                currentFloor = processCarLoad(currentFloor, carLoad);
            }
            data.setFinalFloor(currentFloor);
        }
        return data;
    }

    /**
     * @param currentFloor Current floor where the elevator stopped and would move from
     * @param carLoad      Button pushes by a particular group of occupants riding on the elevator
     *                     starting at the {@code currentFloor}
     * @return The next floor where elevator is stopped (also regarded as the next {@code currentFloor})
     */
    private int processCarLoad(int currentFloor, List<Integer> carLoad) {

        List<Integer> sortedCarLoad = new ArrayList<>(carLoad);
        Collections.sort(sortedCarLoad);

        int minFloor = sortedCarLoad.get(0);
        int maxFloor = sortedCarLoad.get(sortedCarLoad.size() - 1);

        boolean shouldAscend = currentFloor < maxFloor;

        if (shouldAscend) {
            for (int floor = currentFloor; floor <= maxFloor; floor++) {
                currentFloor = processFloorData(carLoad, floor);
            }
        } else {
            for (int floor = currentFloor; floor >= minFloor; floor--) {
                currentFloor = processFloorData(carLoad, floor);
            }
        }
        return !carLoad.isEmpty() ? processCarLoad(currentFloor, carLoad) : currentFloor;
    }

    /**
     * Removes the {@code floor} from the specified {@code carLoad} if the {@code carLoad} contains the {@code floor}
     * ... And gathers required data in the process
     *
     * @param carLoad Button pushes by any group of occupants riding on the elevator
     * @param floor   the floor where the elevator is currently at
     * @return the same floor that was passed, but after processing the data
     */
    private int processFloorData(List<Integer> carLoad, final int floor) {
        data.incrementFloorCount();
        if (carLoad.contains(floor)) {
            data.addStop(floor);
            carLoad.removeIf(value -> value == floor);
        }
        return floor;
    }

}
