import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;

public class ClimbStairsTests {
    //test cases for climbing stairs two at a time
    @Test
    void climbStairsTestRunWithZero() {
        assertEquals(1, ClimbStairs.climbStairsTwoSteps(0), "Stairs for 0 should be 1");
    }
    @Test
    void  climbStairsTestRunWithOne() {
        assertEquals(1, ClimbStairs.climbStairsTwoSteps(1), "Stairs for 1 should be 1");
    }
    @Test
    void  climbStairsTestRunWithFive() {
        Assertions.assertEquals(8, ClimbStairs.climbStairsTwoSteps(5), "Stairs for 5 should equal 8");
    }

    @Test
    void  climbStairsOptimTestRunWithZero() {
        assertEquals(1, ClimbStairs.climbStairsTwoStepsSpaceOptimized(0), "Stairs for 0 should be 1");
    }
    @Test
    void climbStairsOptimTestRunWithOne() {
        assertEquals(1, ClimbStairs.climbStairsTwoStepsSpaceOptimized(1), "Stairs for 1 should be 1");
    }
    @Test
    void climbStairsOptimTestRunWithFive() {
        Assertions.assertEquals(8, ClimbStairs.climbStairsTwoStepsSpaceOptimized(5), "Stairs for 5 should equal 8");
    }

    //test cases for climbing stairs k at a time
    @Test
    void  climbStairsKTestRunWithZero() {
        assertEquals(1, ClimbStairs.climbStairsKSteps(0, 1), "Stairs for n=0, k=1  should be 1");
    }
    @Test
    void climbStairsKTestRunWithOne() {
        assertEquals(1, ClimbStairs.climbStairsKSteps(1,1), "Stairs for n=1, k=1  should be 1");
    }
    @Test
    void climbStairskTestRunWithTwo() {
        Assertions.assertEquals(2, ClimbStairs.climbStairsKSteps(2,2), "Stairs for n=2, k=2 should equal 2");
    }
    @Test
    void climbStairskTestRunWithFiveAndTwo() {
        Assertions.assertEquals(8, ClimbStairs.climbStairsKSteps(5,2), "Stairs for n=5, k=2 should equal 8");
    }
    @Test
    void climbStairskTestRunWithThreeAndTwo() {
        Assertions.assertEquals(3, ClimbStairs.climbStairsKSteps(3,2), "Stairs for n=3, k=2 should equal 3");
    }
    @Test
    void climbStairskTestRunWithThreeAndThree() {
        Assertions.assertEquals(4, ClimbStairs.climbStairsKSteps(3,3), "Stairs for n=3, k=3 should equal 4");
    }
    @Test
    void climbStairskTestRunWithFiveAndThree() {
        Assertions.assertEquals(13, ClimbStairs.climbStairsKSteps(5,3), "Stairs for n=5, k=3 should equal 13");
    }

    @Test
    void climbStairsKStepsOptimizedTestRunWithTwo() {
        Assertions.assertEquals(2, ClimbStairs.climbStairsKStepsOptimized2(2,2), "Stairs for n=2, k=2 should equal 2");
    }
    @Test
    void climbStairsKStepsOptimizedTestRunWithFiveAndTwo() {
        Assertions.assertEquals(8, ClimbStairs.climbStairsKStepsOptimized2(5,2), "Stairs for n=5, k=2 should equal 8");
    }
    @Test
    void climbStairsKStepsOptimizedTestRunWithThreeAndTwo() {
        Assertions.assertEquals(3, ClimbStairs.climbStairsKStepsOptimized2(3,2), "Stairs for n=3, k=2 should equal 3");
    }
    @Test
    void climbStairsKStepsOptimizedTestRunWithThreeAndThree() {
        Assertions.assertEquals(4, ClimbStairs.climbStairsKStepsOptimized2(3,3), "Stairs for n=3, k=3 should equal 4");
    }
    @Test
    void climbStairsKStepsOptimizedTestRunWithFiveAndThree() {
        Assertions.assertEquals(13, ClimbStairs.climbStairsKStepsOptimized2(5,3), "Stairs for n=5, k=3 should equal 13");
    }
    //avoid red stairs
    @Test
    void climbStairsKStepsSkipRedStairsOptimizedTestRunWithThreeAndSeven() {
        Boolean [] red_stairs = {false,true,false,true,true,false,false};
        Assertions.assertEquals(2, ClimbStairs.climbStairsKStepsSkipRedStairs(7,3, red_stairs), "Stairs for n=8, k=3, red stairs false,true,false,true,true,false,false should equal 2");
    }


    //lowest possible cost
    @Test
    void lowestCostToClimbStairsKStepsSkipRedStairsOptimizedTestRunWithThreeAndSeven() {
        Boolean [] red_stairs = {false,false,false};
        int [] prices = {3,2,4};
        Assertions.assertEquals(6, ClimbStairs.lowestCostClimbStairsKStepsSkipRedStairs(3,2, red_stairs, prices), "Price for n=3, k=2, red stairs all true should equal 6");
    }

    //optimal path test
    @Test
    void lowestCostPathToClimbStairsKStepsSkipRedStairsOptimizedTestRun1() {
        Boolean [] red_stairs = {false,false,false,false,false,false,false,false};
        int [] prices = {3,2,4,6,1,1,5,3};
        ArrayList<Integer> expected_path = new ArrayList(Arrays.asList(0,2,3,5,6,8));
        ArrayList<Integer> output =ClimbStairs.lowestCostPathToClimbStairsKStepsSkipRedStairs(8,2, red_stairs, prices);
        Assertions.assertEquals(expected_path, output , "Expected path: " + expected_path.toString() +"\n\n" + " Actual: " + output.toString());
    }

}
