package com.seroja.function;

import java.util.ArrayList;
import java.util.Collections;
import static java.lang.Math.cos;

public class Function {

    public static final double EPS = 1e-9;
    final float a = -0.5f, b = 2.0f;

    public double solve(double x) {
        double y = 0.0;
        if (x > 1.4 + EPS) {
            y = (Math.exp(a * x) * cos(b * x));
        } else if  (x <= 0.7 + EPS) {
            y = 1;
        } else {
            y = (a * (Math.pow(x, 2)) * (Math.log(x)));
        }
        return y;
    }

    public ArrayList<Double> fillArrayX() {
        ArrayList<Double> listX = new ArrayList<>();
        for (double x = 0.0; x <= 3.0 + EPS; x += 0.004) {
            listX.add(x);
        }
        return listX;
    }

    public ArrayList<Double> fillArrayY() {
        ArrayList<Double> listY = new ArrayList<>();
        ArrayList<Double> listX = fillArrayX();
        for (Double x : listX) {
            listY.add(solve(x));
        }
        return listY;
    }

    public double findMaxY(ArrayList<Double> list){
         return Collections.max(list);
    }

    public double findMinY(ArrayList<Double> list){
        return Collections.min(list);
    }

    public double findSum(ArrayList<Double> list){
        double sum=0;
        for (int i = 0; i < list.size(); i++) {
            sum+=list.get(i);
        }
        return sum;
    }

    public double findAverage(ArrayList<Double> list){
        double average = 0;
        for (int i = 0; i < list.size(); i++) {
            average=(findSum(list)/list.size());

        }
        return average;
    }

    public void printMax(ArrayList<Double> list){
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(findMaxY(list))){
                index = i;
            }
        }
        System.out.println("Max number: " + findMaxY(list) + " Index:" + index);

    }
    public void printMin(ArrayList<Double> list){
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(findMinY(list))){
                index = i;
            }
        }
        System.out.println("Max number: " + findMinY(list) + " Index:" + index);

    }
}
