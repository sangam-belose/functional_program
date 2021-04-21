package com.practice.linkedin.functional.programming;

import java.util.function.BiFunction;
import java.util.function.Function;

public class HigherOrderFunction {
    public static void main(String[] args) {

        BiFunction<Float, Float, Float> divide = (x, y) -> x / y;

        Function<BiFunction<Float, Float, Float>,
                BiFunction<Float, Float, Float>> check2ndArgument = (func) -> (x, y) -> {
            if (y == 0f) {
                System.err.println("Cant devide by zero");
                return 0f;
            }
            return func.apply(x, y);
        };

        BiFunction<Float, Float, Float> divideSafe =  check2ndArgument.apply(divide);
        System.out.println(divideSafe.apply(2.0f, 0.0f));


    }
}
