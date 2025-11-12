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
Scenario Outline:Submit Form Application 
    Given I Launch the Edureka website
    When I scroll to the footer
	And I click on the target link
	Then I should be redirected to the target page
	And I click on target1
	And I click on form
	And I fill the form using data from "<sheet>" "<row>"
	And I submit the form
	Then I should see the Thankyou popup and close it
    #And I enter Company Name as <company_name>
    #And I select Training Need as <training_need>
    #And I enter Email ID as <email>
    #And I enter Phone Number as <phone>
    #And I enter Query as <query>
    #And I submit the form
    #Then the form should be submitted successfully
    
    Examples:
   |  sheet   |  row  |
   |  sheet1  |  1    |
   |  sheet1  |  2    |
   |  sheet1  |  3    |
	
	
	
















