package br.academic.utils.events;

import br.academic.utils.participant.*;
import java.util.HashMap;

public class Course extends Events {
    private int durationCourse;
    private Professor professorCourse; 

    public Course(String title, String date, String place, int max_participants, int durationCourse, Professor professorCourse, String description, EventModel model, int ID) {
        super(title, date, place, max_participants, description, model, ID);
        this.durationCourse = durationCourse;
        this.professorCourse = professorCourse;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Professor: " + professorCourse.getName() + " / Duration: " + durationCourse);
    }

    public boolean addPerson(Object obj) {

        if(!(obj instanceof Person)) return false;
        if(!(obj instanceof Student)) return false;
        if(!(registered.size() < max_participants)) return false; 
        Person p = (Person) obj;
        registered.put(p.getCPF(), p);
        return true;
    }
}