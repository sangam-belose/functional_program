package com.practice.linkedin.functional.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapExample {

    public static void main(String[] args) {

        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        List<Integer> numbers = Arrays.asList(arr);

        Function<Integer, Integer> makeDouble = (x) -> x * 2;

        List<Integer> doubleNumberList = numbers.stream()
                .map(makeDouble)
                .collect(Collectors.toList());
        System.out.print(doubleNumberList);

    }
}
