

public class app {

    public static void main(String[] args) {
        
        int n = Integer.parseInt(args[0]);
        int result_n_sum = Nsum.n_sum(n);
        int result_stairs = ClimbStairs.climbStairsTwoSteps(n);
        System.out.printf("n_sum %d stairs %d",result_n_sum,result_stairs);
    }
    
}
