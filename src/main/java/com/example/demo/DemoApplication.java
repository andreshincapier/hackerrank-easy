package com.example.demo;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        List<Integer> a = List.of(11, 2, 4);
        List<Integer> b = List.of(4, 5, 6);
        List<Integer> c = List.of(10, 8, -12);
        List<List<Integer>> arr = List.of(a, b, c);
        System.out.println(diagonalDifference(arr));
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int firstDiagonal = 0;
        int secondDiagonal = 0;

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                if (i == j) {
                    firstDiagonal += arr.get(i).get(j);
                }

                if ((i + j) == (arr.size() - 1)) {
                    secondDiagonal += arr.get(i).get(j);
                }
            }
        }
        return Math.abs(firstDiagonal - secondDiagonal);
    }
}
