public class CountStairs {
    public static int stairs(int n){
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
    
}
