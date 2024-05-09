import java.util.ArrayList;
import java.util.Arrays;
public class ClimbStairs {
    /*
     * Problem: Climbing a stair case either 1 or two steps at a time. 
     * Objective Function: F(n) is the number of ways to climb to the nth step
     * Base Case: F(0) = 1, F(1) = 1
     * Recurrence Relation: F(n) = F(n-2) +F(n-1)
     * Order of Execution: Bottom up
     * Answer: F(n)
     * 
     */

    //Logger logger = Logger.getLogger(getClass().getName());
    private ClimbStairs(){

    }
    public static int climbStairsTwoSteps(int n){
        /*
         * Initial solution
         * Runtime: O(n)
         * Space: O(n)
         */
        int [] n_ways = new int[n+1];
        if(n==0){
            return 1;
        }
        n_ways[0] = 1;
        n_ways[1] = 1;
        for(int i=2;i<=n;i++){
            n_ways[i] = n_ways[i-1] + n_ways[i-2];
        }
        return n_ways[n];
    }

    public static int climbStairsTwoStepsSpaceOptimized(int n){
        /*
         * Space optimized solution
         * Runtime: O(n)
         * Space: O(1)
         */
        if(n==0 || n==1){
            return 1;
        }
        int b1 = 1;
        int b2 = 1;
        int output=0;
        
        for(int i=2;i<=n;i++){
            output = b1+ b2;
            b1 = b2;
            b2 = output;
        }
        return output;
    }
    /*
     * Problem: Climbing a stair case either k steps at a time. 
     * Objective Function: F(n) is the number of ways to climb to the nth step
     * Base Case: F(0) = 1, F(1) = 1
     * Recurrence Relation: F(n) = F(n-k) + ... + F(n-2) +F(n-1)
     * Order of Execution: Bottom up
     * Answer: F(n)
     * 
     */
    public static int climbStairsKSteps(int n, int k){
        /*
         * Initial Solution
         * Runtime: O(n*k)
         * Space: O(n)
         */
        if(n==0 || n==1){
            return 1;
        }
        int [] n_ways = new int[n+1];
        n_ways[0] =1;
        n_ways[1] =1;

        for(int i=2;i<=n;i++){
            for(int j =0; j<= k; j++){
                if(i<j){
                    continue;
                }
                n_ways[i] += n_ways[i-j];
            }
        }
        return n_ways[n];
    }

    /*
     * Problem: Climbing a stair case either k steps at a time. 
     * Objective Function: F(n) is the number of ways to climb to the nth step
     * Base Case: F(0) = 1, F(1) = 1
     * Recurrence Relation: F(n) = F(n-k) + ... + F(n-2) +F(n-1)
     * Order of Execution: Bottom up
     * Answer: F(n)
     * 
     */
    public static int climbStairsKStepsOptimized(int n, int k){
        /*
         * Optimized Solution
         * Runtime: O(n*k)
         * Space: O(k)
         */
        if(n==0 || n==1){
            return 1;
        }

        int [] n_ways = new int[k];
        n_ways[0] =1;
        
        //intialize n_ways up to k-1
        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= i; j++) {
                n_ways[i] += n_ways[i - j];
            }
        }
        //compute from k to n
        for (int i = k; i <= n; i++) {
            int total = 0;
            for (int j = 1; j <= k; j++) {
                total += n_ways[(i - j) % k];
            }
            n_ways[i % k] = total;
        }
        return n_ways[n%k];
    }

    public static int climbStairsKStepsOptimized2(int n, int k){
        /*
         * Optimized Solution
         * Runtime: O(n*k)
         * Space: O(k)
         */
        if(n==0 || n==1){
            return 1;
        }

        int [] n_ways = new int[k];
        n_ways[0] =1;
        
        //compute from 1 to n
        for (int i = 1; i <= n; i++) {
            int total = 0;
            for (int j = 1; j <= Math.min(i,k); j++) {
                total += n_ways[(i - j) % k];
            }
            n_ways[i % k] = total;
        }
        return n_ways[n%k];
    }
    public static int climbStairsKStepsSkipRedStairs(int n, int k, Boolean [] red_stairs){
        /*
         * Optimized Solution
         * Runtime: O(n*k)
         * Space: O(k)
         */
        if(n==0 || n==1){
            return 1;
        }

        int [] n_ways = new int[k];
        n_ways[0] =1;
        
        //compute from 1 to n
        for (int i = 1; i <= n; i++) {
            //the red_stairs array contains a flag for stairs 1-n, red_stairs[0] is the flag for the first stair.
            if(red_stairs[i-1]){
                n_ways[i % k] = 0;
            }
            else{

                int total = 0;
                //check if the current stair is mrked off
                for (int j = 1; j <= Math.min(i,k); j++) {
                    //check if the previos stair is marked off
                    total += n_ways[(i - j) % k];
            }

            n_ways[i % k] = total;
            } 
        }
        return n_ways[n%k];
    }

