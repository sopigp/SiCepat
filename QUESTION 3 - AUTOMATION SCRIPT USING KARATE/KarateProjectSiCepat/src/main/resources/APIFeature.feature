Feature: Sample API

  Background:
    * url 'https://jsonplaceholder.typicode.com'
    * headers 'application/json'
    * def expectedOutput = read("response.json")

  Scenario: API - Get Rquest
    Given path '/posts'
    When method GET
    Then status 200
    And match response == expectedOutput
    And print response
    * match each response[*].userId == '#notnull'
    * match each response[*].id == '#number'
    * match each response[*].title == '#string'
    * match each response[*].body == '#string'
