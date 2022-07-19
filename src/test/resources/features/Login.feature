Feature: Login

#  In questo primo test, il test script ha il compito di testare la funzione core dell'accesso
#  al sito. Attraverso il tool cucumber, posso applicare il pattern del Behavior Driven
#  Development

  #Step1
  Scenario: Log-in in AlpiTour site
    When I go to "http://my.alpitourworld.com"
    And I fill "alestassa@gmail.com" as a username and "rtnpHLD8-" as a password
    And I click accediButton if is present





