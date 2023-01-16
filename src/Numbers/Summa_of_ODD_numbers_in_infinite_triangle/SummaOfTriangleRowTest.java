package Numbers.Summa_of_ODD_numbers_in_infinite_triangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SummaOfTriangleRowTest {

    @Test
    public void test(){
        Assertions.assertEquals(1, SummaOfTriangleRow.summaOfRawNumber(1));
        Assertions.assertEquals(74088, SummaOfTriangleRow.summaOfRawNumber(42));
    }

}
