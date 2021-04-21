package com.practice.linkedin.functional.programming;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceExample {

    public static void main(String[] args) {

        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> numbers = Arrays.asList(arr);

        BinaryOperator<Integer> sum = (acc, x) -> {
            Integer result = acc + x;
            System.out.println("acc = " + acc + ", x = " + x + ", result = " + result);
            return result;
        };

       Integer sumOfNumbers =  numbers.stream()
                .reduce(0, sum);
       System.out.println(sumOfNumbers);


    }
}
