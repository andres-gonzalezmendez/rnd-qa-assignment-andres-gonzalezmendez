package com.petclinic.api.payloads;

public class Pet {

    String name;
    String birthDate;
    PetType type;

    public Pet(String name, String birthDate, PetType type) {
        if (name == null || birthDate == null || type == null) {
            throw new IllegalArgumentException("None of the parameters can be null");
        }
        this.name = name;
        this.birthDate = birthDate;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public PetType getType() {
        return type;
    }
}
