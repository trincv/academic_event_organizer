package br.academic.views;

import java.util.Scanner;
import br.academic.utils.events.*;
import br.academic.core.App;


public class EventView {

    public static void register() {
        int type_option, model_option;

        System.out.println("\n-- Register an event --\n");
        System.out.print("Choose type of event:\n");

        do {

            System.out.println("0 - Academic fair\n");
            System.out.println("1 - Course\n");
            System.out.println("2 - Lecture\n");
            System.out.println("3 - Workshop\n");

            type_option = App.sc.nextInt();
            App.sc.nextLine();

            if(type_option < 0 || type_option > 3) System.out.println("Invalid value. Choose again:\n");

        } while(type_option < 0 || type_option > 3);

        System.out.print("\nEnter event model: ");

        do {

            System.out.println("0 - In person\n");
            System.out.println("1 - Online\n");
            System.out.println("2 - Hybrid\n");

            model_option = App.sc.nextInt();
            App.sc.nextLine();

            if(model_option < 0 || model_option > 2) System.out.println("Invalid value. Choose again:\n");

        } while(model_option < 0 || model_option > 2);

        System.out.print("\nEnter title: ");
        String title = App.sc.nextLine();

        System.out.print("Enter date of event: ");
        String date = App.sc.nextLine();

        System.out.print("Enter place: ");
        String place = App.sc.nextLine();

        System.out.print("Enter max participants: ");
        int max_participants = App.sc.nextInt();
        App.sc.nextLine();

        System.out.print("Enter description: ");
        String description = App.sc.nextLine();

        switch(type_option) {
            case 0: {
                System.out.print("Tools required to the workshop: ");
                String toolsRequired = App.sc.nextLine();

                System.out.print("Enter instructor's name: ");
                String instructor = App.sc.nextLine();

                

            }
            case 1: {
                System.out.print("Tools required to the workshop: ");
                String toolsRequired = App.sc.nextLine();

                System.out.print("Enter instructor's name: ");
                String instructor = App.sc.nextLine();

            

            }
            case 2: {
                System.out.print("Tools required to the workshop: ");
                String toolsRequired = App.sc.nextLine();

                System.out.print("Enter instructor's name: ");
                String instructor = App.sc.nextLine();

                

            }
            case 3: {
                System.out.print("Tools required to the workshop: ");
                String toolsRequired = App.sc.nextLine();

                System.out.print("Enter instructor's name: ");
                String instructor = App.sc.nextLine();

                //Workshop w = new Workshop(title, date, place, max_participants, toolsRequired, instructor, description);
                //App.ev.addEvent(w);
            }
        }
    }
}
