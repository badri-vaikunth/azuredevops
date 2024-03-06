Feature: Oney based services

  Scenario: Make a session call with all valid values
    Given the session service is up and running
    When I hit the session api with all valid values
    Then the response should be 200 and valid session id
    And merchantURL should be generated and payment should be successful


  Scenario: Make a session call with empty currency
    Given the session service is up and running
    When I hit the session api with empty currency
    Then the response should be 200 and it should get rejected

  Scenario: Make a session call with invalid currency
    Given the session service is up and running
    When I hit the session api with invalid currency
    Then the response should be 200 and it should get rejected

  Scenario: Make a session call with negative amount
    Given the session service is up and running
    When I hit the session api with negative amount
    Then the response should be 200 and it should get reject

  Scenario: Make a session call with empty apPaymentType
    Given the session service is up and running
    When I hit the session api with empty apPaymentType
    Then the response should be 200 and it should get reject

  Scenario: Make a session call with  empty billTo fields
    Given the session service is up and running
    When I hit the session api with empty billTo fields
    Then the response should be 200 and it should get reject

  Scenario: Make a session call with  empty shipTo fields
    Given the session service is up and running
    When I hit the session api with empty shipTo fields
    Then the response should be 200 and it should get reject

  Scenario: Make a session call with firstName value.length > 60
    Given the session service is up and running
    When I hit the session api with firstName value.length > 60
    Then the response should be 200 and it should get reject

  Scenario: Make a session call with phoneNumber value.length > 15
    Given the session service is up and running
    When I hit the session api with phoneNumber value.length > 15
    Then the response should be 200 and it should get reject



#Auth Apis

  Scenario: Make an auth call with all valid values
    Given the auth service is up and running
    When I hit the auth api with all valid values
    Then the response should be 200 and valid auth id

  Scenario: Make an auth call with  empty currency
    Given the auth service is up and running
    When I hit the auth api with empty currency
    Then the response should be 200 and it should get reject

  Scenario: Make an auth call with  empty apPaymentType
    Given the auth service is up and running
    When I hit the auth api with all valid values
    Then the response should be 200 and it should get reject

  Scenario: Make an auth call with empty preApproval Token
    Given the auth service is up and running
    When I hit the auth api with empty preApproval Token
    Then the response should be 200 and it should get reject

  Scenario: Make an auth call with  invalid preApproval Token
    Given the auth service is up and running
    When I hit the auth api with invalid preApproval Token
    Then the response should be 200 and it should get reject

  Scenario: Make an auth call with  invalid currencyCode
    Given the auth service is up and running
    When I hit the auth api with all valid values
    Then the response should be 200 and it should get reject

  Scenario: Make an auth call with  empty billTo fields
    Given the auth service is up and running
    When I hit the auth api with all valid values
    Then the response should be 200 and it should get reject

  Scenario: Make an auth call with  empty shipTo fields
    Given the auth service is up and running
    When I hit the auth api with all valid values
    Then the response should be 200 and it should get reject

  Scenario: Make a auth call with firstName value.length > 60
    Given the auth service is up and running
    When I hit the auth api with firstName value.length > 60
    Then the response should be 200 and it should get reject

  Scenario: Make a auth call with phoneNumber value.length > 15
    Given the auth service is up and running
    When I hit the auth api with phoneNumber value.length > 15
    Then the response should be 200 and it should get reject





