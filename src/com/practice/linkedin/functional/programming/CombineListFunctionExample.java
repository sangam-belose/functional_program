package com.practice.linkedin.functional.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CombineListFunctionExample {
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

        // find out average developer salary

        // first find total salary of developers
        Float sumOfDevSalary = employeeList
                .stream()
                .filter(employee -> employee.getJobTitle().equals("developer"))
                .map(developer -> developer.getSalary())
                .reduce(0f, (acc, x) -> acc + x);

        System.out.println("Total developer salary: " + sumOfDevSalary);

        // find total no of developers

        Long totalDevelopers = employeeList
                .stream()
                .filter(employee -> employee.getJobTitle().equals("developer"))
                .collect(Collectors.counting());

        System.out.println("Total developers: " + totalDevelopers);

        System.out.println("Average developer salary: " + sumOfDevSalary / totalDevelopers);


        // find average salary of all other job title.
        Map<String, Float> avgSalariesMap = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getJobTitle()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue()
                                .stream()
                                .map(emp -> emp.getSalary())
                                .reduce(0f, (acc, x) -> acc + x) / entry.getValue().size()
                ));

        System.out.println("Average salaries of all job titles: "+avgSalariesMap);
    }
}
