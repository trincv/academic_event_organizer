package br.academic.utils.participant;

public class Professor extends Person {

    public Professor(String name, String email, int ID) {
        super(name, email, ID);
    }

    @Override
    public String getCategory() {
        return "Professor";
    }
}