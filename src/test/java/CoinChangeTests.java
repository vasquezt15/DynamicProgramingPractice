import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoinChangeTests {
    @Test
    void CoinChangeBasic1() {
        int [] coins = {1,3,5,10};
        int n = 0;
        int n_ways = CoinChange.makeChange(n, coins);

        Assertions.assertEquals(1,n_ways , "n_ways = 1 for coins [1,3,5,10] and n =0");
    }
    @Test
    void CoinChangeBasic2() {
        int [] coins = {1,3,5,10};
        int n = 3;
        int n_ways = CoinChange.makeChange(n, coins);

        Assertions.assertEquals(2,n_ways , "n_ways = 2 for coins [1,3,5,10] and n =3");
    }
    @Test
    void CoinChangeBasic3() {
        int [] coins = {1,3,5,10};
        int n = 4;
        int n_ways = CoinChange.makeChange(n, coins);

        Assertions.assertEquals(3,n_ways , "n_ways = 3 for coins [1,3,5,10] and n =4");
    }
    @Test
    void CoinChangek1() {
        int [] coins = {1,2,3,5};
        int n = 0;
        int k = 0;
        int n_ways = CoinChange.makeChangek(n,k, coins);

        Assertions.assertEquals(1,n_ways , "n_ways = 1 for coins [1,2,3,5] and n =0, k=0");
    }

    @Test
    void CoinChangek2() {
        int [] coins = {1,2,3,5};
        int n = 7;
        int k = 3;
        int n_ways = CoinChange.makeChangek(n,k, coins);

        Assertions.assertEquals(9,n_ways , "n_ways = 9 for coins [1,2,3,5] and n =7, k=3");
    }
}
