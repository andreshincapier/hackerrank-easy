package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    private static final Map<String, Point> conversor;

    static {
        conversor = new HashMap<>();
        conversor.put("U", new Point(0, 1));
        conversor.put("R", new Point(1, 0));
        conversor.put("L", new Point(-1, 0));
        conversor.put("D", new Point(0, -1));
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        List<String> comands = Arrays.asList("RUULLLDDDR");
        System.out.println(calcularMaximoRetorno(comands));
    }

    public static List<Integer> calcularMaximoRetorno(List<String> instruccions) {

        List<Integer> respuesta = new ArrayList<>();

        for (String instruccion : instruccions) {

            Point origen = new Point(0, 0);

            Stream.of(instruccion.split(""))
                .map(conversor::get)
                .map(origen::add)
                .max(Comparator.comparing(Point::getDistance))
                .ifPresent(p -> respuesta.add(p.getAmountStep()));
        }

        return respuesta;
    }

}

class Point {

    private Integer x;
    private Integer y;

    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }

    public Point add(Point origin) {
        this.x += origin.x;
        this.y += origin.y;
        return new Point(this.x, this.y);
    }

    public Double getDistance() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public Integer getAmountStep() {
        return Math.abs(x) + Math.abs(y);
    }

}
