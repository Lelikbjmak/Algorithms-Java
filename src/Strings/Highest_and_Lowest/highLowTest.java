package Strings.Highest_and_Lowest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class highLowTest {
    @Test
    public void test1() {
        assertEquals("42 -9", highLow.highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }
    @Test
    public void test2() {
        assertEquals("3 1", highLow.highAndLow("1 2 3"));
    }
}
