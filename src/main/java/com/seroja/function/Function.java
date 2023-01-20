package com.seroja.function;

import static java.lang.Math.cos;
import static java.lang.Math.max;

public class FunctionCalculator {


    final double a = -0.5, b = 2.0;

   public double solve(double x){
       double y = 0;
       if (x>1.4){
             y = Math.exp(a*x)* cos(b*x);
        } else if (x<=0.7) {
            y = 1;
        } else if ((0.7<x) || (x<=1.4)) {
           y= a*(Math.pow(x, 2))*(Math.log(x));
       }
            return y;
   }

}
