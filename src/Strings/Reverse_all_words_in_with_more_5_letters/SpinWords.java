package Strings.Reverse_all_words_in_with_more_5_letters;

public class SpinWords {

//    Write a function that takes in a string of one or more words,
//    and returns the same string, but with all five or more letter words reversed.
//    Strings passed in will consist of only letters and spaces.
//    Spaces will be included only when more than one word is present.

//    spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
//    spinWords( "This is a test") => returns "This is a test"
//    spinWords( "This is another test" )=> returns "This is rehtona test"

    public String spinWords(String sentence) {
        String[] strings = sentence.split(" ");

        for (int i = 0; i < strings.length; i++) {
            if(strings[i].length() >= 5)
                strings[i] = reverseString(strings[i]);
        }

        String result = "";
        for (int i = 0; i < strings.length; i++) {
            result = result.concat(strings[i].concat(" "));
        }


        // OR 2nd varient
//        String[] words = sentence.split(" ");
//        for (int i=0; i<words.length; i++) {
//            if (words[i].length() >= 5) {
//                words[i] = new StringBuilder(words[i]).reverse().toString();
//            }
//        }
//        return String.join(" ",words);
//    }

        return result.trim();
    }

    private static String reverseString(String rawString){

        byte[] rawByteArrayString = rawString.getBytes();
        byte[] reverseString = new byte[rawByteArrayString.length];

        for (int i = 0; i < rawByteArrayString.length; i++) {
            reverseString[i] = rawByteArrayString[rawByteArrayString.length - i - 1];
        }

        return new String(reverseString);
    }

}
