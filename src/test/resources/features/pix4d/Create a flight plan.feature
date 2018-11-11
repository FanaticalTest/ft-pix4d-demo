Feature: Create a flight plan
    
@FTSmokeTest @Id=01-02
Scenario: Create a flight plan - happy path
    Given the user is on the home page
    When the user creates a new flight plan
    And the user create a journey
    And the user add a flight plan description "This is a description"
    Then the user sees the flight plan card with the correct "This is a description"