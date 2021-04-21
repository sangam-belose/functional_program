package com.practice.linkedin.functional.programming;

import java.util.function.Function;

public class FirstClassFunctionExample {

    protected static class MathFunctions {

        static Integer tripple(Integer a) {
            return a * 3;
        }
    }

    public static void main(String[] args) {
        //static function call
        Function<Integer, Integer> mathFunction = MathFunctions::tripple;
        Integer trippleResult = mathFunction.apply(3);
        System.out.println("triple value through first class function: " + trippleResult);

        //instance method call
        StringFunction stringFunction = new StringFunction();
        Function<String, String> stringFun = stringFunction::toLowerCaseString;
        System.out.println("Calling instance class method using method reference: "+stringFun.apply("WELCOME"));

    }
}

    class StringFunction {

        public String toLowerCaseString(String a) {
            return a.toLowerCase();
        }
    }
