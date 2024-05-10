import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


 /*
     * Problem: Walk through the matrix one square at a time. Return the path that maximes profit.
     * Objective Function: F(i,j) the max profit up to the i,j step
     * Base Case: F(i,j) = prices[0,0]
     * Recurrence Relation: F(i,j) = max(F(i-1,j) +F(i-1,j)) + prices[i,j] // 
     * Order of Execution: Bottom up
     * Answer: F(n,m) for an nxm price matrix
     * 
     */
public class MaxProfit {
    public static ArrayList<Integer> maxProfit(int [][] prices){
        int[][] profits = new int[prices.length][prices[0].length];
        ArrayList<Integer> path = new ArrayList();
        //path.add(0);
        //ArrayList<Node> path = new ArrayList<>();
        //Walk thro
        //path.add(new Node(0,0,prices[0][0]));
        //initialize profits
        //ArrayList<Integer> list = new ArrayList<>();
        //list.add(0);
        //profits.add(list);
        profits[0][0] = prices[0][0];
        Integer previous_profit = 0;
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<prices[0].length;j++){
                //System.out.printf(" i: %d j: %d \n ",i, j);
                if(j==0 && i==0){continue;}
                int up_cell;
                int left_cell;
                int max_profit;
                int new_profit = prices[i][j];
                if(i>0 && j>0){
                    up_cell = profits[i-1][j];
                    left_cell = profits[i][j-1];
                    max_profit = Math.max(up_cell,left_cell);
                    new_profit += max_profit;
                    
                    
                   
                }else if(j>0){
                    left_cell = profits[i][j-1];
                    max_profit = left_cell;
                    new_profit += max_profit ;

                }else{
                    max_profit = profits[i-1][j];
                    new_profit += max_profit;
                }
                profits[i][j] = new_profit;
                //System.out.printf(" i: %d j: %d max_p %d\n ",i, j,new_profit);
                    //if(max_profit != previous_profit){
                        //path.add(profits[i][j]);
                        //System.out.println(path);
                    //}

                    
                
            }

        }
        
        // for(Node node: path){
        //     System.out.printf( node.toStringNode()+ " ");
        // }
        
        // for (int[] row : profits) {
        //     for (int element : row) {
        //         System.out.print(element + " ");
        //     }
        //     System.out.println(); // Move to the next line after each row
        // }
        //System.out.println(Arrays.toString(profits));
        int i=prices.length-1;
        int j = prices[0].length-1;
        int current = profits[i][j];
        path.add(current);

        while(i > 0 || j >0){
            if(i>0 && j>0){
                int up = profits[i-1][j];
                int left = profits[i][j-1];
                current = Math.max(up,left);
                if(current == up){
                    i--;
                }else{
                    j--;
                }
            }else if(i>0){
                current = profits[i-1][j];
                i--;
            }else{
                current = profits[i][j-1];
                j--;

            }
            path.add(current);
        }
        //System.out.println(path);
        return path;
    }
}
