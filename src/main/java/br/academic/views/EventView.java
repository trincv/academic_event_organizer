package br.academic.views;

import java.util.Scanner;
import br.academic.utils.events.*;
import br.academic.utils.participant.*;
import br.academic.core.App;


public class EventView {

    public static void register() {
        int type_option, model_option;
        EventModel model = EventModel.INPERSON;

        System.out.println("\n-- Register an event --\n");
        System.out.print("Choose type of event:\n");

        do {

            System.out.println("0 - Academic fair\n");
            System.out.println("1 - Course\n");
            System.out.println("2 - Lecture\n");
            System.out.println("3 - Workshop\n");

            type_option = App.sc.nextInt();
            App.sc.nextLine();

            if(type_option < 0 || type_option > 3) System.out.println("\nInvalid value. Choose again:\n");

        } while(type_option < 0 || type_option > 3);

        System.out.println("\nEnter event model: ");

        do {

            System.out.println("0 - In person\n");
            System.out.println("1 - Online\n");
            System.out.println("2 - Hybrid\n");

            model_option = App.sc.nextInt();
            App.sc.nextLine();

            if(model_option == 1) model = EventModel.ONLINE;
            if(model_option == 2) model = EventModel.HYBRID;

            if(model_option < 0 || model_option > 2) System.out.println("\nInvalid value. Choose again:\n");

        } while(model_option < 0 || model_option > 2);

        System.out.print("\nEnter title: ");
        String title = App.sc.nextLine();

        System.out.print("Enter date of event (dd/mm/aaaa): ");
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
                System.out.print("How many organizations will participate the academic fair? ");
                int numberOfOrganizations = App.sc.nextInt();
                App.sc.nextLine();

                System.out.println("The fair is open to public?");
                int optionFair;
                boolean openToPublic = true;

                do {
                    System.out.print("0 - yes\n");
                    System.out.print("1 - no\n");

                    optionFair = App.sc.nextInt();
                    App.sc.nextLine();

                    if(optionFair == 1) openToPublic = false;
                    if(optionFair < 0 || optionFair > 1) System.out.println("Invalid option, try again!");

                } while (optionFair < 0 || optionFair > 1);

                AcademicFair f = new AcademicFair(title, date, place, max_participants, openToPublic, numberOfOrganizations, description, model);
                App.ev.addEvent(f);

                break;
            }
            case 1: {
                System.out.print("Duration of the course: ");
                int durationCourse = App.sc.nextInt();
                App.sc.nextLine();

                System.out.print("Enter professor's CPF: ");
                Professor p = null;

                do {

                    String professorCPF = App.sc.nextLine();
                    p = (Professor) App.pe.searchPerson(professorCPF);

                    if(p == null) System.out.print("Invalid CPF, digit again: ");

                } while(p != null);

                Course c = new Course(title, date, place, max_participants, durationCourse, p, description, model);
                App.ev.addEvent(c);

                break;
            }
            case 2: {
                System.out.print("Duration of the lecture: ");
                int durationLecture = App.sc.nextInt();
                App.sc.nextLine();

                System.out.print("Enter speaker's name: ");
                String speaker = App.sc.nextLine();

                Lecture l = new Lecture(title, date, place, max_participants, speaker, durationLecture, description, model);
                App.ev.addEvent(l);

                break;
            }
            case 3: {
                System.out.print("Tools required to the workshop: ");
                String toolsRequired = App.sc.nextLine();

                System.out.print("Enter instructor's name: ");
                String instructor = App.sc.nextLine();

                Workshop w = new Workshop(title, date, place, max_participants, toolsRequired, instructor, description, model);
                App.ev.addEvent(w);

                break;
            }
        }
    }
}
