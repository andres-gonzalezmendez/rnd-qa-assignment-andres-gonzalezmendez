Feature: Owners

  Scenario: List of all owners
    Given User launches browser
    When User opens URL "http://localhost:8080"
    And User selects "Owners" tab in top menu
    And User selects "All" option in dropdown menu
    Then List of all owners is presented
    And User closes browser

  Scenario: Add new owner
    Given User launches browser
    When User opens URL "http://localhost:8080"
    And User selects "Owners" tab in top menu
    And User selects "Register" option in dropdown menu
    And User enters values for "Owner" fields
    And User selects "Submit" button
    Then List of all owners is presented
    And New owner is in the list
    And User closes browser
