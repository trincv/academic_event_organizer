package br.academic.utils.participant;

import br.academic.utils.interfaces.Idisplayable;

public abstract class Person implements Idisplayable {
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

    @Override
    public void display() {
        System.out.println("[" + this.getClass().getSimpleName() + "] " + "Name: "+ name + " / " + "Email: " + email + " / " + "CPF: " + CPF);
    }
}