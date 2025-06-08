package br.academic.views;

import java.util.Scanner;
import br.academic.core.App;
import br.academic.utils.participant.*;
import java.lang.Thread;
import java.lang.Exception;

public class PersonRegisterView {

    public static void personRegister() {
        int type_option;

        App.clearScreen();
        System.out.println("\n---- Register a Person ----\n");
        System.out.println("0 - Student");
        System.out.println("1 - Professor");
        System.out.println("2 - External");
        
        System.out.print("\nChoose the type of person: ");

        do {

            type_option = App.sc.nextInt();
            App.sc.nextLine();

            if(type_option < 0 || type_option > 2) System.out.print("Invalid option, choose again: ");

        } while(type_option < 0 || type_option > 2);

        System.out.print("\nEnter name: ");
        String name = App.sc.nextLine();

        System.out.print("Enter email: ");
        String email = App.sc.nextLine();

        System.out.print("Enter CPF: ");
        String CPF = App.sc.nextLine();

        switch(type_option) {
            case 0: {
                Student s = new Student(name, email, CPF);
                App.pe.addPerson(s);

                App.clearScreen();
                System.out.print("New student created with sucess!!");

                try{
                    Thread.sleep(2 * 1000);
                } catch(Exception e) {}                

                App.clearScreen();
                break;
            }
            case 1: {
                Professor p = new Professor(name, email, CPF);
                App.pe.addPerson(p);

                App.clearScreen();
                System.out.print("New professor created with sucess!!");
                
                try{
                    Thread.sleep(2 * 1000);
                } catch(Exception e) {}                

                App.clearScreen();
                break;
            }
            case 2: {
                External e = new External(name, email, CPF);
                App.pe.addPerson(e);

                App.clearScreen();
                System.out.print("New external created with sucess!!");
                
                try{
                    Thread.sleep(2 * 1000);
                } catch(Exception E) {}                

                App.clearScreen();
                break;
            }
        }
    }
}
