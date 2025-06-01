package br.academic.utils.participant;

public class Student extends Person {

    public Student(String name, String email, int ID) {
        super(name, email, ID);
    }

    @Override
    public String getCategory() {
        return "Student";
    }
}