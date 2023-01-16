package Sum_of_Digits_OR_Digital_Root;

public class DRoot {

//    Digital root is the recursive sum of all the digits in a number.
//     16  -->  1 + 6 = 7
//     942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
//     132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6

    public static int digital_root(int n) {

        String numbers = String.valueOf(n);
        char[] charNumbers = numbers.toCharArray();
        int summa = 0;

        for (char charNumber : charNumbers) {
            summa += Character.getNumericValue(charNumber);;
        }

        if(summa >= 10)
            return digital_root(summa);
        else return summa;
    }

    public static int digital_root2(int n){
        return (n != 0 && n%9 == 0) ? 9 : n % 9;
    }

}
