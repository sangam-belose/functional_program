package com.practice.linkedin.functional.programming;
import java.util.function.Function;
public class LambdaExample {
    public static void main(String[] args) {

        Function<Integer, Integer> absoluteValue = (x) -> {
            if (x < 0) {
                // negative sign multiplies the negative number so it becomes positive
                return -x;
            } else{
                return x;
            }
        };
        System.out.println(absoluteValue.apply(100));
        System.out.println(absoluteValue.apply(-100));
    }
}
