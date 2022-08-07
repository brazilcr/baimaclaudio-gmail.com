package com.example;

import java.util.Scanner;

public class Exerc1 {

    /**
     * 
     */
    public static void main2(String args[]) {
        System.out.println("Exercice 1 ** \n");
        System.out.println("=============");

        Scanner input = new Scanner(System.in);
        String Input;
        int number = 100;
        boolean isValid = false;

        do {
            isValid = true;
            try {
                System.out.print("How many numbers to print (GT 10):  ");
                Input = input.nextLine();
                number = Integer.parseInt(Input);
                if (number < 10 || number > 200000) { // absurd data critic
                    isValid = false;
                    System.out.println("Invalid number. Try again.");
                    Input = input.nextLine();
                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        } while (isValid == false);

        input.close();

        for (int i = 1; i < (number + 1); i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("Visual Nuts\n");
            } else if (i % 3 == 0) {
                System.out.print("Visual\n");
            } else if (i % 5 == 0) {
                System.out.print("Nuts\n");
            } else {
                System.out.print(i + "\n");
            }
        }
        System.out.println("end job\n");
    }
}
