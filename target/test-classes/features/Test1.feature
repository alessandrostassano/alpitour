Feature: Test1

  #Step1
  Scenario: Log-in in Linkedin with my credentials and search job offers
    When I go to "http://my.alpitourworld.com"
    And I fill "alestassa@gmail.com" as a username and "rtnpHLD8-" as a password
    #And I accept coockie button
    And I click accediButton if is present
    And I fill "automation tester" in the search bar
    And I select "Offerte di lavoro" in the filter bar for the city of "Torino"





