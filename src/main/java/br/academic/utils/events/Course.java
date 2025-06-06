package br.academic.utils.events;

import br.academic.utils.participant.*;
import java.util.HashMap;

public class Course extends Events {
    private int durationCourse;
    private Professor professorCourse; 

    public Course(String title, String date, String place, int max_participants, int durationCourse, Professor professorCourse, String description, EventModel model) {
        super(title, date, place, max_participants, description, model);
        this.durationCourse = durationCourse;
        this.professorCourse = professorCourse;
    }

    @Override
    public void displayEvent() {
        System.out.println("Type: Course!\n" + "Professor: " + professorCourse.getName() + "\nDuration: " + durationCourse);
        super.displayEvent();
    }

    public boolean AddPerson(Object obj) {

        if(!(obj instanceof Person)) return false;
        if(!(obj instanceof Student)) return false;
        if(!(registered.size() < max_participants)) return false; 
        Person p = (Person) obj;
        registered.put(p.getCPF(), p);
        return true;
    }

    public void getAllSubscribed() {
        for(String key : registered.keySet()) {
            registered.get(key).display();
        }
    }
}