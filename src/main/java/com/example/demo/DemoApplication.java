package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        List<Integer> grades = List.of(73, 67, 38, 33);
        System.out.println(gradingStudents(grades));
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> finalGrade = new ArrayList<>();

        grades.forEach(grade -> {
            if (grade < 38) {
                finalGrade.add(grade);
            } else {
                Integer r = finalGrade(grade);
                finalGrade.add(r);
            }
        });
        return finalGrade;
    }

    public static Integer roundFive(Integer grade) {
        return (grade + 4) / 5 * 5;
    }

    public static Integer finalGrade(Integer grade) {
        int round = roundFive(grade);
        int subtract = Math.subtractExact(round, grade);
        if (subtract < 3) {
            return round;
        } else {
            return grade;
        }
    }

}
