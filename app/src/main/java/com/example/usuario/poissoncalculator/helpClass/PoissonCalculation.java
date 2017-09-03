package com.example.usuario.poissoncalculator.helpClass;

public class PoissonCalculation {

    private static final double E = 2.718281828459045;

    public double getPoisson(double x, double a){
        int factorial;

        factorial = getFactorial(x);
        return (Math.pow(a,x)*Math.pow(E, -a)) / factorial;
    }

    private int getFactorial(double x){
        if (x == 0){
            return 1;
        }
        int fact = 1;
        for (int i=1; i<= x; i++){
            fact *= i;
        }
        return fact;
    }
}
