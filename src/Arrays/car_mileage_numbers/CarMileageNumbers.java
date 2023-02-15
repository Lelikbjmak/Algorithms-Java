package Arrays.car_mileage_numbers;

public class CarMileageNumbers {

    private static final String INCREMENTING_STRING = "1234567890";
    private static final String DECREMENTING_STRING = "9876543210";
    public static int isInteresting(int number, int[] awesomePhrases) {

        if (number < 98)
            return 0;
        else if (number < 100) { // indicates equals 98/99
            return 1;
        } else {  // numeric is grater or equals 100

            // flawless case - number is interesting
            if (isAwesome(number, awesomePhrases))
                return 2;
            else if (isFollowByAllZeros(number))
                return 2;
            else if(isTheSameNumbers(number))
                return 2;
            else if (isSequentialIncrementing(number))
                return 2;
            else if(isSequentialDecrementing(number))
                return 2;
            else if(isPalindrome(number))
                return 2;

            // number is good/ but not interesting (difference = 1/2)

            if (isAwesome(number + 1, awesomePhrases) || isAwesome(number + 2, awesomePhrases))
                return 1;
            else if (isFollowByAllZeros(number + 1) || isFollowByAllZeros(number + 2))
                return 1;
            else if(isTheSameNumbers(number + 1) || isTheSameNumbers(number + 2))
                return 1;
            else if (isSequentialIncrementing(number + 1) || isSequentialIncrementing(number + 2))
                return 1;
            else if(isSequentialDecrementing(number + 1) || isSequentialDecrementing(number + 2))
                return 1;
            else if(isPalindrome(number + 1) || isPalindrome(number + 2))
                return 1;
        }

        return 0;
    }

    private static boolean isPalindrome(int number) {
        String stringNumber = Integer.toString(number);
        return new StringBuilder(stringNumber).reverse().toString().equals(stringNumber);
    }

    private static boolean isSequentialDecrementing(int number) {
        String stringNumber = Integer.toString(number);
        return DECREMENTING_STRING.contains(stringNumber);
    }

    private static boolean isSequentialIncrementing(int number) {
        String stringNumber = Integer.toString(number);
        return INCREMENTING_STRING.contains(stringNumber);
    }

    private static boolean isTheSameNumbers(int number) {

        int digit = number % 10;

        while (number != 0) {
            int last_digit = number % 10;
            number = number / 10;
            if (last_digit != digit) {
                return false;
            }
        }
        return true;
    }

    private static boolean isFollowByAllZeros(int number) {
        String stringNumber = Integer.toString(number);
        return ((int) stringNumber.charAt(0) - 48 > 0)  // first digit is not 0
                &&
                stringNumber.substring(1)
                        .equals("0".repeat(stringNumber.length() - 1)); // all remain digits are 0
    }

    private static boolean isAwesome(int number, int[] awesomePhrases) {

        for (Integer i:
             awesomePhrases) {
            if(i.equals(number))
                return true;
        }

        return false;
    }


}
