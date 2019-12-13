package com.pe.reto.retoms.util;

import java.util.List;

public class DesvStandard {

    public static Double getDesv(List<Double> age){
        return Math.sqrt(getSum(getPow(age, getProm(age))) / age.size());
    }

    public static Double getProm(List<Double> age){
        Double prom = getSum(age) / age.size();
        return prom;
    }

    public static Double getSum(List<Double> age){
        Double sum = age.stream().reduce(0.0, Double::sum);
        return sum;
    }

    public static List<Double> getPow(List<Double> age, Double prom){
        age.stream().forEach(item -> {
            item = Math.pow(Math.abs(item - prom),2);
        });
        return age;
    }

}