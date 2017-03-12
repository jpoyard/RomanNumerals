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
public class RomanNumeralsSteps {
	Integer givingValue;
	String actual;
	Exception actualException;
	
	@Given("^the negative digit value -(\\d+)$")
    public void givingNegatigeDigitValue(Integer value) throws Throwable {
		givingValue = -value;  	
    }
    	
    @Given("^the digit value (\\d+)$")
    public void givingDigitValue(Integer value) throws Throwable {
    	givingValue = value; 
    }
    
    @When("^I call digitToNumeral function$")
    public void i_call_numberToRomanNumerals_function() throws Throwable {
    	RomanNumerals romanNumerals = new RomanNumerals();   	
		try{
    		actual = romanNumerals.digitToNumeral(givingValue);	    		
		} catch(UnsupportedOperationException exception){
			actualException = exception;
		}   
    }

    @Then("^it should failed$")
    public void it_should_failed() throws Throwable {
    	Assert.assertNotNull("Expected exception", actualException);
    }
    
    @Then("^the roman numeral should be \"([^\"]*)\"$")
    public void it_should_returns_values(String expected) throws Throwable {
    	Assert.assertEquals(expected, actual);
    }
    
    
}
