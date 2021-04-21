package com.practice.linkedin.functional.programming;

import java.util.function.BiFunction;
import java.util.function.Function;

public class PassFuncAsArg {

    protected static class MyMath {
        public static Integer add(int x, int y) {
            return x + y;
        }

        public static Integer subtract(int x, int y) {
            return x - y;
        }

        public static Integer combine2and3(BiFunction<Integer, Integer, Integer> combine){
            return combine.apply(2, 3);
        }
    }

    public static void main(String[] args) {
        System.out.println(MyMath.combine2and3(MyMath::add));
        System.out.println(MyMath.combine2and3(MyMath::subtract));
        System.out.println(MyMath.combine2and3((x, y) -> 2*x +2+y));
    }
}
