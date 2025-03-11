package org.example;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class EmployeeStreams {

    public static void main(String[] args) {
        ArrayList<Employee> employees = createEmployeeList();

        System.out.println("Write a program to print employee details working in each department");
//        Map<String, List<Employee>> empByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
//        System.out.println(empByDept);
        Map<String, List<Employee>> q1 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("q1 : "+q1);
        System.out.println();


        System.out.println("Write a program to print employee name working in each department");
//        Map<String, List<String>> empNameByDept = employees.stream()
//                .collect(
//                        Collectors.groupingBy(Employee::getDepartment,
//                        Collectors.mapping(Employee::getName, Collectors.toList())));
//        System.out.println(empNameByDept);
        Map<String, List<String>> q2 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("q2 : "+q2);
        System.out.println();


        System.out.println("Write a program to print employees count working in each department");
//        Map<String, Long> empCount = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
//        System.out.println(empCount);
        Map<String, Long> q3 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("q3 : "+ q3);
        System.out.println();


        System.out.println("Write a program to print active and inactive employees in the given collection");
//        Map<Boolean, List<Employee>> activeEmp = employees.stream().collect(Collectors.groupingBy(Employee::getActive));
//        System.out.println(activeEmp);
        Map<Boolean, Set<String>> q4 = employees.stream().collect(Collectors.groupingBy(Employee::getActive, Collectors.mapping(Employee::getName, Collectors.toSet())));
        System.out.println("q4 : "+ q4);
        System.out.println();

        System.out.println("Write a program to print Max/Min employee salary from the given collection");
//        Optional<Employee> maxSalary = employees.stream().max(Comparator.comparing(Employee::getSalary));
//        System.out.println(maxSalary);
        Optional<String> q5max = employees.stream().max(Comparator.comparingLong(Employee::getSalary)).map(Employee::getName);
        Optional<String> q5min = employees.stream().min(Comparator.comparingLong(Employee::getSalary)).map(Employee::getName);
        System.out.println("q5 - Max salary : "+ q5max.get());
        System.out.println("q5 - Min salary : "+ q5min.get());
        System.out.println();

        System.out.println("Write a program to print Max/Min active employee salary from the given collection");
//        Optional<Employee> maxActiveSalary = employees.stream().filter(e-> e.getActive().equals(true)).max(Comparator.comparing(Employee::getSalary));
//        System.out.println(maxActiveSalary);
        Optional<Employee> q6MaxActive = employees.stream().filter(Employee::getActive).max(Comparator.comparingLong(Employee::getSalary));
        Optional<Employee> q6MinActive = employees.stream().filter(Employee::getActive).min(Comparator.comparingLong(Employee::getSalary));
        System.out.println("q6 max active: "+q6MaxActive);
        System.out.println("q6 min active: "+q6MinActive);
        System.out.println();

        System.out.println("Write a program to print Max/Min active employee salary - name from the given collection");
//        String maxEmpName = employees.stream().filter(e -> e.getActive().equals(true)).max(Comparator.comparing(Employee::getSalary)).get().getName();
//        // another way
//        // employees.stream().sorted(Comparator.comparing(Employee::getSalary)).findFirst().get().getName();
//        System.out.println(maxEmpName);

        System.out.println();

        System.out.println("Write a program to print the max salary of an employee from each department");
//        Map<String, Optional<Employee>> collectMaxSalaryByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
//                Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));
//        System.out.println(collectMaxSalaryByDept);
        Map<String, Optional<Employee>> q8 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.maxBy(Comparator.comparingLong(Employee::getSalary))));
        System.out.println("q8 : " + q8);
        System.out.println();

        System.out.println("Write a program to print the avg salary of employees");
//        double salaryAsDouble = employees.stream().mapToLong(Employee::getSalary).average().getAsDouble();
//        System.out.println("Average salary = " + salaryAsDouble);
        Double q9 = employees.stream().collect(Collectors.averagingLong(Employee::getSalary));
        System.out.println(q9);
        System.out.println();

        System.out.println("Write a program to print the avg salary of employees by dept");
