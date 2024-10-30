package com.petclinic.api.payloads;

public class Owner {

    String firstName;
    String lastName;
    String address;
    String city;
    String telephone;

    public Owner(String firstName, String lastName, String address, String city, String telephone) {
        if (firstName == null || lastName == null || address == null || city == null || telephone == null) {
            throw new IllegalArgumentException("None of the parameters can be null");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getTelephone() {
        return telephone;
    }
}
