package org.example.in28mins;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;

public class FunctionalInterfaceStream {

    public static void main(String[] args) {

        List<Integer> integers = List.of(2, 12, 9, 12, 4, 9, 7, 45, 34, 234, 2, 35, 34, 67, 75);
        List<String> courses = List.of("Spring", "Spring Boot", "AWS", "GCP", "Spring JPA");
        List<Integer> randomIntegers = new ArrayList<>();

        Function<Integer, Integer> getSquared = x->x*x;

        List<Integer> collect = integers.stream().map(getSquared).collect(Collectors.toList());
        System.out.println(collect);

        // supplier to generate random numbers
        Supplier<Integer> generateRandomNumbers = ()->{
            Random random = new Random();
            return random.nextInt(100);
        };
        for (int i = 0; i < 20; i++) {
            randomIntegers.add(generateRandomNumbers.get());
        }
        System.out.println(randomIntegers);

        // BiPredicate
        BiPredicate<Integer, String> biPredicate = (number, string) -> number<10 && string.length()>5;
        System.out.println(biPredicate.test(7, "Mohnish"));

        //biFunction
        BiFunction<Integer, String, String> biFunction = (x,y) -> y + " score is - "+x;
        System.out.println(biFunction.apply(80, "Ram"));

        //BiConsumer
        BiConsumer<Integer, String> biConsumer = (x,y) -> System.out.println(x+"  "+y);
        biConsumer.accept(10, "world");

        //binary operator - takes two parameters of same type and return the result of same type
        BinaryOperator<Integer> binaryOperator = (x,y)-> x+y;
        System.out.println(binaryOperator.apply(10,20));

        //unary operator
        UnaryOperator<Integer> squaredNumber = x -> x*x;
        List<Integer> collect1 = integers.stream().map(squaredNumber).collect(Collectors.toList());
        System.out.println(collect1);

        // Method references
        courses.stream()
                .map(String::toUpperCase) // instance method reference
                .forEach(getPrintln());  // static method reference

        Supplier<String> newString = String::new; // constructor method reference

    }

    private static Consumer<String> getPrintln() {
        return System.out::println;
    }


}
