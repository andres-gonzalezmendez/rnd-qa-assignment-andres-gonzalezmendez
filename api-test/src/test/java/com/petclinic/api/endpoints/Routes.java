package com.petclinic.api.endpoints;

public class Routes {

    public static String baseURL = "http://localhost:8080";

    // Owners
    public static String ownersURL = baseURL + "/owners";
    public static String ownerIdURL = ownersURL + "/{ownerId}";

    // Pets
    public static String ownerPetsURL = ownerIdURL + "/pets";
    public static String ownerPetIdURL = ownerPetsURL + "/{petId}";
    public static String petsURL = baseURL + "/pets";
    public static String petIdURL = petsURL + "/{petId}";

    // Vets
    public static String vetsURL = baseURL + "/vets";
    public static String vetIdURL = vetsURL + "{vetId}";

    // Visits
    public static String addVisitURL = ownerPetIdURL + "/visits";
    public static String visitsURL = baseURL + "/visits";
    public static String visitIdURL = visitsURL + "/{visitId}";

    // Pet Types
    public static String petTypesURL = baseURL + "/pettypes";
    public static String petTypeIdURL = petTypesURL + "/{petTypeId}";

    // Specialties
    public static String specialtiesURL = baseURL + "/specialties";
    public static String specialtyIdURL = specialtiesURL + "/{specialtyId}";
}
