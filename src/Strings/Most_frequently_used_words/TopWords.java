package Strings.Most_frequently_used_words;

import java.util.*;
import java.util.stream.Collectors;

public class TopWords {

//    Write a function that, given a string of text (possibly with punctuation and line-breaks), returns an array of the top-3 most occurring words, in descending order of the number of occurrences.
//
//    Assumptions:
//    A word is a string of letters (A to Z) optionally containing one or more apostrophes (') in ASCII.
//    Apostrophes can appear at the start, middle or end of a word ('abc, abc', 'abc', ab'c are all valid)
//    Any other characters (e.g. #, \, / , . ...) are not part of a word and should be treated as whitespace.
//    Matches should be case-insensitive, and the words in the result should be lowercased.
//    Ties may be broken arbitrarily.
//    If a text contains fewer than three unique words, then either the top-2 or top-1 words should be returned, or an empty array if a text contains no words.

    //Not working on codeWars :(
    public static List<String> top3(String s) {

        if(s.isBlank())
            return new ArrayList<>();

        s = s.replaceAll("[-,.#_/\\\\]+", " ");
        String[] words = s.split("\\s+");

        Map<String, Integer> distinctWords = new HashMap<>();

        for (String word:
             words) {

            if(distinctWords.containsKey(word))
                distinctWords.put(word, distinctWords.get(word) + 1);
            else
                distinctWords.put(word, 1);

        }

        List<String> topWords = distinctWords.entrySet().stream()
                .filter(entry -> !entry.getKey().isBlank() && !entry.getKey().matches("'+"))
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        return topWords;
    }

}
