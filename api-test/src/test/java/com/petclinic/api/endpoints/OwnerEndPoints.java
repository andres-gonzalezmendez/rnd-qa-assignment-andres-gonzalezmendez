package com.petclinic.api.endpoints;

import static io.restassured.RestAssured.given;

import com.petclinic.api.payloads.Owner;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class OwnerEndPoints {
    public static Response addOwner(Owner payload) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.ownersURL);

        return response;
    }

    public static Response getOwners() {
        Response response = given()
                .when()
                .get(Routes.ownersURL);

        return response;
    }

    public static Response getOwnerById(Integer ownerId) {
        Response response = given()
                .pathParam("ownerId", ownerId)
                .when()
                .get(Routes.ownerIdURL);

        return response;
    }

    public static Response updateOwner(Integer ownerId, Owner payload) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("ownerId", ownerId)
                .body(payload)
                .when()
                .put(Routes.ownerIdURL);

        return response;
    }

    public static Response deleteOwner(Integer ownerId) {
        Response response = given()
                .pathParam("ownerId", ownerId)
                .when()
                .delete(Routes.ownerIdURL);

        return response;
    }
}
