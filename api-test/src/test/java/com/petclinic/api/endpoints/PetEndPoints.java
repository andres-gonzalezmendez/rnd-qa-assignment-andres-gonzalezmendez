package com.petclinic.api.endpoints;

import static io.restassured.RestAssured.given;

import com.petclinic.api.payloads.Pet;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {
    public static Response addPetToOwner(Pet payload, Integer ownerId) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("ownerId", ownerId)
                .body(payload)
                .when()
                .post(Routes.ownerPetsURL);

        return response;
    }

    public static Response getPetById(Integer ownerId, Integer petId) {
        Response response = given()
                .pathParam("ownerId", ownerId)
                .pathParam("petId", petId)
                .when()
                .get(Routes.ownerPetIdURL);

        return response;
    }

    public static Response getPetById(Integer petId) {
        Response response = given()
                .pathParam("petId", petId)
                .when()
                .get(Routes.petIdURL);

        return response;
    }

    public static Response updateOwnersPet(Pet payload, Integer ownerId, Integer petId) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("ownerId", ownerId)
                .pathParam("petId", petId)
                .body(payload)
                .when()
                .put(Routes.ownerPetIdURL);

        return response;
    }

    public static Response getPets() {
        Response response = given()
                .when()
                .get(Routes.petsURL);

        return response;
    }

    public static Response createPet(Pet payload) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.petsURL);

        return response;
    }

    public static Response updatePetById(Pet payload, Integer petId) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("petId", petId)
                .body(payload)
                .when()
                .put(Routes.petIdURL);

        return response;
    }

    public static Response deletePet(Integer petId) {
        Response response = given()
                .pathParam("petId", petId)
                .when()
                .delete(Routes.petIdURL);

        return response;
    }
}
