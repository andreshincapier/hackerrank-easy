package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        List<Long> prestamo = List.of(15L, 16L, 45L);
        System.out.println(calcularDias(prestamo));
    }

    public static List<Long> calcularDias(List<Long> prestamo) {

        List<Long> result = new ArrayList<>();

        prestamo.forEach(l -> {
            long accumulator = 1L;

            for (long j = 1; j < l; j++) {
                accumulator += accumulator;
                if (accumulator > l) {
                    result.add(j);
                    break;
                }
            }
        });
        return result;
    }
}
