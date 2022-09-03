package com.example.demo;

import java.util.Arrays;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        List<Integer> comands = Arrays.asList(5, 5, 3, 5, 2, 5);
        System.out.println(cantidadMinimaDeDias(comands));
    }

    public static int cantidadMinimaDeDias(List<Integer> x) {
        return x.stream().distinct().toList().size();
    }
}
