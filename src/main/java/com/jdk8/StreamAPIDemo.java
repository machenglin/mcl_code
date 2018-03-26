package com.jdk8;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Mcl
 * @date 2017/12/19
 */
public class StreamAPIDemo {
    @Test
    public void Test() {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "张三1", 15, 2500),
                new Employee(2, "张三2", 13, 1500),
                new Employee(3, "张三3", 16, 1900),
                new Employee(4, "张三4", 18, 2100),
                new Employee(5, "张三5", 25, 3000)
        );
        Double sum = employeeList.stream()
                .filter((e) -> (e.getAge() >= 15 && e.getAge() <= 18))
                .sorted((e1, e2) -> Double.compare(e1.getAge(), e2.getAge()))
                .map(Employee::getSalary)
                .distinct()
                .reduce(Double::sum)
                .get();
        System.out.println(sum);

    }
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Employee {
        private long id;
        private String name;
        private int age;
        private double salary;
    }
}


