package com.practice.linkedin.functional.programming;

import java.util.function.Function;

public class HighOrderFunction {
    protected static class MyMath {
        public static Function<Integer, Integer> createMultiplier(Integer y) {
            return (Integer x) -> x * y;
        }
    }

    public static void main(String[] args) {
        System.out.println(MyMath.createMultiplier(2).apply(6));
        System.out.println(MyMath.createMultiplier(3).apply(6));
        System.out.println(MyMath.createMultiplier(4).apply(6));
    }
}
