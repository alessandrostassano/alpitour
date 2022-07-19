Feature: SearchHolidays1

  #Step1
  Scenario: Log-in in AlpiTour and search a results for Sicily on the date 24 July
    When I go to "http://my.alpitourworld.com"
    And I fill "alestassa@gmail.com" as a username and "rtnpHLD8-" as a password
    And I click accediButton if is present

  #Step2
    And I accept coockie button
    And I fill Sicilia - Italia in the search bar
    Then I select the first result of the searching
    And I select MILANO MALPENSA as an airport to departure
    And I book for two people and i continue
    And I click 24 July and i go to the results page




