package org.example.servletcalculator;

import java.util.Scanner;

public class ValidationTest {
    public static void main(String[] args) {
        System.out.println("input equation");
        String equation = new Scanner(System.in).nextLine();
        System.out.println(EquationValidation.validateEquation(equation));
        if (!EquationValidation.validateEquation(equation)) {
            System.out.println(EquationValidation.getErrorMsg());
        }
    }
}
