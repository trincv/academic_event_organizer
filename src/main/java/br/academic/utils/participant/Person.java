package br.academic.utils.participant;

public abstract class Person {
    protected String name;
    protected String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public abstract String getCategory();

    public abstract int getCod();

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public void display() {
        System.out.println("Name: "+ name + " / " + "Email: " + email);
    }

}