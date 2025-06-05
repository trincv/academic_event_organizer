package br.academic.utils.participant;

public class Student extends Person {
    private int codStudent;

    public Student(String name, String email, int codStudent) {
        super(name, email);
        this.codStudent = codStudent;
    }

    @Override
    public int getCod() {
        return codStudent;
    }
    
    @Override
    public String getCategory() {
        return "Student";
    }
}