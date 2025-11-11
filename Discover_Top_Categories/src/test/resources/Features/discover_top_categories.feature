Feature: Verify Discover Top Categories and Brochure Download Functionality on Edureka website

@TopCategories
Scenario: Navigate to selected categories from homepage
  Given the user is on the sourceUrl
  When the user scrolls to the sectionName section
  And clicks on category1
  And navigates back to homepage
  And clicks on category2
  And navigates back to homepage
  And clicks on category3
  Then each respective category page should load successfully
  
@Pg
Scenario Outline: Navigate to a category and apply for a program using data from Excel
  Given the user launches the application using data from <path> sheet <sheetno>
  When the user scrolls to the sectionName section
  And clicks on the category from Excel
  Then the category page should load successfully based on title from Excel
  And clicks on the apply button from Excel
  And enters valid name, email, and phone number from Excel
  Then the application form should be submitted successfully
  And a confirmation message should be displayed

Examples:
  | path          | sheetno | sectionName             |
  | testdata.xlsx | 0       | Discover Top Categories |

