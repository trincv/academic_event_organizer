package br.academic.utils.events;

import br.academic.enums.EventModel;
import br.academic.utils.participant.*;
import java.util.HashMap;

public class Course extends Events {
    private int durationCourse;
    private Professor professorCourse; 

    public Course(String title, String date, String place, int maxParticipants, int durationCourse, Professor professorCourse, String description, EventModel model, int ID) {
        super(title, date, place, maxParticipants, description, model, ID);
        this.durationCourse = durationCourse;
        this.professorCourse = professorCourse;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Professor: " + professorCourse.getName() + " / Duration: " + durationCourse + "\n");
    }

    public boolean subscribePerson(Person person) {
        if(!(person instanceof Student)){
            System.err.println("Error: The person isn's a student so it can't participate the course.");
            return false;
        }
        if(!(registered.size() < maxParticipants)) {
            System.err.println("Error: The event is already at full capacity.");
            return false;
        } 
        if (registered.containsKey(person.getCPF())) { 
        System.err.println("Error: Person is already subscribed to this course.");
        return false;
        }

        registered.put(person.getCPF(), person);

        return true;
    }
}