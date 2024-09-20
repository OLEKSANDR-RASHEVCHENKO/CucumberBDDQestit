Feature: Validating Plase API
  Scenario: Verify isf Place is being Successful added using AddPlaceApi
    Given Add place Payload
    When user calls "AddPlaceApi" with Post http request
    Then  the API call got success with status code 200
    And  "status"  in response body is "OK"
    And  "scope" in response body is "APP"