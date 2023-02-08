package Strings.morseDecoder;

public class MorseCodeDecoder {

    public static String decodeBits(String bits) {

        // . = 11       1{2}
        // - = 111111   1{6}
        // \\s = 000000  0{6} in word
        // \\s = 00000000000000 0{14} between words

        bits = trimZeroValuesFromBitString(bits);

        String pauseBetweenWords = "0{14}";
        String dashPattern = "1{6}";
        String spacePattern = "0{6}";
        String dotPattern = "1{2}";
        String garbagePattern = "0";

        bits = bits.replaceAll(pauseBetweenWords, "   ");
        bits = bits.replaceAll(dashPattern, "-");
        bits = bits.replaceAll(spacePattern, " ");
        bits = bits.replaceAll(dotPattern, ".");
        bits = bits.replaceAll(garbagePattern, "");


        return bits;
    }

    public static String trimZeroValuesFromBitString(String bits){

        int begin = 0;
        int end = bits.length();
        int i = 0;

        while (bits.charAt(i++)  == '0')
            begin++;

        i = bits.length() - 1;

        while (bits.charAt(i--) == '0')
            end--;

        return bits.substring(begin, end);
    }

    public static String decodeMorse(String morseCode) {

        String dashPattern = "-";
        String directSpaceBetweenWordsPattern = "\\s{3}";
        String directSpaceInsideWordsPattern = "\\s";
        String dotPattern = "\\.";
        String addBitsAfterDotPattern = "\\.(?!\\s)"; // find all chars ('.'), where next symbol isn't whitespace \\s
        String addBitsAfterDashPattern = "-(?!\\s)";  // find all chars ('-'), where next symbol isn't whitespace \\s

        morseCode = morseCode.replaceAll(addBitsAfterDotPattern, ".00");
        morseCode = morseCode.replaceAll(addBitsAfterDashPattern, "-00");
        morseCode = morseCode.replaceAll(directSpaceBetweenWordsPattern, "00000000000000");
        morseCode = morseCode.replaceAll(directSpaceInsideWordsPattern, "000000");
        morseCode = morseCode.replaceAll(dashPattern, "111111");
        morseCode = morseCode.replaceAll(dotPattern, "11");

        morseCode = trimZeroValuesFromBitString(morseCode);

        return morseCode;
    }

}
