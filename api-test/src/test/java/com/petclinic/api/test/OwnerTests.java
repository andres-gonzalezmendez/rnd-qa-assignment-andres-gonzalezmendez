package com.petclinic.api.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.javafaker.Faker;
import com.petclinic.api.endpoints.OwnerEndPoints;
import com.petclinic.api.payloads.Owner;

import io.restassured.response.Response;

public class OwnerTests {

    static Faker faker;
    static Owner ownerPayload;

    @BeforeClass
    public static void setup() {

        faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String address = faker.address().streetAddress();
        String city = faker.address().cityName();
        String telephone = "6" + faker.number().digits(9).toString();

        ownerPayload = new Owner(firstName, lastName, address, city, telephone);
    }

    @Test
    public void testAddOwner() {

        Response response = OwnerEndPoints.addOwner(ownerPayload);
        response.then().log().all();

        Assert.assertEquals(201, response.getStatusCode());
    }

    @Test
    public void testGetOwners() {
        Response response = OwnerEndPoints.getOwners();
        response.then().log().all();

        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testUpdateOwner() {
        Response response = OwnerEndPoints.updateOwner(1, ownerPayload);
        response.then().log().all();

        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testDeleteOwner() {
        Response response = OwnerEndPoints.deleteOwner(1);
        response.then().log().all();

        Assert.assertEquals(200, response.getStatusCode());
    }

}
