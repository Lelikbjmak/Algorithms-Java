package Strings.Valid_Braces;

import java.util.Stack;

public class BraceChecker {

    public boolean isValid(String braces) {

        if(braces.length() % 2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < braces.length(); i++) {
            char c = braces.charAt(i);

            if(c == '[' || c == '(' || c == '{' ) {
                stack.push(c);
            } else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }

        }
        return stack.isEmpty();


        // 2nd varient
//        for(int i=0;i<braces.length()/2;i++)
//        {
//            braces = braces.replaceAll("\\(\\)", "");
//            braces = braces.replaceAll("\\[\\]", "");
//            braces = braces.replaceAll("\\{\\}", "");
//            if(braces.length() == 0)
//                return true;
//        }
//        return false;
    }

}
