package br.academic.utils.participant;

public abstract class Person {
    protected String name;
    protected String email;
    protected String CPF;

    public Person(String name, String email, String CPF) {
        this.name = name;
        this.email = email;
        this.CPF = CPF;
    }

    public abstract String getCategory();

    public String getCPF() {
        return CPF;
    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public void displayPerson() {
        System.out.println("[" + this.getClass().getSimpleName() + "] " + "Name: "+ name + " / " + "Email: " + email + " / " + "CPF: " + CPF);
    }

}