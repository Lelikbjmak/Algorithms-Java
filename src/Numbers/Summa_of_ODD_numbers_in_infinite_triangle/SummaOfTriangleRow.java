package Numbers.Summa_of_ODD_numbers_in_infinite_triangle;

public class SummaOfTriangleRow {

    // Enter the number of row -> must obtain summa of all elements in a row
    //            1
    //          3   5
    //        7   9   11
    // example of such triangle : input 1 -> 1; input 2 -> 3+5 = 8 etc...
    //input 2 -> 3+5 = 8 (2^3)  input 3 -> 7+9+11=27 (3^3)  input 4 -> 13+15+17+19 = 64 (4^3)



    public static int summaOfRawNumber(int rawNumber){
        return rawNumber * rawNumber * rawNumber;
    }
}
