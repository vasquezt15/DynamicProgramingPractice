public class CoinChange {
    

    /*
     * Problem:  Given an unlimeted supply of coins of given denominations [1,3,5,10], find the total number of ways to make change of size n
     * Objective Function: F(i) is the number of ways to make change of size i
     * Base Case: F(0) = 1 ,F(1) = 1. F(2) = 1, F(3) = F(3-3) + F(3-1), 
     * Recurrence Relation: F(n) = F(n-10) + F(n-5) + F(n-3) + F(n-1)
     * Order of Execution: Bottom up
     * Answer: F(n)
     * 
     */
     public int makeChange(int n, int[] coins){
        int [] n_ways = new int[n+1];
        n_ways[0] =1;
        n_ways[1] = 1;
        n_ways[2] = 1;

        for (int i=3; i<=n;i++){
            for (int j=0; j<= coins.length; j++){
                if(i >= coins[i]){
                    n_ways[i] += n_ways[i- coins[i]];
                }
            }
        }


        return n_ways[n];
     }
}