/*
     * Problem: Find the lowest cost to climb n stairs k at a time, avoiding red stairs 
     * Objective Function: F(n) is the lowes cost of climbing n stairs
     * Base Case: F(0) = cost[0], F(1) = cost[1], F(2) = cost[2] + min(cost[n-1], cost[n-2],..., cost[n-k])
     * Recurrence Relation: F(n) = cost[n] + min(F(n-1), F(n-2),..., F(n-k)) 
     * Order of Execution: Bottom up
     * Answer: F(n)
     * 
     */

    public static int lowestCostClimbStairsKStepsSkipRedStairs(int n, int k, Boolean [] red_stairs, int [] prices){
        /*
         * Optimized Solution
         * Runtime: O(n*k)
         * Space: O(k)
         */
        if(n==0 || n==1){
            return 1;
        }

        int [] costs = new int[k];
        costs[0] =0;
        
        //compute from 1 to n
        for (int i = 1; i <= n; i++) {
            //the red_stairs array contains a flag for stairs 1-n, red_stairs[0] is the flag for the first stair.
            System.out.printf("Current stair %d\n", i);
            if(red_stairs[i-1]){
                //very large costs so this stair is never picked
                costs[i % k] = 999999;
            }
            else{
                //very high dummy cost
                int min_cost = 999999;
                //check if the current stair is mrked off
                for (int j = 1; j <= Math.min(i,k); j++) {
                    //check if the previos stair is marked off
                    min_cost = Math.min(min_cost,costs[(i - j) % k]);
                    //logger.info(min_cost);
                    System.out.printf("min cost candidate %d\n", min_cost);
            }
            System.out.printf("min cost selected %d\n", min_cost);
            costs[i % k] = min_cost + prices[i-1];
            System.out.printf("Current stair cost %d\n\n\n", costs[i % k]);
            } 
        }
        return costs[n%k];
    }



    public static ArrayList<Integer> lowestCostPathToClimbStairsKStepsSkipRedStairs(int n, int k, Boolean [] red_stairs, int [] prices){
        /*
         * Optimized Solution
         * Runtime: O(n*k)
         * Space: O(n)
         */

        Integer [] costs = new Integer[n+1];
        ArrayList<Integer> path = new ArrayList();
        costs[0] =0;
        path.add(0);
        //compute from 1 to n
        for (int i = 1; i <= n; i++) {
            //the red_stairs array contains a flag for stairs 1-n, red_stairs[0] is the flag for the first stair.
            System.out.printf("Current stair %d\n", i);
            if(red_stairs[i-1]){
                //very large costs so this stair is never picked
                costs[i] = 999999;
            }
            else{
                //very high dummy cost
                Integer min_cost = 999999;
                //initialize the previos step to the step right before
                Integer previous_step = i-1;
                //check if the current stair is mrked off
                for (int j = 1; j <= Math.min(i,k); j++) {
                    //update the previous step with the index of the min value
                    //on the first iteration the index is set of the first min value
                    previous_step = Math.min(min_cost,costs[i - j]) == costs[i - j] ? i - j: previous_step;
                    min_cost = Math.min(min_cost,costs[i - j]);
                    //logger.info(min_cost);
                    //System.out.printf("min cost candidate %d\n", min_cost);
            }
            System.out.printf("min cost selected %d stair_index %d \n", min_cost,previous_step);
            int last_index =path.size()-1;
            if(previous_step!= path.get(last_index)){
                path.add(previous_step);
            }
            //path.add(previous_step);
            costs[i] = min_cost + prices[i-1];
            System.out.println("Current path: " +path.toString() + "\n\n");
            } 
        }
        path.add(n);
        System.out.println("Current path: " +path.toString() + "\n\n");
        return path;
    }


    
}
