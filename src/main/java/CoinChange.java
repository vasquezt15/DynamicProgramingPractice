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
     public static int makeChange(int n, int[] coins){
        int [] n_ways = new int[n+1];
        n_ways[0] =1;

        for (int i=1; i<=n;i++){
            for (int j=0; j< coins.length; j++){
                if(i >= coins[j]){
                    n_ways[i] += n_ways[i- coins[j]];
                }
            }
        }


        return n_ways[n];
     }



/*
     * Problem:  Given an unlimeted supply of coins of given denominations [1,3,5,10], find the total number of ways to make change of size n, using exaly k coins
     * Objective Function: F(i,k) is the number of ways to make change of size i with k coins
     * Base Case: F(i,0) = 0 ,F(0,0) = 1, F(i,1) = 1 if i in coins 0 otherwise
     * Recurrence Relation: F(i) =() F(i-10, 0) +F(i-10, 1)  )+ F(i-5, k-1) + F(i-3, k-1) + F(i-1, k-1)
     * Order of Execution: Bottom up
     * Answer: F(n)
     * 
     */
    public static int makeChangek(int n, int k, int[] coins){
        int [][] n_ways = new int[n+1][k+1];
        n_ways[0][0] =1;

        for (int i=0; i<=n;i++){
            for(int j =0; j<=k; j++ ){
                if(j==0 && i>0){
                    n_ways[i][j] = 0;
                    continue;
                }
                for(int coin: coins){
                    if(i>= coin){
                        n_ways[i][j] += n_ways[i-coin][j-1];
                    }

                }
            }
            
            }
            return n_ways[n][k];
        }


        

     /*
     * Problem:  Given an unlimeted supply of coins of given denominations [1,3,5,10], find the total number of ways to make change of size n, using no more than k coins
     * Objective Function: F(i) is the number of ways to make change of size i
     * Base Case: F(0) = 1 ,F(1) = 1. F(2) = 1, F(3) = F(3-3) + F(3-1), 
     * Recurrence Relation: F(n) = F(n-10) + F(n-5) + F(n-3) + F(n-1)
     * Order of Execution: Bottom up
     * Answer: F(n)
     * 
     */
    public static int makeChangeUpTok(int n, int k, int[] coins){
        int [][] n_ways = new int[n+1][k+1];
        n_ways[0][0] =1;

        for (int i=0; i<=n;i++){
            for(int j =0; j<=k; j++ ){
                if(j==0 && i>0){
                    n_ways[i][j] = 0;
                    continue;
                }
                if(j>0 && i==0){
                    n_ways[i][j] = 1;
                    continue;
                }
                for(int coin: coins){
                    if(i>= coin){
                        n_ways[i][j] += n_ways[i-coin][j-1];
                    }

                }
            }
            
            }
            return n_ways[n][k];
        }



}
