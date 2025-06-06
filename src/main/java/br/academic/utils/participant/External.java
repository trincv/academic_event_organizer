package br.academic.utils.participant;

public class External extends Person {

    public External(String name, String email, String CPF) {
        super(name, email, CPF);
    }

    @Override
    public String getCategory() {
        return "External";
    }
}