package com.petclinic.api.payloads;

public class PetType {

    String name;

    public PetType(String name) {
        if (name == null) {
            throw new IllegalArgumentException("None of the parameters can be null");
        }
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
