package org.example.in28mins;

import org.w3c.dom.ranges.Range;

import java.util.List;
import java.util.stream.Stream;

public class BasicStream {

    public static void main(String[] args) {
        // ---------------------------- filters ------------------------------------------------

        System.out.println("q1");
        List<Integer> integers = List.of(12, 9, 12, 4, 89, 7, 45, 345, 234, 2, 3565, 34, 67, 78875);
        integers.stream().filter(i->i%2!=0).forEach(System.out::println);

        System.out.println("q2");
        List<String> courses = List.of("Spring", "Spring Boot", "AWS", "GCP", "Spring JPA");
        courses.stream().filter(e-> e.contains("Spring")).forEach(System.out::println);

        System.out.println("q3");
        courses.stream().filter(e->e.length()>4).forEach(System.out::println);

        // --------------------------------- map ------------------------------------------------
        System.out.println("q4");
        integers.stream().filter(i-> i%2==0).map(i->Math.pow(i,2)).forEach(System.out::println);

        System.out.println("****** Q5 *******");
        integers.stream().filter(i->i%2==0).map(i->Math.pow(i,3)).forEach(System.out::println);

        System.out.println("****** Q6 *******");
        courses.stream().forEach(e-> System.out.println(e + " = "+ e.trim().length()));
    }


}
