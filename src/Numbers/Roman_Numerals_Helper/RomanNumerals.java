package Numbers.Roman_Numerals_Helper;

import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {

    public static String toRoman(int n) {

        int[] ints = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        // non-repeatable romans...

        StringBuilder intToRoman = new StringBuilder();
        for (int i = 0; i < ints.length; i++) {

            while (n >= ints[i]){
                n-=ints[i];
                intToRoman.append(romans[i]);
            }

        }

        return intToRoman.toString();
    }

    public static int fromRoman(String romanNumeral) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        // we avoid all *X *C *V nums -> replace them with X* C* V* like (IV = IIII, IX = VIIII etc)
        romanNumeral = romanNumeral.replace("IV","IIII");
        romanNumeral = romanNumeral.replace("IX","VIIII");
        romanNumeral = romanNumeral.replace("XL","XXXX");
        romanNumeral = romanNumeral.replace("XC","LXXXX");
        romanNumeral = romanNumeral.replace("CD","CCCC");
        romanNumeral = romanNumeral.replace("CM","DCCCC");

        int romanToInt = 0;

        for (int i = 0; i < romanNumeral.length(); i++) {
            romanToInt += map.get(romanNumeral.charAt(i));
        }

        return romanToInt;
    }

}
