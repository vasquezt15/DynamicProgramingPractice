

public class app {

    public static void main(String[] args) {
        
        //int n = Integer.parseInt(args[0]);
        //Boolean [] red_stairs = {false,false,false,false,false,false,false,false};
        int [][] prices = {{0,2,2,1},{3,1,1,1},{4,4,2,1}};
        int maxprofit = MaxProfit.maxProfit(prices);
        System.out.println(maxprofit);
    }
    
}
