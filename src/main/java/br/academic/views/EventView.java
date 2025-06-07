package br.academic.views;

import java.util.Scanner;
import br.academic.utils.events.*;
import br.academic.utils.participant.*;
import br.academic.core.App;
import java.lang.Thread;
import java.lang.Exception;

public class EventView {

    public static void eventRegister() {
        int type_option, model_option;
        EventModel model = EventModel.INPERSON;

        App.clearScreen();
        System.out.println("\n-- Register an event --\n");

        System.out.println("0 - Academic fair");
        System.out.println("1 - Course");
        System.out.println("2 - Lecture");
        System.out.println("3 - Workshop");
        System.out.print("\n\nChoose type of event: ");
        do {

            type_option = App.sc.nextInt();
            App.sc.nextLine();

            if(type_option < 0 || type_option > 3) System.out.print("Invalid value! Digite again: ");

        } while(type_option < 0 || type_option > 3);

        System.out.println("\n0 - In person");
        System.out.println("1 - Online");
        System.out.println("2 - Hybrid");

        System.out.print("\nEnter event model: ");

        do {

            model_option = App.sc.nextInt();
            App.sc.nextLine();

            if(model_option == 1) model = EventModel.ONLINE;
            if(model_option == 2) model = EventModel.HYBRID;

            if(model_option < 0 || model_option > 2) System.out.print("Invalid value! Choose again: ");

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

                App.clearScreen();
                System.out.println("\nEvent academic fair created with sucess!");

                try{
                    Thread.sleep(2 * 1000);
                } catch(Exception e) {}
                App.clearScreen();

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

                } while(p == null);

                Course c = new Course(title, date, place, max_participants, durationCourse, p, description, model);
                App.ev.addEvent(c);

                App.clearScreen();
                System.out.println("\nEvent course created with sucess!");

                try{
                    Thread.sleep(2 * 1000);
                } catch(Exception e) {}
                App.clearScreen();

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

                App.clearScreen();
                System.out.println("\nEvent lecture created with sucess!");

                try{
                    Thread.sleep(2 * 1000);
                } catch(Exception e) {}
                App.clearScreen();

                break;
            }
            case 3: {
                System.out.print("Tools required to the workshop: ");
                String toolsRequired = App.sc.nextLine();

                System.out.print("Enter instructor's name: ");
                String instructor = App.sc.nextLine();

                Workshop w = new Workshop(title, date, place, max_participants, toolsRequired, instructor, description, model);
                App.ev.addEvent(w);

                App.clearScreen();
                System.out.println("\nEvent workshop created with sucess!");

                try{
                    Thread.sleep(2 * 1000);
                } catch(Exception e) {}
                App.clearScreen();
                break;
            }
        }
    }
}
