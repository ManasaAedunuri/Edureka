Feature: Navigate to Edureka Blog and open Machine Learning with Mahout article
Scenario: user navigates through Website to open blog
    Given the user opens the browser
    When the user navigates to the homepage
    And the user clicks on the menu
    And the user clicks on the subMenu
    And the user selects the category
    And the user clicks on the article
    Then the article page should be displayed
   

Scenario: user registers for a webinar using dynamic data
    Given the user opens the browser
    When the user navigates to the homepage from configuration
    And the user clicks on the menu from configuration
    And the user clicks on the submenu from configuration
    And the user searches for the keyword from configuration
    And the user selects the webinar title from configuration
    And the user scrolls and clicks on the register button from configuration
    Then the user should see the confirmation section from configuration  
    
    