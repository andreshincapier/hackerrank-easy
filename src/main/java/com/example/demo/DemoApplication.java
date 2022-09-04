package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        List<Integer> b = List.of(2, 4, 2);
        List<Integer> a = List.of(3, 16, 8);
        List<List<Integer>> equipo = List.of(a, b);
        System.out.println(maximoNumeroHoras(equipo));
    }

    public static List<Integer> maximoNumeroHoras(List<List<Integer>> equipo) {

        int bigTask;
        List<Integer> result = new ArrayList<>();

        List<Info> list = equipo
            .stream()
            .map(Info::new).toList();

        for (Info i : list) {
            int totalHours = i.getT() * i.getN();
            if (i.getT() <= 2) {
                bigTask = totalHours - i.getR();
                result.add(bigTask);
            } else {
                int smallTask = (i.getN() - 1) * i.getR();
                bigTask = totalHours - smallTask;
                result.add(bigTask);
            }
        }
        return result;
    }
}

class Info {

    private Integer N;
    private Integer T;
    private Integer R;

    public Info(List<Integer> data) {
        this.N = data.get(0);
        this.T = data.get(1);
        this.R = data.get(2);
    }

    public Integer getN() {
        return N;
    }

    public Integer getT() {
        return T;
    }

    public Integer getR() {
        return R;
    }
}
