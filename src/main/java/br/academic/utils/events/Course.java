package br.academic.utils.events;

import br.academic.utils.participant.*;
import java.util.HashMap;

public class Course extends Events {
    private int durationCourse;
    private String professorCourse; 

    public Course(String title, String date, String place, int max_participants, int durationCourse, String professorCourse, String description) {
        super(title, date, place, max_participants, description);
        this.durationCourse = durationCourse;
        this.professorCourse = professorCourse;
    }

    @Override
    public void displayEvent() {
        System.out.println("Type: Course!\n" + "Professor: " + professorCourse + "\nDuration: " + durationCourse);
        super.displayEvent();
    }

    public boolean AddPerson(Object obj) {

        if(!(obj instanceof Person)) return false;
        if(!(obj instanceof External)) return false;
        if(!(registered.size() < max_participants)) return false; 
        Person p = (Person) obj;
        registered.put(p.getId(), p);
        return true;
    }

    public void getAllSubscribed() {
        for(Integer key : registered.keySet()) {
            registered.get(key).display();
        }
    }
}