//        Map<String, Double> avgDeptSalary = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingLong(Employee::getSalary)));
//        System.out.println("Avg Dept salary = "+ avgDeptSalary);
        Map<String, Double> q10 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingLong(Employee::getSalary)));
        System.out.println(q10);
        System.out.println();

        System.out.println("Write a program to print names of all employees having salary more than 15k");
//        List<String> EmpHavingMoreSalary = employees.stream().filter(e -> e.getSalary() > 15000L).map(Employee::getName).collect(Collectors.toList());
//        System.out.println(EmpHavingMoreSalary);
        System.out.println();

        System.out.println("Write a program to print male and female employees count");
//        Map<String, Long> empByGender = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
//        System.out.println(empByGender);
        Map<String, Long> q12 = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("q12 : "+q12);
        System.out.println();

        System.out.println("Write a program to print male and female employees names");
//        Map<String, List<String>> maleFemaleEmp = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.toList())));
//        System.out.println(maleFemaleEmp);
        Map<String, Set<String>> q13 = employees.stream().collect(Collectors.groupingBy(
                Employee::getGender,
                Collectors.mapping(Employee::getName, Collectors.toSet())));
        System.out.println("q13 : "+ q13);
        System.out.println();

        System.out.println("Write a program to print male/female with highest salary");
//        Map<String, Optional<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getGender,
//                Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));
//        System.out.println(collect);
//        Map<String, Optional<Employee>> q14 = employees.stream().collect(Collectors.groupingBy(
//                Employee::getGender,
//                Collectors.maxBy(Comparator.comparingLong(Employee::getSalary))));
//        System.out.println("q14 : " + q14);

        employees.stream().collect(Collectors.groupingBy(
                Employee::getGender,
                Collectors.maxBy(Comparator.comparingLong(Employee::getSalary))))
                .forEach((key, value) -> {
                    List<String> empNameList = value.stream().map(Employee::getName).collect(Collectors.toList());
                    System.out.println(key + " : " + empNameList);
                });
        System.out.println();

        System.out.println("Write a program to print male/female employees in different departments who are active");
//        employees.stream().filter(Employee::getActive)
//                .collect(Collectors.groupingBy(Employee::getDepartment))
//                .forEach(
//                        (key, value)-> {
//                            Map<String, List<String>> empNamebyGender = value.stream().collect(Collectors.groupingBy(
//                                    Employee::getGender, Collectors.mapping(Employee::getName, Collectors.toList())
//                            ));
//                            System.out.println(key + " : " + empNamebyGender);
//                        });;

        employees.stream()
                .filter(Employee::getActive)
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach(
                        (key, value) -> {
                            Map<String, List<String>> empByGender = value.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.toList())));
                            System.out.println(key + " : " + empByGender);
                        }
                );




    }

    private static ArrayList<Employee> createEmployeeList() {

        ArrayList<Employee> emp = new ArrayList<>();
        emp.add(Employee.builder().id(1).name("Tom").department("Dev").active(true).salary(10000L).gender("male").build());
        emp.add(Employee.builder().id(2).name("Jim").department("HR").active(true).salary(20000L).gender("male").build());
        emp.add(Employee.builder().id(3).name("Jack").department("Dev").active(true).salary(15000L).gender("male").build());
        emp.add(Employee.builder().id(4).name("Rosie").department("Ops").active(false).salary(30000L).gender("female").build());
        emp.add(Employee.builder().id(5).name("Alice").department("Ops").active(true).salary(25000L).gender("female").build());
        emp.add(Employee.builder().id(5).name("Alan").department("Ops").active(true).salary(22000L).gender("male").build());
        emp.add(Employee.builder().id(6).name("Tim").department("Dev").active(false).salary(5000L).gender("male").build());
        emp.add(Employee.builder().id(7).name("Kenan").department("HR").active(false).salary(35000L).gender("male").build());
        emp.add(Employee.builder().id(8).name("Alice").department("HR").active(false).salary(28000L).gender("female").build());

        return emp;
    }
}
