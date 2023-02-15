package Arrays.car_mileage_numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarMileageNumbersTest {

    @Test
    public void testTooSmall() {
        assertEquals(0, CarMileageNumbers.isInteresting(3, new int[]{1337, 256}));
    }

    @Test
    public void testAlmostAwesome() {
        assertEquals(1, CarMileageNumbers.isInteresting(1336, new int[]{1337, 256}));
    }

    @Test
    public void testAwesome() {
        assertEquals(2, CarMileageNumbers.isInteresting(1337, new int[]{1337, 256}));
    }

    @Test
    public void testFarNotInteresting() {
        assertEquals(0, CarMileageNumbers.isInteresting(11208, new int[]{1337, 256}));
    }

    @Test
    public void testAlmostInteresting() {
        assertEquals(1, CarMileageNumbers.isInteresting(11209, new int[]{1337, 256}));
    }

    @Test
    public void testInteresting() {
        assertEquals(2, CarMileageNumbers.isInteresting(11211, new int[]{1337, 256}));
    }

    @Test
    public void testInterestingLeadingZeros() {
        assertEquals(2, CarMileageNumbers.isInteresting(200, new int[]{1337, 256}));
    }
}
