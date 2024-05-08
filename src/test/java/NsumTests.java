import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;

class NsumTests {
    //test cases for n sum 
     @Test
    void nSumTestRunWithZero() {
        assertEquals(0, Nsum.n_sum(0), "Sum for 0 should be 0");
    }
    @Test
    void nSumTestRunWithOne() {
        assertEquals(1, Nsum.n_sum(1), "Sum for 1 should be 1");
    }
    @Test
    void nSumTestRunWithFive() {
        Assertions.assertEquals(15, Nsum.n_sum(5), "Sum for 5 should equal 15");
    }
    
}