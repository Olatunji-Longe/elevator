import com.ws.elevator.Elevator;
import com.ws.elevator.ElevatorData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Olatunji O. Longe
 * @since 13 Mar, 2021, 11:52 p.m.
 */
public class ElevatorTest {

    private final Elevator elevator = new Elevator();

    List<List<Integer>> carLoads1 = Arrays.asList(
            new LinkedList<>(Arrays.asList(3, 1, 4)),
            new LinkedList<>(Arrays.asList(2, 8, 4)),
            new LinkedList<>(Arrays.asList(4, 6, 4, 9))
    );

    List<List<Integer>> carLoads2 = Arrays.asList(
            new LinkedList<>(Arrays.asList(5, 7, 4, 6)),
            new LinkedList<>(Arrays.asList(9, 5, 8, 1)),
            new LinkedList<>(Arrays.asList(4, 6, 9, 2))
    );

    @Test
    @DisplayName("Test elevator travel (carLoads-1) when start floor is 5")
    void testUsingDataSet1A() {

        ElevatorData data = elevator.travel(5, carLoads1);

        assertEquals(3, data.getCarLoadCount());
        assertEquals(4, data.getFinalFloor());
    }

    @Test
    @DisplayName("Test elevator travel (carLoads-1) when start floor is 0")
    void testUsingDataSet1B() {

        ElevatorData data = elevator.travel(0, carLoads1);

        assertEquals(3, data.getCarLoadCount());
        assertEquals(9, data.getFinalFloor());
    }

    @Test
    @DisplayName("Test elevator travel (carLoads-1) when start floor is negative (-1)")
    void testUsingDataSet1C() {

        ElevatorData data = elevator.travel(-2, carLoads1);

        assertEquals(3, data.getCarLoadCount());
        assertEquals(9, data.getFinalFloor());
    }

    @Test
    @DisplayName("Test elevator travel (carLoads-2) when start floor is 10")
    void testUsingDataSet2A() {

        ElevatorData data = elevator.travel(10, carLoads2);

        assertEquals(3, data.getCarLoadCount());
        assertEquals(9, data.getFinalFloor());
    }

    @Test
    @DisplayName("Test elevator travel (carLoads-2) when start floor is 0")
    void testUsingDataSet2B() {

        ElevatorData data = elevator.travel(0, carLoads2);

        assertEquals(3, data.getCarLoadCount());
        assertEquals(9, data.getFinalFloor());
    }

    @Test
    @DisplayName("Test elevator travel (carLoads-2) when start floor is negative (-3)")
    void testUsingDataSet2C() {

        ElevatorData data = elevator.travel(-3, carLoads2);

        assertEquals(3, data.getCarLoadCount());
        assertEquals(9, data.getFinalFloor());
    }

    @Test
    @DisplayName("Test elevator travel when carLoads is empty")
    void testUsingDataSet3A() {

        ElevatorData data = elevator.travel(0, Collections.emptyList());

        assertEquals(0, data.getCarLoadCount());
        assertEquals(0, data.getStopsCount());
        assertTrue(data.getStoppedFloors().isEmpty());
        assertEquals(0, data.getFinalFloor());
    }

    @Test
    @DisplayName("Test elevator travel when carLoads is null")
    void testUsingDataSet3B() {

        ElevatorData data = elevator.travel(0, null);

        assertEquals(0, data.getCarLoadCount());
        assertEquals(0, data.getStopsCount());
        assertTrue(data.getStoppedFloors().isEmpty());
        assertEquals(0, data.getFinalFloor());
    }

}
