public class Nsum {

    public static int n_sum(int n){
        int [] sums = new int[n+1];
        sums[0] = 0;
        for(int i=1;i<=n;i++){
            sums[i] = sums[i-1] +i;
        }
        return sums[n];
    }
   
   
}
