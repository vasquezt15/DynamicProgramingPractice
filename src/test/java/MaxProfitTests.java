import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxProfitTests {
    @Test
    void MaxProfitTest() {
        int [][] prices = {{0,2,2,1},{3,1,1,1},{4,4,2,1}};
        ArrayList<Integer> path  = MaxProfit.maxProfit(prices);
        ArrayList<Integer> expected_path  = new ArrayList(Arrays.asList(14, 13, 11, 7, 3, 0));
        Assertions.assertEquals(expected_path, path , "Expected path: " + expected_path.toString() +"\n\n" + " Actual: " + path.toString());
    }

    
}
