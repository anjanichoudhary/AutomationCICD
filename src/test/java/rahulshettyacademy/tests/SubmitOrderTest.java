package rahulshettyacademy.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.CheckoutPage;
import rahulshettyacademy.pageobject.ConfirmationPage;
import rahulshettyacademy.pageobject.OrderPage;
import rahulshettyacademy.pageobject.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {
	String productName = "ZARA COAT 3";

	@Test(dataProvider="getData", groups= {"Purchage"})
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("products"));
		CartPage cartPage = productCatalogue.goTocardPage();

		Boolean match = cartPage.VerifyProductDisplay(input.get("products"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectorCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.verifyConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		//driver.findElement(By.xpath("//button[normalize-space()='Click To Download Order Details in CSV']")).click();
		//driver.findElement(By.xpath("//button[normalize-space()='Click To Download Order Details in Excel']")).click();
		// driver.close();

	}

	@Test(dependsOnMethods = {"submitOrder"})
	public void OrderHistoryTest() {
		// "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("indiafoodinvites@gmail.com", "Foodinvites.com");
		OrderPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	}
		

	//Extent Reports
	
	@DataProvider
	public Object[][] getData() throws IOException
	{	 
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//sr//test//java//rahulshettyacademy//data//PurchaseOrder.json");
		return new Object[] [] {{data.get(0)}, {data.get(1)} };
	}
	
	
	
}