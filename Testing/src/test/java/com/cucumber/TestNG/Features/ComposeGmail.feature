@all
Feature: New Gmail Compose

  Background: 
    Given User Open URL
    When User enters id as "gtest1434@gmail.com" on LoginPage
    And User clicks on Next button on LoginPage
    Then User enters password as "password" on LoginPage
    And User clicks on Next button on LoginPage
    Then User should validate gmail HomePage

  @s1
  Scenario Outline: Testing Gmail Compose Fumctionality
    When User clicks on compose button on HomePage
    Then User validates New Message Window on HomePage
    When User enters "<toValue>" To email on HomePage
    And User enters "<ccValue>" CC email on HomePage
    And User enters "<bccValue>" BCC email on HomePage
    And User enters Subject as "New Email Test" on HomePage
    Then User enters body as "Email Body" on HomePage
    And User adds attachment on HomePage
    Then User clicks on Send button on HomePage

    Examples: 
      | toValue     | ccValue     | bccValue    |
      | abc@pqr.com | pqr@xyz.com | xyz@abc.com |

  @s2
  Scenario Outline: Testing Error for invalid To email data or empty subject
    When User clicks on compose button on HomePage
    Then User validates New Message Window on HomePage
    When User enters "<toValue>" To email on HomePage
    #And User enters Subject as "New Email Test" on HomePage
    Then User enters body as "Email Body" on HomePage
    Then User clicks on Send button on HomePage
    Then User velidates error for To email on HomePage
		Then User velidates error for Subject on HomePage
    Examples: 
      | toValue |
      | abcd    |

  @s3
  Scenario Outline: Testing Error for invalid cc email data
    When User clicks on compose button on HomePage
    Then User validates New Message Window on HomePage
    When User enters "<toValue>" To email on HomePage
    And User enters "<ccValue>" CC email on HomePage
    And User enters Subject as "New Email Test" on HomePage
    Then User enters body as "Email Body" on HomePage
    Then User clicks on Send button on HomePage
    Then User velidates error for To email on HomePage

    Examples: 
      | toValue     | ccValue |
      | abc@pqr.com | abcd    |

  @s4
  Scenario Outline: Testing Error for invalid bcc email data
    When User clicks on compose button on HomePage
    Then User validates New Message Window on HomePage
    When User enters "<toValue>" To email on HomePage
    And User enters "<ccValue>" CC email on HomePage
    And User enters "<bccValue>" BCC email on HomePage
    And User enters Subject as "New Email Test" on HomePage
    Then User enters body as "Email Body" on HomePage
    Then User clicks on Send button on HomePage
    Then User velidates error for To email on HomePage

    Examples: 
      | toValue     | ccValue     | bccValue |
      | abc@pqr.com | pqr@xyz.com | abcd     |
      
      @s5
  Scenario Outline: Testing Error for no subject and body data
    When User clicks on compose button on HomePage
    Then User validates New Message Window on HomePage
    When User enters "<toValue>" To email on HomePage
    Then User clicks on Send button on HomePage
    Then User velidates error for empty Subject on HomePage

    Examples: 
      | toValue     |
      | abc@pqr.com |
