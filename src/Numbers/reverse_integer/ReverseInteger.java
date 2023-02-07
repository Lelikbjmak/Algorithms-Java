package Numbers.reverse_integer;

public class ReverseInteger {

    public static int reverseIntegerVariableFirst(int num){

        if (num < 10)
            return num;

        int reverse = 0;

        for ( ; num != 0; num = num / 10) {
            int lastDigit = num % 10;
            reverse = reverse * 10 + lastDigit;
        }

        return reverse;
    }

    public static void reverseIntegerVariableSecond(int num){

        if (num < 10) {
            System.out.println(num);
            return;
        } else {
            System.out.println(num % 10);
            reverseIntegerVariableSecond(num / 10);
        }

    }

}
