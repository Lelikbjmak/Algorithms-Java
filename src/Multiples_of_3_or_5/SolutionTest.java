package Multiples_of_3_or_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void test() {
        Assertions.assertEquals(23, new Solution().solution2(10));
    }
}
