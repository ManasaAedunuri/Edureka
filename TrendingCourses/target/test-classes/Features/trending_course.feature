 Feature: Trending Courses
#level3:SME
  Scenario: Open Edureka 
    Given the user launches the Edureka application
    Then the page title should be Instructor-Led Online Training with 24X7 Lifetime Support | Edureka
    
    

 Scenario: View Trending Courses
  Given the user launches the Edureka application
  Given the user scrolls to the Trending Courses section
  When the user clicks on the page for LLM Prompt Engineering Certification Course
  #And  the course detail page for LLM Prompt Engineering Certification Course should be displayed
  Then the  LLM Prompt Engineering Certification Course page should be displyed
  
   # Scenario: 
   # When the user scrolls down to the Sitejabber Reviews section
   # And the user clicks on the Sitejabber Reviews link
    #Then the Sitejabber Reviews page should be displayed
    
    

  Scenario: Enroll in LLM Prompt Engineering Certification Course
  Given The user launches the application as Edureka
  Given the user scrolls to the Trending Courses section
  When the user clicks on the page for LLM Prompt Engineering Certification Course
  #And  the course detail page for LLM Prompt Engineering Certification Course should be displayed
  Then the  LLM Prompt Engineering Certification Course page should be displyed
    
    #And the user clicks on the Enroll Now button
    #Then the enrollment form should appear
    #When the user enters email "<email>" and phone number "<phone>"
    #And clicks on the Enroll Now button in the form
    #And the user should be redirected to the payment page
   # Then the payment page should display the text "Order Summary"

    Examples:
      | email                  | phone        |
      | abc@gmail.com | 9063671540   |
    
     
    
    