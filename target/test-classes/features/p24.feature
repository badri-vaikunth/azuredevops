Feature: P24 APM based services

  Scenario: Make a Sale call with all valid values
    Given the sale service is up and running
    When I hit the sale api with all valid values
    Then the response should be 200 and valid sale id
    And merchantURL should be generated and payment should be successful


  Scenario: Make a Sale call with empty currency
    Given the sale service is up and running
    When I hit the sale api with empty currency
    Then the response should be 200 and it should get rejected

  Scenario: Make a Sale call with invalid currency
    Given the sale service is up and running
    When I hit the sale api with invalid currency
    Then the response should be 200 and it should get rejected

  Scenario: Make a Sale call with negative amount
    Given the sale service is up and running
    When I hit the sale api with negative amount
    Then the response should be 200 and it should get reject

  Scenario: Make a Sale call with empty apPaymentType
    Given the sale service is up and running
    When I hit the sale api with empty apPaymentType
    Then the response should be 200 and it should get reject

  Scenario: Make a Sale call with  empty billTo fields
    Given the sale service is up and running
    When I hit the sale api with empty billTo fields
    Then the response should be 200 and it should get reject

  Scenario: Make a Sale call with  empty shipTo fields
    Given the sale service is up and running
    When I hit the sale api with empty shipTo fields
    Then the response should be 200 and it should get reject

  Scenario: Make a Sale call with firstName value.length > 60
    Given the sale service is up and running
    When I hit the sale api with firstName value.length > 60
    Then the response should be 200 and it should get reject

  Scenario: Make a Sale call with phoneNumber value.length > 15
    Given the sale service is up and running
    When I hit the sale api with phoneNumber value.length > 15
    Then the response should be 200 and it should get reject


  # Refund

  Scenario: Make a Refund call with all valid values
    Given the refund service is up and running
    When I hit the refund api with all valid values
    Then the response should be 200 and valid refund id

  Scenario: Make a Refund call with an empty request id
    Given the refund service is up and running
    When I hit the refund api with empty request id
    Then the response should be 200 and reject

  Scenario: Make a Refund call with an invalid request id
    Given the refund service is up and running
    When I hit the refund api with invalid request id
    Then the response should be 200 and reject

  Scenario: Make a Refund call with an duplicate request id
    Given the refund service is up and running
    When I hit the refund api with duplicate (id which is already refunded) request id
    Then the response should be 200 and reject

  Scenario: Make a Refund call with a valid request id and invalid apPaymentType
    Given the refund service is up and running
    When I hit the refund api with valid request id and invalid apPaymentType
    Then the response should be 200 and reject
