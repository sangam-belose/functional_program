package com.practice.linkedin.functional.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CompositionExample {
    protected static class Employee {
        private String name;
        private Integer age;
        private String jobTitle;
        private Float salary;

        public Employee(String name, Integer age, String jobTitle, Float salary) {
            this.name = name;
            this.age = age;
            this.jobTitle = jobTitle;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public Float getSalary() {
            return salary;
        }
    }

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Sangam", 32, "developer", 1000.0f),
                new Employee("Swaraj", 30, "developer", 3000.0f),
                new Employee("Nitin", 35, "Project Manager", 5000.0f),
                new Employee("Ajay", 35, "Project Manager", 13000.0f),
                new Employee("Amrut", 28, "developer", 1500.0f),
                new Employee("Pankaj", 36, "Sales", 6000.0f),
                new Employee("Diana", 36, "Sales", 7000.0f)
        };

        List<Employee> employeeList = new ArrayList<>(Arrays.asList(employees));

        //use composition to combine multiple function into single function.
        // reverse and uppercase names of all employees

        //This is simple function of reverse and uppercase can be done in single stream
        // but this same concept can be applicable for more complex functions.

        Function<Employee, String> getNameFunction = (employee) -> employee.getName();
        Function<String, String> getReverseName = (str) -> new StringBuilder(str).reverse().toString();
        Function<String, String> upperCaseFunction = (name) -> name.toUpperCase();

        Function<Employee, String> getNameReverseAndUpperCase = getNameFunction.andThen(getReverseName).andThen(upperCaseFunction);

        List<String> reverseNameList = employeeList.stream()
                .map(getNameReverseAndUpperCase)
                .collect(Collectors.toList());

        System.out.println("Name reversed and uppercase: "+reverseNameList);
    }
}
