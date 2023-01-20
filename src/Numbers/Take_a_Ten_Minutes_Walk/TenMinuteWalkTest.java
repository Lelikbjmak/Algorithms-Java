package Numbers.Take_a_Ten_Minutes_Walk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TenMinuteWalkTest {

    @Test
    public void Test() {
        assertTrue(TenMinuteWalk.isValid(new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}), "Should return false");
        assertFalse(TenMinuteWalk.isValid(new char[]{'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e'}), "Should return false");
        assertFalse(TenMinuteWalk.isValid(new char[]{'w'}), "Should return false");
        assertFalse(TenMinuteWalk.isValid(new char[]{'n', 'n', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}), "Should return false");
    }

}
