package com.seroja.service;

import com.seroja.function.Function;

import java.util.ArrayList;
import java.util.Scanner;

public class Service {

    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Choose action:
                1.Solve expression for one x value
                2.Print max Y value
                3.Print min Y value
                4.Print sum of Y values
                5.Print average of Y values
                """);
        int actionNumber = scanner.nextInt();
        scanner.nextLine();
        doAction(actionNumber);
    }

    public void doAction(int actionNumber){
        Scanner scanner = new Scanner(System.in);
        Function function = new Function();
        switch (actionNumber){
            case 1 -> {
                System.out.println("Enter x");
                float x = scanner.nextFloat();
                System.out.println("Answer: " + function.solve(x));
            }
            case 2 ->{
                ArrayList<Double> listY = function.fillArrayY();
                function.printMax(listY);
            }
            case 3 ->{
                ArrayList<Double> listY = function.fillArrayY();
                function.printMin(listY);
            }
            case 4 ->{
                ArrayList<Double> listY = function.fillArrayY();
                System.out.println("Sum of Y values: " + function.findSum(listY));
            }
            case 5 -> {
                ArrayList<Double> listY = function.fillArrayY();
                System.out.println("Average of Y values: " + function.findAverage(listY));
            }
            default -> System.out.println("Wrong action");
        }
    }

}
