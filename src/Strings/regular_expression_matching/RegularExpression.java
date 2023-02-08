package Strings.regular_expression_matching;

public class RegularExpression {

    public boolean isMatch(String text, String pattern) {

        //'.' - 1 any char
        //'*' - any chars

        if (pattern.isEmpty())
            return text.isEmpty();
        // It is guaranteed for each appearance of the character '*', there will be a previous valid character to match. hence -> found first match
        boolean firstMatch = (!text.isEmpty() &&
                (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.'));


        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (firstMatch && isMatch(text.substring(1), pattern)));
        } else
            return firstMatch && isMatch(text.substring(1), pattern.substring(1));
    }
}
