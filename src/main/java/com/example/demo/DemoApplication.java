package com.example.demo;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        List<Long> prestamo = List.of(1000000001L, 1000000002L, 1000000003L, 1000000004L,
            1000000005L);
        System.out.println(aVeryBigSum(prestamo));
    }

    public static Long aVeryBigSum(List<Long> ar) {

        return ar.stream().mapToLong(l -> l).sum();
    }
}
