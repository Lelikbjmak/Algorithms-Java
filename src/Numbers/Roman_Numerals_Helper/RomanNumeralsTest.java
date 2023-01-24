package Numbers.Roman_Numerals_Helper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomanNumeralsTest {

    @Test
    public void testToRoman() throws Exception {
        Assertions.assertEquals("I", RomanNumerals.toRoman(1), "1 converts to 'I'");
        Assertions.assertEquals("II", RomanNumerals.toRoman(2), "2 converts to 'II'");
    }

    @Test
    public void testFromRoman() throws Exception {
        Assertions.assertEquals(1, RomanNumerals.fromRoman("I"), "'I' converts to 1");
        Assertions.assertEquals(2, RomanNumerals.fromRoman("II"), "'II' converts to 2");
    }

}
