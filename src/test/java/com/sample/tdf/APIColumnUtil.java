package com.sample.tdf;

import java.util.Arrays;

public class APIColumnUtil {
    public static void main(String[] args) {
        String str = "asdf、adfadf、啊手动阀、不服不行";

        try {
//            String str = new String(aaaa.getBytes(), StandardCharsets.UTF_8);
            String[] cs = str.split("、");
            Arrays.asList(cs).forEach(c -> {
                System.out.println(c);
            });
            System.out.println(str);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
