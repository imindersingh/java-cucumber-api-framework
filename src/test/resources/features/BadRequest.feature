Feature: Bad Request Tests
  Tests covering endpoint /bad_request

  Scenario: GET request to bad_request returns 400 Bad Request
    Given "bad_request" endpoint
    When I make a GET request
    Then http response code is "200"
    Then http response text is "OK"

  Scenario: POST request to bad_request returns 400 Bad Request
    Given "bad_request" endpoint
    When I make a POST request with body "test1234"
    Then http response code is "400"
    Then http response text is "Bad Request"
    Then http response body contains the posted value