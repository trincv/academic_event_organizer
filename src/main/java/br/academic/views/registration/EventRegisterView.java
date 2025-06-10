package br.academic.views.registration;

import br.academic.core.App;
import br.academic.enums.EventModel;
import br.academic.utils.events.*;
import br.academic.utils.participant.*;
import java.lang.Thread;
import java.lang.Exception;

public class EventRegisterView {

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

        System.out.print("Enter event's ID: ");
        int ID = App.sc.nextInt();
        App.sc.nextLine();

        System.out.print("Enter date of event (dd/mm/aaaa): ");
        String date = App.sc.nextLine();

        System.out.print("Enter place: ");
        String place = App.sc.nextLine();

        System.out.print("Enter max participants: ");
        int maxParticipants = App.sc.nextInt();
        App.sc.nextLine();

        System.out.print("Enter description: ");
        String description = App.sc.nextLine();

        switch(type_option) {
            case 0: {
                System.out.print("How many organizations will participate the academic fair? ");
                int numberOfOrganizations = App.sc.nextInt();
                App.sc.nextLine();

                System.out.println("The fair is open to public?\n");
                int optionFair;
                boolean openToPublic = true;

                do {
                    System.out.print("0 - yes\n");
                    System.out.println("1 - no\n");

                    optionFair = App.sc.nextInt();
                    App.sc.nextLine();

                    if(optionFair == 1) openToPublic = false;
                    if(optionFair < 0 || optionFair > 1) System.out.println("Invalid option, try again!");

                } while (optionFair < 0 || optionFair > 1);

                AcademicFair academicFair = new AcademicFair(title, date, place, maxParticipants, openToPublic, numberOfOrganizations, description, model, ID);
                App.ev.addEvent(academicFair);

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
                Professor professor = null;

                do {

                    String professorCPF = App.sc.nextLine();

                    if(App.pe.searchPerson(professorCPF) instanceof Professor) professor = (Professor) App.pe.searchPerson(professorCPF);

                    if(professor == null) System.out.print("Invalid CPF, digit again: ");

                } while(professor == null);

                Course course = new Course(title, date, place, maxParticipants, durationCourse, professor, description, model, ID);
                App.ev.addEvent(course);

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

                Lecture lecture = new Lecture(title, date, place, maxParticipants, speaker, durationLecture, description, model, ID);
                App.ev.addEvent(lecture);

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

                Workshop workshop = new Workshop(title, date, place, maxParticipants, toolsRequired, instructor, description, model, ID);
                App.ev.addEvent(workshop);

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
