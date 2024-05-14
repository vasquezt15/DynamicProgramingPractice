
/*
     * Problem:  How many ways to pain n stairs with two colors such that no more than two stairs are painted the same color
     * Objective Function: F(i,j) is the number of ways to paint the ith stair ending in a post painted in j
     * Base Case: F(1,0) = 1, F(1,1) = 1, F(2,0) = 2, F(2,1) = 2
     * Recurrence Relation: F(i,j) = F(i-1,j-1) +F(i-2,j-1)
     * Order of Execution: Bottom up
     * Answer: F(n)
     * 
     */

public class PaintStairs {

    public int painStairs(int n){
        int [][] n_ways = new int[n][2];
        n_ways[1][0] = 1;
        n_ways[1][1] = 1;
        n_ways[2][0] = 2;
        n_ways[2][1] = 2;
        for(int i =3; i<=n; i++){
            for(int j =0; j<=1;j++){
                n_ways[i][j] = n_ways[i-1][j-1] + n_ways[i-2][j-1];
            }
        }
        return n_ways[n][0] + n_ways[n][1];

    }
    
}
