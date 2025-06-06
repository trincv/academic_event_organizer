package br.academic.utils.participant;

public class Student extends Person {

    public Student(String name, String email, String CPF) {
        super(name, email, CPF);
    }

    @Override
    public String getCategory() {
        return "Student";
    }
}