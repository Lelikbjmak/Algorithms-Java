package Strings.Highest_scoring_word;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class HighestScoringWord {

//    Given a string of words, you need to find the highest scoring word.
//    Each letter of a word scores points according to its position in the alphabet: a = 1, b = 2, c = 3 etc.
//    For example, the score of abad is 8 (1 + 2 + 1 + 4).
//    You need to return the highest scoring word as a string.
//    If two words score the same, return the word that appears earliest in the original string.
//    All letters will be lowercase and all inputs will be valid.

    public static String high(String s) {

        String[] words = s.split(" ");
        int[] score = new int[words.length];
        final int def = 96;

        for (int j = 0; j < words.length; j++) {

            char[] st = words[j].toCharArray();
            int summa = 0;

            for (int i = 0; i < st.length; i++) {
                summa+=(st[i] - def);
            }

            score[j] = summa;
            System.out.println(Arrays.toString(st) + " = " + summa);
        }

        int max = Arrays.stream(score).max().getAsInt();

        for (int i = 0; i < score.length; i++) {

            if(score[i] == max) {
                return words[i];
            }

        }

    //2nd var
    //        return Arrays.stream(s.split(" "))
    //                .max(Comparator.comparingInt(
    //                        a -> a.chars().map(i -> i - 96).sum()
    //                )).get();

        return "";
    }

}
