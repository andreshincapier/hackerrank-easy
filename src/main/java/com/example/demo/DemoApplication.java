package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    private static final Map<String, Point> conversions;

    static {
        conversions = new HashMap<>();
        conversions.put("U", new Point(0, 1));
        conversions.put("R", new Point(1, 0));
        conversions.put("L", new Point(-1, 0));
        conversions.put("D", new Point(0, -1));
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        List<String> commands = List.of("RUULLLDDDR");
        System.out.println(calcularMaximoRetorno(commands));
    }

    public static List<Integer> calcularMaximoRetorno(List<String> instruccion) {

        List<Integer> response = new ArrayList<>();

        instruccion.forEach(s -> {
            Point origen = new Point(0, 0);

            Stream.of(s.split(""))
                .map(conversions::get)
                .map(origen::add)
                .max(Comparator.comparing(Point::getDistance))
                .ifPresent(p -> response.add(p.getAmountStep()));
        });
        return response;
    }

}

class Point {

    private Integer x;
    private Integer y;

    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
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
