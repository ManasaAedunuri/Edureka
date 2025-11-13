Feature: Validate Search Course functionality on Edureka website

@first
Scenario: Verify scarch navigation and course details for valid course
Given The browser is launched and the Edureka homepage is opened
When I click on the Search course bar
And I enter a Big Data in the search input field
Then The search results page should be displayed
When I click on Big Data Hadoop Certification Training Course from the search results
Then The course details page should be displayed

@second
Scenario: Verify navigating through Popular Courses and applying filters
Given The browser is launched and the Edureka homepage is opened
When I click on the Search course bar
And I click on aws technology
And The user clicks on Job Role
And Select filter from AWS page
Then The page should display Cloud Devops courses

@third
Scenario Outline: Verify Search Courses
Given The browser is launched and the Edureka homepage is opened
When I click on the Search course bar
And I enter course name from sheet <sheet> and row <row>
Then Search results page should be displayed

Examples:
| sheet | row |
|   0   |  0  |
|   0   |  1  |

@fourth
Scenario Outline: Verify Edureka Reviews
Given The browser is launched and the Edureka homepage is opened
When I click on the Search course bar
And I click on Artificial Intelligence
And I click on Sitejabber review button
And I enter website name from sheet <sheet2> and row <row2>
Then Reviews page of website should be displayed

Examples:
| sheet2 | row2 |
|   1    |  0   |
|   1    |  1   |


#@fourth
#Scenario Outline: Verify Popular Course Categories 
#Given The browser is launched and the Edureka homepage is opened
#When I click on the Search course bar
#And I click on Cloud Computing
#And I click on search input field
#And I enter course name from sheet <sheet> and row <row>
#Then Courses page is visible






