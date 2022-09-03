package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        List<Integer> b = List.of(2, 40, 20, 5);
        List<Integer> a = List.of(5, 110, 30, 10);
        List<List<Integer>> list = List.of(a, b);
        System.out.println(podraCumplir(list));
    }

    public static List<Boolean> podraCumplir(List<List<Integer>> caso) {

        List<Boolean> valid = new ArrayList<>();

        List<Info> list = caso
            .stream()
            .map(Info::new).toList();

        for (Info i : list) {
            int ac = 0;
            for (int j = 0; j < i.getD() - 1; j++) {
                ac += (i.getF() - i.getR());
            }
            ac += i.getF();
            boolean result = (i.getT() == ac);
            valid.add(result);
        }

        return valid;
    }

}

class Info {

    private Integer D;
    private Integer T;
    private Integer F;
    private Integer R;

    public Info(List<Integer> data) {
        this.D = data.get(0);
        this.T = data.get(1);
        this.F = data.get(2);
        this.R = data.get(3);
    }

    public Integer getD() {
        return D;
    }

    public Integer getT() {
        return T;
    }

    public Integer getF() {
        return F;
    }

    public Integer getR() {
        return R;
    }
}


