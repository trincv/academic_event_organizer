package br.academic.utils.participant;

public class External extends Person {
    private int codExternal;

    public External(String name, String email, int codExternal) {
        super(name, email);
        this.codExternal = codExternal;
    }

    @Override
    public int getCod() {
        return codExternal;
    }

    @Override
    public String getCategory() {
        return "External";
    }
}