package org.example.in28mins.customclass;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomClass {

    public static void main(String[] args) {

        List<Course> courses = List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000));

        BiPredicate<Course, Integer> isReviewGreater = (course, expected) -> course.getReviewScore()>expected;

        //all match
        System.out.println(courses.stream().allMatch(course -> course.getReviewScore()>90));
        System.out.println(courses.stream().allMatch(c->isReviewGreater.test(c, 95)));

        //none match
        System.out.println(courses.stream().noneMatch(c->isReviewGreater.test(c, 99)));

        //any match
        System.out.println(courses.stream().anyMatch(c->isReviewGreater.test(c, 97)));

        // sorting based on student number
        Comparator<Course> compareByNoOfStudents = Comparator.comparing(Course::getNoOfStudents);
        List<Course> sortedCourseByStudents = courses.stream().sorted(compareByNoOfStudents).collect(Collectors.toList());
        System.out.println(sortedCourseByStudents);

        //reversed
        List<Course> sortedCourseByStudentsDesc = courses.stream().sorted(compareByNoOfStudents.reversed()).collect(Collectors.toList());
        System.out.println(sortedCourseByStudentsDesc);

        //sorting based on 2 conditions - desc:no of students and in case matching students decreasing review score
        System.out.println();
        Comparator<Course> sortByStudentsAndReviewScore = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed();
        List<Course> sortedListStudentsAndReviewScore = courses.stream().sorted(sortByStudentsAndReviewScore).collect(Collectors.toList());
        sortedListStudentsAndReviewScore.stream().forEach(System.out::println);

        // limit - limits the no. of results
        System.out.println();
        courses.stream().sorted(compareByNoOfStudents).limit(5).forEach(System.out::println);

        // skip - skips the top n results
        System.out.println();
        courses.stream().sorted(compareByNoOfStudents).skip(3).forEach(System.out::println);

        // take while - collects teh results until the condition is met
        System.out.println();
        System.out.println("Take while :");
        courses.stream().forEach(System.out::println);
        System.out.println();
        courses.stream().takeWhile(c->c.getReviewScore()>=95).forEach(System.out::println);

        // drop while - drop the elements/results until the condition is met
        System.out.println();
        System.out.println("drop while :");
        courses.stream().dropWhile(c->c.getReviewScore()>=95).forEach(System.out::println);

        // max operator - takes comparator , similar to min, findFirst, findAny
        System.out.println("MAX Value - " + courses.stream().max(compareByNoOfStudents).get());

        // sum, count, average by no of students

        // group by category
        System.out.println();
        courses.stream().collect(Collectors.groupingBy(Course::getCategory)).entrySet().stream().forEach(System.out::println);

        // group by category and count of each category
        Map<String, Long> countByCategory = courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()));
        System.out.println(countByCategory);

        // group by category and find highest review score one
        Map<String, Optional<Course>> maxStudentCourseByCategory = courses.stream()
                .collect(Collectors.groupingBy(
                        Course::getCategory,
                        Collectors.maxBy(Comparator.comparing(Course::getReviewScore))));
        System.out.println(maxStudentCourseByCategory);

        // group by category and find highest review score one and get its name
        System.out.println();
        Map<String, List<String>> courseNamesByCategory = courses.stream().collect(Collectors.groupingBy(
                Course::getCategory,
                Collectors.mapping(Course::getName, Collectors.toList())));
        System.out.println(courseNamesByCategory);


        // tes
    }
}
