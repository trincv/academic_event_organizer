package br.academic.utils.participant;

public class Professor extends Person {
    private int codProfessor;

    public Professor(String name, String email, int codProfessor) {
        super(name, email);
        this.codProfessor = codProfessor;
    }

    @Override
    public int getCod() {
        return codProfessor;
    }

    @Override
    public String getCategory() {
        return "Professor";
    }
}