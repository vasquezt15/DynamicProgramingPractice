public class Nsum {

    /*
     * Problem: Sum the first n elements.
     * Objective Function: F(n) is the sum of the first n elements
     * Base Case: F(0) = 0
     * Recurrence Relation: F(n) = F(n-1) +F(n)
     * Order of Execution: Bottom up
     * Answer: F(n)
     * 
     */

    public static int n_sum(int n){
        //This method is the first attempt at a solution for the n_sum problem
        /*
         * Runtime: O(n)
         * Space: O(n)
         */
        int [] sums = new int[n+1];
        sums[0] = 0;
        for(int i=1;i<=n;i++){
            sums[i] = sums[i-1] +i;
        }
        return sums[n];
    }
    public static int n_sum_optimized(int n){
        //This method is optimized for size
        int sum =0;
        for(int i=1;i<=n;i++){
            sum= sum + i;
        }
        return sum;
    }
   
   
}
