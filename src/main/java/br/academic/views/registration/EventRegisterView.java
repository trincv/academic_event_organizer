package br.academic.views.registration;

import br.academic.core.App;
import br.academic.enums.EventModel;
import br.academic.utils.validations.*;
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

        type_option = InputInt.scanInt(0,3);
            
        System.out.println("\n0 - In person");
        System.out.println("1 - Online");
        System.out.println("2 - Hybrid");

        System.out.print("\nEnter event model: ");

        model_option = InputInt.scanInt(0,2);

        if(model_option == 1) model = EventModel.ONLINE;
        if(model_option == 2) model = EventModel.HYBRID;

        System.out.print("\nEnter title: ");
        String title = App.sc.nextLine();

        System.out.print("Enter event's ID: ");

        int ID;
        do {
            ID = InputInt.scanInt();
            if(App.ev.searchEvent(ID) == null)
                break;
            else
                System.err.print("Error: Can not exists two events with the same ID. Digit again: ");
        } while(true);

        System.out.print("Enter date of event (dd/mm/aaaa): ");
        String date = DateValidation.getValidDateInput();

        System.out.print("Enter place: ");
        String place = App.sc.nextLine();

        System.out.print("Enter max participants: ");
        int maxParticipants = InputInt.scanInt();

        System.out.print("Enter description: ");
        String description = App.sc.nextLine();

        switch(type_option) {
            case 0: {
                System.out.print("How many organizations will participate the academic fair? ");
                int numberOfOrganizations = InputInt.scanInt();

                System.out.println("The fair is open to public?");
                int optionFair;
                boolean openToPublic = true;

                System.out.print("0 - yes\n");
                System.out.println("1 - no\n");

                optionFair = InputInt.scanInt(0,1);

                if(optionFair == 1) openToPublic = false;

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
                System.out.print("Duration of the course (hours): ");
                int durationCourse = InputInt.scanInt();

                System.out.print("Enter professor's CPF: ");
                Professor professor = null;

                do {

                    String professorCPF = CpfValidation.getValidCpfInput();

                    if(App.pe.searchPerson(professorCPF) instanceof Professor) professor = (Professor) App.pe.searchPerson(professorCPF);

                    if(professor == null) System.out.print("Professor not found, digit again: ");

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
                System.out.print("Duration of the lecture (minutes): ");
                int durationLecture = InputInt.scanInt();

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
