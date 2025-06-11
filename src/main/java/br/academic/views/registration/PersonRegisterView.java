package br.academic.views.registration;

import br.academic.core.App;
import br.academic.utils.validations.*;
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

        type_option = InputInt.scanInt(0,2);

        System.out.print("\nEnter name: ");
        String name = App.sc.nextLine();

        System.out.print("Enter email: ");
        String email = App.sc.nextLine();

        System.out.print("Enter CPF: ");

        String CPF;
        do {
            CPF = CpfValidation.getValidCpfInput();
            if(App.pe.searchPerson(CPF) == null)
                break;
            else
                System.err.print("Error: Can not exists two people with the same CPF. Digit again: ");
        } while(true);

        switch(type_option) {
            case 0: {
                Student student = new Student(name, email, CPF);
                App.pe.addPerson(student);

                App.clearScreen();
                System.out.print("New student created with sucess!!");

                try{
                    Thread.sleep(2 * 1000);
                } catch(Exception e) {}                

                App.clearScreen();
                break;
            }
            case 1: {
                Professor professor = new Professor(name, email, CPF);
                App.pe.addPerson(professor);

                App.clearScreen();
                System.out.print("New professor created with sucess!!");
                
                try{
                    Thread.sleep(2 * 1000);
                } catch(Exception e) {}                

                App.clearScreen();
                break;
            }
            case 2: {
                External external = new External(name, email, CPF);
                App.pe.addPerson(external);

                App.clearScreen();
                System.out.print("New external created with sucess!!");
                
                try{
                    Thread.sleep(2 * 1000);
                } catch(Exception e) {}                

                App.clearScreen();
                break;
            }
        }
    }
}
