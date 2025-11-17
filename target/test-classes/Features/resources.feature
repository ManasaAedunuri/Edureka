Feature: Navigate to Edureka Blog and open Machine Learning with Mahout article
@resources
Scenario: user navigates through Website to open blog
    Given the user opens the browser
    When the user navigates to the homepage
    And the user clicks on the menu
    And the user clicks on the subMenu
    And the user selects the category
    And the user clicks on the article
    Then the article page should be displayed
   
@webinar
Scenario: user registers for a webinar using dynamic data
    Given the user opens the browser
    When the user navigates to the homepage from configuration
    And the user clicks on the menu from configuration
    And the user clicks on the submenu from configuration
    And the user searches for the keyword from configuration
    Then the user should see the confirmation section from configuration 
    
    
@ask
  Scenario: User navigates to Ask a Question page and verifies the header text
    Given the user opens the browser
    When the user clicks on the menu from Properies file
    And the user clicks on the submenu from Properties file 
    And the user clicks on the ask a question button using the ID from the properties file
    Then the user should see the header text on the Ask a Question page matches the expected value from the properties file
    

@community
 Scenario Outline: User searches and joins a community on Edureka 
  Given the user opens the browser 
  When the user navigates to the homepage from Property file with row <rowIndex>
  And the user clicks on the menu from Property file 
  And the user clicks on the submenu from Property file 
  And the user searches for the community from Excel 
  Then the user should be able to view and join the community from Excel
  
Examples:

| rowIndex | 
| 0        |
| 1        | 
| 2        | 




@searchCourses
 Scenario Outline: User searches and validates courses dynamically from Excel
   Given the user opens the browser
   When the user navigates to the homepage from the property file
    And the user clicks on the menu 
    And the user selects the submenu 
    And the user navigates to the section 
    And the user searches for each course listed <rowIndex>
    Then validate the search course with displayed course

Examples:
| rowIndex | 
| 0        |
| 1        | 
| 2        | 

     
    
    