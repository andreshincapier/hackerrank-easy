package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        List<Integer> apples = List.of(2, 3, -4);
        List<Integer> oranges = List.of(3, -2, -4);
        countApplesAndOranges(7, 10, 4, 12, apples, oranges);
    }

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples,
        List<Integer> oranges) {

        List<Integer> applesArr = calculateDistance(a, apples);
        List<Integer> orangesArr = calculateDistance(b, oranges);

        System.out.println(inRange(s, t, applesArr));
        System.out.println(inRange(s, t, orangesArr));

    }

    public static long inRange(int s, int t, List<Integer> array) {
        return array.stream()
            .filter(i -> i >= s && i <= t)
            .count();
    }

    public static List<Integer> calculateDistance(int located, List<Integer> array) {

        List<Integer> cal = new ArrayList<>();
        array.forEach(p -> {
            int value = located + p;
            cal.add(value);
        });

        return cal;
    }
}
