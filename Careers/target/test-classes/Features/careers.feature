Feature: Careers Navigation and Internship Selection
@CI
Scenario: Navigate to Careers and select Internship
    Given I Launch the Edureka website
    When I scroll to the footer
	And I click on the target link
	Then I should be redirected to the target page
	When I scroll down to sectionName2
	And I click on sectionName3 under Marketing
	Then a new tab should open with job description
	And I scroll down to verify job details

@CT
Scenario: verify Blog navigation and select Ebook
    Given I Launch the Edureka website
    When I scroll to the footer
	And I click on the target link
	Then I should be redirected to the target page
	And I click on blog 
	And I click on ebook to get free ebooks in blog page
	And I click on bookName in ebooks page
	Then The Ebook is displayed

@SF
Scenario: 

