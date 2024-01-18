package com.intelij.intelij1;

import ch.qos.logback.classic.pattern.MDCConverter;
import com.intelij.intelij1.util.Employee;
import com.intelij.intelij1.util.LoginDto;
import io.micrometer.common.KeyValues;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class TestClass1 {

    public static void main(String[]args) {

        List<Employee> employees = Arrays.asList(

                new Employee("mike", 30, "chennai"),
                new Employee("sonu", 25, "chennai"),
                new Employee("adsm", 31, "pune"),
                new Employee("vk", 34, "bangalore")

        );

        Map<Integer, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(e -> e.getAge()));

        for (Map.Entry<Integer, List<Employee>> entry : collect.entrySet()) {


            int age = entry.getKey();
            List<Employee> employeesWithAge = entry.getValue();

            System.out.println("age:"+age+"---");

            for (Employee e : employeesWithAge) {
                System.out.println(e.getCity());
                System.out.println(e.getName());

            }
        }
    }
}
