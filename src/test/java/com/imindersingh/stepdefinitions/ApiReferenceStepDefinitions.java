package com.imindersingh.stepdefinitions;

import com.imindersingh.http.ApiReferenceRequests;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kong.unirest.HttpResponse;
import kong.unirest.json.JSONObject;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiReferenceStepDefinitions {

    private final ApiReferenceRequests request = new ApiReferenceRequests();
    private String endpoint;
    private HttpResponse response;
    private String requestBody;

    @Given("{string} endpoint")
    public void endpoint(final String endpoint) {
        this.endpoint = endpoint;
    }

    @When("I make a GET request")
    public void i_make_a_get_request(){
        this.response = request.get(endpoint);
    }

    @When("I make a POST request with body {string}")
    public void i_make_a_post_request_with_body(final String body){
        this.requestBody = String.format("{\"test\":\"%s\"}", body);
        this.response = request.post(endpoint, requestBody);
    }

    @Then("http response code is {string}")
    public void http_response_code_is(final String httpResponseCode){
        assertThat(response.getStatus()).isEqualTo(Integer.parseInt(httpResponseCode));
    }

    @Then("http response text is {string}")
    public void http_response_text_is(final String httpResponseText){
        assertThat(response.getStatusText()).isEqualTo(httpResponseText);
    }

    @Then("http response body contains the posted value")
    public void http_response_body_contains_the_posted_value() {
        JSONObject jsonObject = new JSONObject(response.getBody().toString());
        String responseBody = jsonObject.getJSONArray("receivedRequest").getJSONObject(0).toString();
        assertThat(responseBody).isEqualTo(requestBody);
    }
}
