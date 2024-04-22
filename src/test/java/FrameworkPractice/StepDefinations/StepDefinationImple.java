package FrameworkPractice.StepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import FrameworkPractice.TestComponents.BaseTest;
import FrameworkPractice.pageobjects.CartPage;
import FrameworkPractice.pageobjects.CheckOutPage;
import FrameworkPractice.pageobjects.ConfirmationPage;
import FrameworkPractice.pageobjects.LandingPage;
import FrameworkPractice.pageobjects.ProductCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationImple extends BaseTest{
	
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException{
		
		landingPage = lunchApplication();
		
	}
	
	//<.+> is used to pass the data of any integer, string or anything.
	//To use regular expression start with using ^ and end with $.
	
	@Given("^I logged in with username (.+) and password (.+)$")//its a form of regex.
	public void I_logged_in_with_username_and_password(String username, String password) {
		
		 productCatalogue = landingPage.loginApplication(username, password);

	}
	
	@When("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String productName) {
		
		List<WebElement> products= productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}
	
	@And("^checkout (.+) and submit the order$")
	public void  checkout_submit_order(String productName) {	
		
		CartPage cartPage = productCatalogue.goToCartPage();
		boolean match = cartPage.verifyProductCartPage(productName);
		Assert.assertTrue(match);
		CheckOutPage checkOutPage =cartPage.goToCheckOutPage();
		checkOutPage.selectCountry("india");
		confirmationPage =checkOutPage.placeOrder();
		System.out.println(confirmationPage.getTousterMessagePrint());
		
	}
	
	@Then("{string} message is displayed on confirmationPage")
	public void message_displayed_confirmationPage(String string) {
		
		String confirmation = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmation.equalsIgnoreCase(string));

	}
	
	@Then("{string} Message is displayed")
	public void Message_is_displayed(String string) {
		
		Assert.assertEquals(string, landingPage.getErrorValidations());
		driver.close();
	
	}
// tidy gherkin is a plugin extension attach with the chrome which give step definitions code.	

}
