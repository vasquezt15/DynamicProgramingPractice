import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;

public class CountingStairsTests {
    //test cases for stairs
    @Test
    void stairsTestRunWithZero() {
        assertEquals(1, CountStairs.stairs(0), "Stairs for 0 should be 1");
    }
    @Test
    void stairsTestRunWithOne() {
        assertEquals(1, CountStairs.stairs(1), "Stairs for 1 should be 1");
    }
    @Test
    void stairsTestRunWithFive() {
        Assertions.assertEquals(8, CountStairs.stairs(5), "Stairs for 5 should equal 8");
    }
}
