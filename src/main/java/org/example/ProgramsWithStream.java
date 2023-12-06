package org.example;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class ProgramsWithStream {


    public static void main(String[] args) {
        ArrayList<Employee> employees = createEmployeeList();

        System.out.println("Write a program to print employee details working in each department");
        employees.stream().forEach(System.out::println);
        System.out.println();

        System.out.println("Write a program to print employee name working in each department");
        Map<String, List<String>> nameByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, toList())));
        System.out.println(nameByDept);
        System.out.println();


        System.out.println("Write a program to print employees count working in each department");
        Map<String, Long> employeeCount = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, counting()));
        System.out.println(employeeCount);
        System.out.println();


        System.out.println("Write a program to print active and inactive employees in the given collection");
        List<Employee> activeEmployees = employees.stream().filter(e -> e.getActive()).collect(toList());
        List<Employee> inactiveEmployees = employees.stream().filter(e -> !e.getActive()).collect(toList());
        System.out.println("Active Employees : "+ activeEmployees.stream().map(e->e.getName()).collect(Collectors.toList()));
        System.out.println("Inactive Employees : "+inactiveEmployees.stream().map(e->e.getName()).collect(Collectors.toList()));
        System.out.println();


        System.out.println("Write a program to print Max/Min employee salary from the given collection");
        Optional<Employee> maxSalary = employees.stream().max(Comparator.comparing(Employee::getSalary));
        Employee minSalaried = employees.stream().min(Comparator.comparing(Employee::getSalary)).get();
        System.out.println(maxSalary.get().getName());
        System.out.println(minSalaried.getName());
        System.out.println();


        System.out.println("Write a program to print Max/Min active employee salary from the given collection");
        Optional<Employee> maxActiveEmployee = employees.stream().filter(e -> e.getActive()).max(Comparator.comparing(Employee::getSalary));
        System.out.println(maxActiveEmployee.get().getName());
        System.out.println();

//        System.out.println("Write a program to print Max/Min active employee salary - name from the given collection");


        System.out.println("Write a program to print the max salary of an employee from each department");
        Map<String, Optional<Employee>> maxSalariedFromEachDept = employees.stream().collect(groupingBy(
                Employee::getDepartment,
                maxBy(Comparator.comparing(Employee::getSalary))
        ));
        System.out.println(maxSalariedFromEachDept);
        System.out.println();

        System.out.println("Write a program to print the avg salary of employees");
        double averageSalary = employees.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
        System.out.println(averageSalary);
        System.out.println();

        System.out.println("Write a program to print the avg salary of employees by dept");
        Map<String, Double> avgsalaryByDept = employees.stream().collect(groupingBy(
                Employee::getDepartment,
                averagingDouble(Employee::getSalary)
        ));
        System.out.println(avgsalaryByDept);
        System.out.println();


        System.out.println("Write a program to print names of all employees having salary more than 15k");
        List<String> employeesWithmt15k = employees.stream().filter(e -> e.getSalary() > 15000).map(Employee::getName).collect(toList());
        System.out.println(employeesWithmt15k);
        System.out.println();


        System.out.println("Write a program to print male and female employees count");
        Map<String, List<Employee>> empByGender = employees.stream().collect(groupingBy(
                Employee::getGender
        ));
        System.out.println(empByGender);
        System.out.println();


        System.out.println("Write a program to print male and female employees names");
        Map<String, List<String>> empNamesByGender = employees.stream().collect(groupingBy(Employee::getGender, mapping(Employee::getName, toList())));
        System.out.println(empNamesByGender);
        System.out.println();

        System.out.println("Write a program to print male/female with highest salary");
        Map<String, Optional<Employee>> empWithMaxSalaryByGender = employees.stream().collect(groupingBy(
                Employee::getGender,
                maxBy(Comparator.comparing(Employee::getSalary))
        ));
        System.out.println(empWithMaxSalaryByGender);


    }

    private static ArrayList<Employee> createEmployeeList() {

        ArrayList<Employee> emp = new ArrayList<>();
        emp.add(Employee.builder().id(1).name("Tom").department("Dev").active(true).salary(10000L).gender("male").build());
        emp.add(Employee.builder().id(2).name("Jim").department("HR").active(true).salary(20000L).gender("male").build());
        emp.add(Employee.builder().id(3).name("Jack").department("Dev").active(true).salary(15000L).gender("male").build());
        emp.add(Employee.builder().id(4).name("Rosie").department("Ops").active(false).salary(30000L).gender("female").build());
        emp.add(Employee.builder().id(5).name("Alice").department("Ops").active(true).salary(25000L).gender("female").build());
        emp.add(Employee.builder().id(6).name("Tim").department("Dev").active(false).salary(5000L).gender("male").build());
        emp.add(Employee.builder().id(7).name("Kenan").department("HR").active(false).salary(35000L).gender("male").build());
        emp.add(Employee.builder().id(8).name("Alice").department("HR").active(false).salary(28000L).gender("female").build());

        return emp;
    }
}
