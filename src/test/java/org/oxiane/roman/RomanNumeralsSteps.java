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
	Integer givingIntegerValue;
	String actualNumeral;
	
	String givingNumeralValue;
	Integer actualDigit;
	
	Exception actualException;
	

    /***
     * digit to numeral
     */
	
	@Given("^the negative digit value -(\\d+)$")
    public void givingNegatigeDigitValue(Integer value) throws Throwable {
		givingIntegerValue = -value;  	
    }
    	
    @Given("^the digit value (\\d+)$")
    public void givingDigitValue(Integer value) throws Throwable {
    	givingIntegerValue = value; 
    }
    
    @When("^I call digitToNumeral function$")
    public void i_call_numberToRomanNumerals_function() throws Throwable {
    	RomanNumerals romanNumerals = new RomanNumerals();   	
		try{
			actualNumeral = romanNumerals.digitToNumeral(givingIntegerValue);	    		
		} catch(UnsupportedOperationException exception){
			actualException = exception;
		}   
    }

    @Then("^it should failed$")
    public void it_should_failed() throws Throwable {
    	Assert.assertNotNull("Expected exception", actualException);
    }
    
    @Then("^the roman numeral should be \"([^\"]*)\"$")
    public void it_should_returns_numeral_value(String expected) throws Throwable {
    	Assert.assertEquals(expected, actualNumeral);
    }
    
    /***
     * numeral to digit
     */
    @Given("^the roman numeral value \"([^\"]*)\"$")
    public void givingNumeralValue(String numeral) throws Throwable {
    	givingNumeralValue = numeral; 
    }
    
    @When("^I call numeralToDigit function$")
    public void i_call_numeralToDigit_function() throws Throwable {
    	RomanNumerals romanNumerals = new RomanNumerals();   	
		try{
    		actualDigit = romanNumerals.numeralToDigit(givingNumeralValue);	    		
		} catch(UnsupportedOperationException exception){
			actualException = exception;
		}   
    }
    
    @Then("^the digit should be (\\d+)$")
    public void it_should_returns_digit_value(Integer expected) throws Throwable {
    	Assert.assertEquals(expected, actualDigit);
    } 
}
