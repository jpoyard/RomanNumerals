/**
 * 
 */
package org.oxiane.roman;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author jpoyard
 *
 */
public class AppSteps {

    private App myApp;
    private boolean success;

    @Given("^my service exists$")
    public void my_service_exists() throws Throwable {
    	myApp = new App();
    }

    @When("^I call my service$")
    public void i_call_my_service() throws Throwable {
        success = myApp.doSomething(true);
    }

    @Then("^it should have been a success$")
    public void it_should_have_been_a_success() throws Throwable {
        Assert.assertTrue(success);
    }
}
