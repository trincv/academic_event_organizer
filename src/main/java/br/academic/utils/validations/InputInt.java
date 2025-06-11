package br.academic.utils.validations;

import br.academic.core.App;

public class InputInt {

    public static int scanInt(int min, int max) {
        int Return;

        do {

            verifyIntInput();

            Return = App.sc.nextInt();
            App.sc.nextLine();
            
            if(Return < min || Return > max) System.err.print("Error: Invalid option, try again: ");
        } while(Return < min || Return > max);

        return Return;
    }

    public static int scanInt() {
        int Return;

            verifyIntInput();

            Return = App.sc.nextInt();
            App.sc.nextLine();

        return Return;
    }

    public static void verifyIntInput() {

        while(!App.sc.hasNextInt()) {
            System.err.print("Error: Invalid input. Please enter a number: ");
            App.sc.next();
        }

    } 
}