package org.example.in28mins;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatmapStream {

    public static void main(String[] args) {


        List<String> courses = List.of("Spring", "Spring Boot", "AWS", "GCP", "Spring JPA","Docker");
        List<String> courses2 = List.of("Spring", "Spring Boot", "AWS", "GCP", "Spring JPA", "Docker");

        // output : S,p,r,i,n,g, ,B,o,t,A,W,G,C,P,J,D,c,k,e
        System.out.println(courses.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.joining(",")));

        // output [[Spring, SpringBoot], [Spring,AWS], [Spring, GCP], [Spring,JPA], [Spring Boot, Spring]]
        System.out.println(
                courses.stream()
                        .flatMap(course -> courses2.stream().filter(cour2 -> cour2.length()==course.length()).map(course2 -> List.of(course,course2)))
                        .filter(finalCourse -> !finalCourse.get(0).equals(finalCourse.get(1)))
                        .collect(Collectors.toList())
        );

        //output - [[Spring, Docker], [AWS, GCP], [GCP, AWS], [Docker, Spring]]
        System.out.println(
                courses.stream()
                        .flatMap(course -> courses2.stream().filter(cour2 -> cour2.length()==course.length()).map(course2 -> List.of(course,course2)))
                        .filter(finalCourse -> !finalCourse.get(0).equals(finalCourse.get(1)))
                        .collect(Collectors.toList())
        );
    }
}
