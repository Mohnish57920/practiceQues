package org.example;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class EmployeeStreams {

    public static void main(String[] args) {
        ArrayList<Employee> employees = createEmployeeList();

        System.out.println("Write a program to print employee details working in each department");
        Map<String, List<Employee>> empByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(empByDept);

        System.out.println("Write a program to print employee name working in each department");
        Map<String, List<String>> empNameByDept = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(empNameByDept);

        System.out.println("Write a program to print employees count working in each department");
        Map<String, Long> empCount = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(empCount);

        System.out.println("Write a program to print active and inactive employees in the given collection");
        Map<Boolean, List<Employee>> activeEmp = employees.stream().collect(Collectors.groupingBy(Employee::getActive));
        System.out.println(activeEmp);

        System.out.println("Write a program to print Max/Min employee salary from the given collection");
        Optional<Employee> maxSalary = employees.stream().max(Comparator.comparing(Employee::getSalary));
        System.out.println(maxSalary);

        System.out.println("Write a program to print Max/Min active employee salary from the given collection");
        Optional<Employee> maxActiveSalary = employees.stream().filter(e-> e.getActive().equals(true)).max(Comparator.comparing(Employee::getSalary));
        System.out.println(maxActiveSalary);

        System.out.println("Write a program to print Max/Min active employee salary - name from the given collection");
        String maxEmpName = employees.stream().filter(e -> e.getActive().equals(true)).max(Comparator.comparing(Employee::getSalary)).get().getName();
        // another way
        // employees.stream().sorted(Comparator.comparing(Employee::getSalary)).findFirst().get().getName();
        System.out.println(maxEmpName);

        System.out.println("Write a program to print the max salary of an employee from each department");
        Map<String, Optional<Employee>> collectMaxSalaryByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));
        System.out.println(collectMaxSalaryByDept);

        System.out.println("Write a program to print the avg salary of employees");
        double salaryAsDouble = employees.stream().mapToLong(Employee::getSalary).average().getAsDouble();
        System.out.println("Average salary = " + salaryAsDouble);

        System.out.println("Write a program to print the avg salary of employees by dept");
        Map<String, Double> avgDeptSalary = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingLong(Employee::getSalary)));
        System.out.println("Avg Dept salary = "+ avgDeptSalary);

        System.out.println("Write a program to print names of all employees having salary more than 15k");
        List<String> EmpHavingMoreSalary = employees.stream().filter(e -> e.getSalary() > 15000L).map(Employee::getName).collect(Collectors.toList());
        System.out.println(EmpHavingMoreSalary);

        System.out.println("Write a program to print male and female employees count");
        Map<String, Long> empByGender = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(empByGender);

        System.out.println("Write a program to print male and female employees names");
        Map<String, List<String>> maleFemaleEmp = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(maleFemaleEmp);

        System.out.println("Write a program to print male/female with highest salary");
        Map<String, Optional<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getGender,
                Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));
        System.out.println(collect);

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
