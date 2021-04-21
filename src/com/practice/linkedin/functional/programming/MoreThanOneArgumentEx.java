package com.practice.linkedin.functional.programming;

import java.util.function.BiFunction;

public class MoreThanOneArgumentEx {
    public static Integer addTwoMethodRef(Integer a, Integer b){
        return a+b;
    }
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x+y;
        System.out.println(add.apply(20, 40));

        BiFunction<Integer, Integer, Integer> addUsingMethodRef = MoreThanOneArgumentEx::addTwoMethodRef;
        System.out.println(addUsingMethodRef.apply(30, 20));

        TriFunction<Integer, Integer, Integer, Integer> addThree = (x, y, z) -> x+y+z;
        System.out.println(addThree.apply(20, 30, 40));

        NoArgFunction<String> noArgFunction = () -> "Hello Sangam";
        System.out.println(noArgFunction.apply());

    }
}
