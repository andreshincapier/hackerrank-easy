package com.example.demo;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        List<Integer> list = List.of(1, 2, 3, 4, 10, 11);

        int result = arraySum(list);

        System.out.println(result);
    }

//    public static int arraySum(List<Integer> array) {
//        int sum = 0;
//        for (Integer number : array) {
//            sum = number + sum;
//        }
//        return sum;
//    }

    public static int arraySum(List<Integer> array){
        return array.stream()
            .mapToInt(i -> i)
            .sum();
    }

}
