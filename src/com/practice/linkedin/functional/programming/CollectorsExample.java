package com.practice.linkedin.functional.programming;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsExample {

    public static void main(String[] args) {
        String[] words = {
                "hello", "functional", "programming", "is", "cool", "functional"
        };

        List<String> wordList = new ArrayList<>(Arrays.asList(words));

        //Simple List collector
        System.out.println("Simple list collector");
        List<String> listCollector = wordList.stream()
                .filter(str -> str.length() > 5)
                .collect(Collectors.toList());
        System.out.println(listCollector);

        //Simple Set collector
        System.out.println("Using set collector to avoid duplicates");
        Set<String> setCollector = wordList.stream()
                .filter(str -> str.length() > 5)
                .collect(Collectors.toSet());
        System.out.println(setCollector);

        //Collectors joining output
        System.out.println("join output by delimiter");
        String joinedString = wordList.stream()
                .filter(str -> str.length() > 5)
                .collect(Collectors.joining("=="));
        System.out.println(joinedString);

        //Collectors counting output

        System.out.println("count output");
        Long count = wordList.stream()
                .filter(str -> str.length() > 5)
                .collect(Collectors.counting());
        System.out.println(count);

        //Collectors grouping output
        System.out.println("Group output by word length");
        Map<Integer, List<String>> wordLengthMap = wordList.stream()
                .collect(Collectors.groupingBy((word) -> word.length()));
        System.out.println(wordLengthMap);

        //Collectors Partitioning output by (
        System.out.println("Group output by predicate partition into 2 partition");
        Map<Boolean, List<String>> groupByWordCount = wordList.stream()
                .collect(Collectors.partitioningBy((word) -> word.length() > 5));
        System.out.println(groupByWordCount);
    }
}
