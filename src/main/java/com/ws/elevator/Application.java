package com.ws.elevator;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Olatunji O. Longe
 * @since 13 Mar, 2021, 11:09 p.m.
 */
public class Application {

    public static void main(String[] args) {

        if (args.length == 1) {
            Input input = Input.parse(args[0]);

            ElevatorData elevatorData = new Elevator().travel(input.getStartFloor(), input.getCarLoads());

            //Printed only for data visualization - Uncomment to see the gathered data in console
            //System.out.printf("%n%s%n", elevatorData.toString());

            //Prints the actual expected user-friendly output
            System.out.println();
            System.out.printf("Number of Car Loads processed = %s%n", elevatorData.getCarLoadCount());
            System.out.printf("Number of stops made = %s%n", elevatorData.getStopsCount());
            System.out.printf("Number of traversed floors = %s%n", elevatorData.getFloorCount());
            System.out.printf("Final (current) Floor = %s%n", elevatorData.getFinalFloor());
            System.out.println();
        } else {
            throw new IllegalArgumentException("Expected only one argument in json format. Example: {\"startFloor\": 5, \"carLoads\": [[3,1,4],[2,8,4],[4,6,4,9]]} please see README.md doc for more information");
        }
    }

    public static List<List<Integer>> toList(String string) {
        Type type = new TypeToken<List<LinkedList<Integer>>>() {
        }.getType();
        return new Gson().fromJson(string, type);
    }
}
