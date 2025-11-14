Feature: Careers Navigation and Internship Selection
#@CI
#Scenario: Navigate to Careers and select Internship
    #Given I Launch the Edureka website
    #When I scroll to the footer
	#And I click on the target link
	#Then I should be redirected to the target page
	#When I scroll down to sectionName2
	#And I click on sectionName3 under Marketing
	#Then a new tab should open with job description
	#And I scroll down to verify job details

#@CT
#Scenario: verify Blog navigation and select Ebook
    #Given I Launch the Edureka website
    #When I scroll to the footer
	#And I click on the target link
	#Then I should be redirected to the target page
	#And I click on blog 
	#And I click on ebook to get free ebooks in blog page
	#And I click on bookName in ebooks page
	#Then The Ebook is displayed

#@SF
#Scenario Outline:Submit Form Application 
    #Given I Launch the Edureka website
    #When I scroll to the footer
	#And I click on the target link
	#Then I should be redirected to the target page
	#And I click on target1
	#And I click on form
	#And I fill the form using data from <sheet> <row>
	#And I submit the form
	#Then I should see the Thankyou popup and close it
   
    
   # Examples:
   #|  sheet   |  row  |
   #|  1       |  1    |
   #|  1       |  2    |
   #|  1       |  3    |
   
   
#@SF2
#Scenario Outline: Downloa Full Course List
    #Given I Launch the Edureka website
    #When I scroll to the footer
	#And I click on the target link
	#Then I should be redirected to the target page
	#And I click on target1 
	#And I scroll to curriculums section
	#And I click on Download button
	#And I fill the form using data from <sheet> <row> to download the list
	#And I click on submit
	#Then full course List is downloaded
	
	#Examples:
   #|  sheet |  row  |
   #|  2     |  1    |
   #|  2     |  2    |
   #|  2     |  3    |
   
   
@TS_05
Scenario: verify exploring video lectures   
   
    Given I Launch the Edureka website
    When I scroll to the footer
	And I click on the target link
	Then I should be redirected to the target page
	And I click on blog
	And I scroll to More Resources section to find target2
	And I click on target2
	And I scroll to find Recently Added Videos
	When I click on target3
	Then the video lectures page should be displayed
	
	
	
















