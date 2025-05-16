package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;
	
	// PageFactory

	@FindBy(css = ".totalRow button")
	WebElement checkOutEle;
	
	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartProduct;

	public CartPage(WebDriver driver) {
		// Initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean VerifyProductDisplay(String prductName)
	{
		Boolean match = cartProduct.stream().anyMatch(Product -> Product.getText().equalsIgnoreCase(prductName));
		return match;
	}
	
	public CheckoutPage goToCheckout()
	{
		checkOutEle.click();
		return new CheckoutPage(driver);
	}

}
