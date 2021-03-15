### About

---

This is a simple application that solves the problem described as follows;

Elevator rules:

1. The elevator always moves up first and then down.
2. The elevator won't move unless someone pushes a button.
3. The elevator gets its instructions as an array of arrays.
    - The array of arrays represents a number of carloads.
    - The numbers represent button pushes by people in the elevator car
    - Each array is a single carload.
    - We'll assume that nobody new enters the car once it starts moving until it lets off its final passenger.
    - For example, this is 3 car loads described as an array of arrays (Ruby):
      `[[3,1,4],[2,8,4],[4,6,4,9]]`
    - describing the car loads above:
        - the elevator is stopped on a floor. it is empty.
        - 3 people get in: one pushes 3, one pushes 1, one pushes 4. the car moves and delivers everyone at their
          correct floor. the car is then empty. the car is now on floor 4.
        - 3 people get in: one pushes 2, one pushes 8, one pushes 4. the car moves and delivers everyone at their
          correct floor. the car is then empty. the car is now on floor 2.
        - 4 people get in: one pushes 4, one pushes 6, another person pushes 4, one persons pushes 9. the car moves and
          delivers everyone at their correct floor. the car is now on floor 9.
        - the elevator is stopped.
4. The elevator starts on floor 5.
5. At the end of processing an array of instructions, the elevator displays:
    - how many stops it made
    - how many carloads it processed
    - how many floors it passed either going up or down from the start floor (floor 5)
    - the final (current) floor that the elevator is on

### Ambiguities Observed

Ambiguity-1:

- The problem does not provide any notion of an elevator's minimum floor and maximum floor

Resolution-1:

- Always check a CarLoad's Minimum and Maximum floor to keep the elevator's travel within these bounds. Also if the
  start floor falls outside these bounds, assume that the elevator travels from the start floor up or down through the
  CarLoad's bounds and calculate the number of traversed floors based off these assumptions.

### Requirements

---

- Java 8
- Terminal

### How to build

---

Run the following command from a Terminal to build the project

- Change directory to the project root
    ```
    cd elevator
    ```

- From the project root, run the following command
    ```
    ./gradlew clean build
    ```

- A jar file named `elevator.jar` will be generated into the `elevator/build/libs` directory.

### Program Arguments

---

The program accepts ONLY ONE ARGUMENT specified as a json string encapsulated within single Quotes `'{ ... }'`

The json string MUST be of the following format

```
{"startFloor": <floor-number>, "carLoads": <two-dimensional-array-of-carloads>}
```

Types:

- `<floor-number>` (integer e.g `5`)
- `<two-dimensional-array-of-carloads>` : (array of arrays e.g `[[3,1,4],[2,8,4],[4,6,4,9]]`)

### How to Run the program

---

Copy the generated jar file to any preferred location and from that location, run a command patterned
like `java -jar elevator.jar '<json-string>'`

Full Command Example:

```
java -jar elevator.jar '{"startFloor": 5, "carLoads": [[3,1,4],[2,8,4],[4,6,4,9]]}'
```

