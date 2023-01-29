package Strings.sumStringsAsNumber;

public class SumStringAsNumber {
    private final static int UNICODE_OF_ZERO_DIGIT_X_2 = 96;
    private final static int UNICODE_OF_ZERO_DIGIT = 48;
    private final static int DIVISION = 10;
    public static String sumStrings(String a, String b) {

        a = a.replaceFirst("^0+(?!$)", ""); // trim all 0 at the beginning of the String
        b = b.replaceFirst("^0+(?!$)", ""); // trim all 0 at the beginning of the String

        char[] longString = null;
        char[] shortString = null;

        if (a.length() > b.length()) {
            longString = a.toCharArray();
            shortString = b.toCharArray();
        } else {
            longString = b.toCharArray();
            shortString = a.toCharArray();
        }

        int addition = 0;

        StringBuilder res = new StringBuilder();

        for (int i = longString.length - 1, j = shortString.length - 1; j > -1; i--, j--) {
            int temporal = longString[i] + shortString[j] - UNICODE_OF_ZERO_DIGIT_X_2 + addition;
            res.append(temporal % DIVISION);
            addition = temporal / DIVISION;
        }

        if (addition > 0)
            for (int i = longString.length - shortString.length - 1; i > -1; i--) {
                int temporal = longString[i] - UNICODE_OF_ZERO_DIGIT + addition;
                res.append(temporal % DIVISION);
                addition = temporal / DIVISION;
            }
        else
            for (int i = longString.length - shortString.length - 1; i > -1; i--) {
                int temporal = longString[i] - UNICODE_OF_ZERO_DIGIT;
                res.append(temporal % DIVISION);
            }

        if (addition > 0)
            res.append(addition);

        return res.reverse().toString();
    }

}
