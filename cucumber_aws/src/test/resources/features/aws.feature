@Login2Aws
Feature: As an candidate to Cafeto
  I want to login profile to aws amazon using account example credentials
  In order to demonstrate my skills in java+cucumber

  Scenario: User navigates to AWS Amazon Account Settings Page
    Given I am on the "AWS Amazon" page on URL "https://aws.amazon.com/"
    And I select the "My Account / Account Settings" Menu
    And I should see "Sign in" message
    When I fill in "userEmail" with "solmarkn@gmail.com"
    And I click on the "Next" button
    And I fill in "Password" with "123"
    And I click on the "Sign In" button
    Then I am on the "My profile" page on URL "https://console.aws.amazon.com/billing/home?#/account"
