package Numbers.Sum_of_Digits_OR_Digital_Root;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DRootTest {

    @Test
    public void Test1() {
        Assertions.assertEquals( 7, DRoot.digital_root(16));
    }

    @Test
    public void Test2() {
        Assertions.assertEquals(6, DRoot.digital_root(456));
    }

}
