Feature: Google Maps Navigation

  Scenario: Navigate to a specific location
    Given I open Google Maps
    When I search for "Alicante"
    Then the location "Alicante" should be displayed