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
    public static int climbStairsKStepsWRedStairs(int n, int k, Boolean [] stairs){
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

    
}
