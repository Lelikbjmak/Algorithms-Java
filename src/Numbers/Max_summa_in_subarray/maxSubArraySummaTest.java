package Numbers.Max_summa_in_subarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class maxSubArraySummaTest {

    @Test
    public void testEmptyArray() throws Exception {
        assertEquals(0, maxSubArraySumma.sequence(new int[]{}));
    }
    @Test
    public void testExampleArray() throws Exception {
        assertEquals(6, maxSubArraySumma.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
