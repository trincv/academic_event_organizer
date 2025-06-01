package br.academic.utils.participant;

public class External extends Person {

    public External(String name, String email, int ID) {
        super(name, email, ID);
    }

    @Override
    public String getCategory() {
        return "External";
    }
}