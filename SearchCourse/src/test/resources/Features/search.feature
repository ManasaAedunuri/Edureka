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
Scenario: Verify View Courses
Given The browser is launched and the Edureka homepage is opened
When I click on the Search course bar
And I click on DevOps
And I click on View Details
And I click on Times Now
Then Times Now Article is visible

@fifth
Scenario Outline: Verify Form Submission
Given The browser is launched and the Edureka homepage is opened
When I click on the Search course bar
And I click on ChatGPT
And I click on Generative AI Course Masters Program
And I click Get in Touch
And I fill the form using data from sheet <sheet> and row <row>
And I click on submit
Then Thank You is displayed 

Examples:
| sheet  | row  |
|   2    |  1   |
|   2    |  2   |



