

public class app {

    public static void main(String[] args) {
        
        //int n = Integer.parseInt(args[0]);
        Boolean [] red_stairs = {false,false,false,false,false,false,false,false};
        int [] prices = {3,2,4,6,1,1,5,3};
        int [] expected_path = {0,2,3,5,6,8};
        ClimbStairs.lowestCostPathToClimbStairsKStepsSkipRedStairs(8,2, red_stairs, prices);
    }
    
}
