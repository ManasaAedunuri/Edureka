Feature: Verify Discover Top Categories and Brochure Download Functionality on Edureka website

@TopCategories
Scenario: Navigate to selected categories from homepage
  Given the user is on sourceUrl
  When the user scrolls to the sectionName section
  And clicks on category1
  And navigates back to homepage
  And clicks on category2
  And navigates back to homepage
  And clicks on category3
  Then each respective category page should load successfully
  
 @ViewMore
Scenario: Navigate to Selenium course under Software Testing
  Given the user is on the Edureka homepage
  When the user scrolls to the sectionName 
  And clicks on buttonName
  And clicks on category4
  And clicks on Selenium course
  Then the Selenium course page should load successfully
  
@AI
Scenario: Navigate to category pages from Discover Top Categories
  Given the user is on the  homepage
  When user scrolls to the sectionName 
  And clicks on the Category2
  Then the Category2 page should load successfully
  And clicks on category5
  And   display relevant courses
  
 @BrochureDownload
Scenario Outline: Download brochure for PGP in Generative AI and ML and fill details from Excel
  Given the user is on  Edureka homepage
  When user scrolls to the sectionName
  And clicks on category7
  And clicks on category8
  And clicks on buttonName2
  And the user reads data from Excel at <sheetNo> and <rowIndex>
  And enters name, email, and phone number from Excel
  Then the brochure request form should be submitted successfully


Examples:
  | sheetNo | rowIndex |
  | 0       | 1        |
  | 0       | 2        |

 
@EnrollNow
Scenario Outline: Enroll  for Generative AI course and fill details from Excel
  Given user is on Edureka homepage
  When scroll to sectionName
  And clicks on buttonName
  And click on the category4
   And clicks on the Selenium course
  And the user reads data from Excel at <sheetNo> and <rowIndex>
  And clicks on buttonName3
  And email, and phone number from Excel
  Then the request form should be submitted successfully

Examples:
  | sheetNo | rowIndex |
  | 1       | 1        |
  | 1       | 2        |
  
  @scenario6
 Scenario Outline:enroll for course with invalid data
  Given user is on Edureka homepage
  When scroll to sectionName
  And clicks on buttonName
  And click on the category4
   And clicks on the Selenium course
  And the user reads data from Excel at <sheetNo> and <rowIndex>
  And clicks on buttonName3
  And email, and phone number from Excel
  Then the error message should be displayed

Examples:
  | sheetNo | rowIndex |
  | 2       | 1        |




