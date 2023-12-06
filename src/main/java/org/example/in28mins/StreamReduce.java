package org.example.in28mins;

import javax.sound.midi.Soundbank;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamReduce {

    public static void main(String[] args) {
        List<Integer> integers = List.of(2, 12, 9, 12, 4, 9, 7, 45, 34, 234, 2, 35, 34, 67, 75);
        List<String> courses = List.of("Spring", "Spring Boot", "AWS", "GCP", "Spring JPA","cloud","Docker");

        System.out.println("add all the numbers");
        Integer sum = integers.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        System.out.println();

        System.out.println("square every number on list and find sum of them");
        int sqSum = integers.stream().map(i -> i * i).reduce(0, Integer::sum).intValue();
        System.out.println(sqSum);
        System.out.println();

        System.out.println("sum of odd number on the list");
        int oddSum = integers.stream().filter(i -> i%2!=0).reduce(0, Integer::sum);
        System.out.println(oddSum);
        System.out.println();

        System.out.println("distinct number on the list");
        List<Integer> distinctNum = integers.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctNum);
        System.out.println();

        System.out.println("sorted number on the list");
        List<Integer> sortedNum = integers.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedNum);
        System.out.println();

        System.out.println("sorted courses by length of course name");
        List<String> sortedCourseName = courses.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        System.out.println(sortedCourseName);
        System.out.println();

        System.out.println("sorted courses by length reversed of course name");
        List<String> sortedReverseCourseName = courses.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
        System.out.println(sortedReverseCourseName);
        System.out.println();

        System.out.println("sorted desc number on the list");
        List<Integer> sortedDescNum = integers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(sortedDescNum);
        System.out.println();

        System.out.println("list of length of course name");
        List<Integer> lengthCourseName = courses.stream().map(String::length).collect(Collectors.toList()).stream().sorted().collect(Collectors.toList());
        System.out.println(lengthCourseName);
        System.out.println();


        System.out.println("find logic behind 2nd argument of reduce");
        Integer sum1 = integers.stream().reduce(0, getSum());
        System.out.println(sum);
        System.out.println();

    }

    private static BinaryOperator<Integer> getSum() {
        return Integer::sum;
    }
}
