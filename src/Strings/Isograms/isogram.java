package Strings.Isograms;

import java.util.Arrays;

public class isogram {

//    An isogram is a word that has no repeating letters, consecutive or non-consecutive.
//    Implement a function that determines whether a string that contains only letters is an isogram.
//    Assume the empty string is an isogram. Ignore letter case.
//    Example: (Input --> Output)

    public static boolean isIsogram(String str) {
        str = str.toLowerCase();
        char[] symbols = str.toCharArray();


        char temp;

        int k = 0;
        while (k < symbols.length) {
            int j = k + 1;
            while (j < symbols.length) {
                if (symbols[j] < symbols[k]) {

                    // Comparing the characters one by one
                    temp = symbols[k];
                    symbols[k] = symbols[j];
                    symbols[j] = temp;
                }
                j += 1;
            }
            k += 1;
        }

       // Arrays.sort(symbols);
        for (int i = 0; i < symbols.length - 1; i++) {
            if(symbols[i] == symbols[i+1])
                return false;
        }

        return true;
    }

}
