package com.practice.linkedin.functional.programming;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterExample {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        List<Integer> numbers = Arrays.asList(arr);
        //find even numbers
        Predicate<Integer> isEvenNumber = (x) -> x % 2 == 0;

        List<Integer> evenNumberList = numbers.stream()
                .filter(isEvenNumber)
                .collect(Collectors.toList());
        System.out.println(evenNumberList);

        // To create Higher order function
        Function<Integer, Predicate<Integer>> numDivBy = (x) -> (y) -> y % x == 0;

        Predicate<Integer> isDivisibleBy3 = numDivBy.apply(3);

        Predicate<Integer> isDivisibleBy4 = numDivBy.apply(4);

        System.out.println("Printing number divisible by 3");
        List<Integer> numDivBy3List = numbers
                .stream()
                .filter(isDivisibleBy3)
                .collect(Collectors.toList());

        System.out.println(numDivBy3List);

        System.out.println("Printing number divisible by 4");
        List<Integer> numDivBy4List = numbers
                .stream()
                .filter(isDivisibleBy4)
                .collect(Collectors.toList());

        System.out.println(numDivBy4List);

        String[] words = {
                "hello", "functional", "programming", "is", "cool"
        };

        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        Predicate<String> wordLengthGreaterThan5 = (str) -> str.length() > 5;

        List<String> filteredList = wordList.stream()
                .filter(wordLengthGreaterThan5)
                .collect(Collectors.toList());
        System.out.println(filteredList);

        Function<Integer, Predicate<String>> variableLengthWordFilter
                = (length) -> (str) -> str.length() > length;

        Predicate<String> wordsLengthGreaterThan4 = variableLengthWordFilter.apply(4);

        List<String> wordsGreaterThan4 = wordList.stream()
                .filter(wordsLengthGreaterThan4)
                .collect(Collectors.toList());

        System.out.println(wordsGreaterThan4);

        Predicate<String> wordsLengthGreaterThan10 = variableLengthWordFilter.apply(10);
        List<String> wordsGreaterThan10 = wordList.stream()
                .filter(wordsLengthGreaterThan10)
                .collect(Collectors.toList());

        System.out.print(wordsGreaterThan10);


    }
}
