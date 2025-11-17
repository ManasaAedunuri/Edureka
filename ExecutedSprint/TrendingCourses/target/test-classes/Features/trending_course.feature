Feature: Trending Courses
#level3:SME
@first
 Scenario: Open Edureka 
  Given the user launches the Edureka application
  Then the page title should be Instructor-Led Online Training with 24X7 Lifetime Support | Edureka
    
    
@second
 Scenario: View Trending Courses
  Given the user launches the Edureka application
  Given the user scrolls to the Trending Courses section
  When the user clicks on the page for LLM Prompt Engineering Certification Course
  Then the  LLM Prompt Engineering Certification Course Header should be displyed
  
  
@outline1
  Scenario Outline: Enroll in LLM Prompt Engineering Certification Course
  Given the user clicks on the Enroll Now button
  When the user enters email and phone number row <rowIndex>
  When clicks on the Enroll Now button in the form
  And the user should be redirected to the payment page
  Then the payment page should display the text Order Summary

 Examples:
|sheet | rowIndex |
|0     |0         |

        
 @outline2
 Scenario Outline: View More
 Given the user launches the Edureka application
 Given the user clicks on View More button
 And click on Get Sample Certificate button
 And the user enters Name and Email Id and Phone Number <rowIndex>
 And click on get certificate now button
 Then Thanks card should display
  
   Examples:
|sheet  | rowIndex |
|0      |0         |


  
@third 
Scenario: verify review 
  Given the user launches the Edureka application
  Given the user scrolls to the Trending Courses section
  When the user clicks on the page for LLM Prompt Engineering Certification Course
  And the user scrolls down to the Sitejabber Reviews section
  And the user clicks on the Sitejabber Reviews link
  Then the Sitejabber Reviews page should be displayed
  


      