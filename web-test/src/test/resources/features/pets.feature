Feature: Pets

  Scenario: Add new pet to an owner
    Given User launches browser
    When User opens URL "http://localhost:8080"
    And User selects "Owners" tab in top menu
    And User selects "Register" option in dropdown menu
    And User enters values for "Owner" fields
    And User selects "Submit" button
    And User clicks on new owner's name
    And User selects "Add New Pet" button
    And User enters values for "Pet" fields
    And User selects "Submit" button
    Then Owner details page is presented
    And New pet is in the list
    And User closes browser