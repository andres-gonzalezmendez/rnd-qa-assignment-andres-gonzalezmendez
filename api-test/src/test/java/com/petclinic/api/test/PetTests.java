package com.petclinic.api.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.javafaker.Faker;
import com.petclinic.api.endpoints.PetEndPoints;
import com.petclinic.api.payloads.Pet;
import com.petclinic.api.payloads.PetType;

import io.restassured.response.Response;

public class PetTests {

    static Faker faker;
    static Pet petPayload;

    @BeforeClass
    public static void setup() {

        faker = new Faker();

        String name = faker.name().firstName();

        Date randomDate = faker.date().past(10000, TimeUnit.DAYS);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthDate = dateFormat.format(randomDate);

        String petType = faker.animal().name();
        PetType type = new PetType(petType);

        petPayload = new Pet(name, birthDate, type);
    }

    @Test
    public void testAddPetToOwner() {

        Response response = PetEndPoints.addPetToOwner(petPayload, 1);
        response.then().log().all();

        Assert.assertEquals(201, response.getStatusCode());
    }

    @Test
    public void testGetPetByOwnerAndPetId() {
        Response response = PetEndPoints.getPetById(1, 1);
        response.then().log().all();

        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testGetPetByPetId() {
        Response response = PetEndPoints.getPetById(1);
        response.then().log().all();

        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testUpdateOwnersPet() {
        Response response = PetEndPoints.updateOwnersPet(petPayload, 1, 1);
        response.then().log().all();

        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testGetPets() {
        Response response = PetEndPoints.getPets();
        response.then().log().all();

        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testCreatePet() {
        Response response = PetEndPoints.createPet(petPayload);
        response.then().log().all();

        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testUpdatePetById() {
        Response response = PetEndPoints.updatePetById(petPayload, 1);
        response.then().log().all();

        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testDeletePetById() {
        Response response = PetEndPoints.deletePet(1);
        response.then().log().all();

        Assert.assertEquals(200, response.getStatusCode());
    }
}
