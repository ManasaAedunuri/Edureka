Feature: View Trending Courses

  Scenario: Open Edureka and access LLM Prompt Engineering Certification
    Given the user launches the Edureka application
    When the user scrolls to the Trending Courses section
    And the user locates the coursename course card
    And the user clicks on the course card
    Then the course detail page for coursename should be displayed
    And the header Prompt Engineering Certification Course with LLM should be visible
    When the user scrolls down to the Sitejabber Reviews section
    And the user clicks on the Sitejabber Reviews link
    Then the Sitejabber Reviews page should be displayed