package Strings.sumStringsAsNumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumStringAsNumberTest {

    @Test
    public void test(){
        Assertions.assertEquals("579", SumStringAsNumber.sumStrings("123", "456"));
    }
}
