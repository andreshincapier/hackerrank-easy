package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.stream.Collectors.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        List<Integer> a = List.of(5, 6, 7);
        List<Integer> b = List.of(3, 6, 10);

        List<Integer> result = arraySum(a, b);

        String algo = result.stream()
            .map(Objects::toString)
            .collect(joining(" "))
            .concat("\n");

        System.out.println(algo);
    }

    public static List<Integer> arraySum(List<Integer> a, List<Integer> b) {

        List<Integer> resultA = new ArrayList<>();
        List<Integer> resultB = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                resultA.add(1);
            }
            if (a.get(i) < b.get(i)) {
                resultB.add(1);
            }
        }

        int ra = arraySum(resultA);
        int rb = arraySum(resultB);

        return List.of(ra, rb);

    }

    public static int arraySum(List<Integer> array) {
        return array.stream().mapToInt(i -> i).sum();
    }

}
