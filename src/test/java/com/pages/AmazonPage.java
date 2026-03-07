package com.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;
import com.base.CommonFunctions;
import com.driver.DriverFactory;
import com.report.ExtentFactory;

public class AmazonPage extends BasePage 
{

	@FindBy(name = "username")
	private WebElement userNameTextBox;

	@FindBy(name = "password")
	private WebElement passwordTExtBox;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement loginBtn;

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement serachTextBox;

	@FindBy(id = "nav-search-submit-button")
	private WebElement searchIcon;

	@FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::h2/child::span")
	private WebElement mobilesLis;

	@FindBy(xpath = "//span[@id='productTitle']")
	private WebElement mobileTitle;
	
	
	@FindBy(xpath = "//div[@id='quantityLayoutLow_feature_div']/following::div[@id='addToCart_feature_div']//child::span[@id='submit.add-to-cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath = "//span[@id='nav-cart-count']")
	private WebElement cartCount;
	
	
	String firstTabWindowID;
	
	CommonFunctions commonFunctions;

	List<WebElement> mob;

	public AmazonPage() 
	{
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
		commonFunctions = new CommonFunctions();
	}

	public void enterSearchName(String userNameValue) {

		super.sendKeys(serachTextBox, "user entered text box", userNameValue);

		super.click(searchIcon, "Search  button");

	}

	@SuppressWarnings("static-access")
	public void returnName() 
	{
		String[] str;
		// List<WebElement> mob =
		// DriverFactory.getInstance().getDriver().findElements(By.xpath("//div[@class='a-section
		// a-spacing-small
		// a-spacing-top-small']/descendant::h2/child::span[contains(text(),'Samsung')]"));
		mob = DriverFactory.getInstance().getDriver().findElements(By.xpath(
				"//div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::h2/child::span[contains(text(),'Samsung')]"));
		// List<WebElement> mob =
		// DriverFactory.getInstance().getDriver().findElements(By.xpath("//div[@class='a-section
		// a-spacing-small
		// a-spacing-top-small']/descendant::h2/child::span[contains(text(),'Samsung')]//ancestor::div[contains(@class,'a-section
		// a-spacing-none')]//following-sibling::div[@class='puisg-row
		// puis-desktop-list-row']//preceding-sibling::span[@class='a-price-symbol']/following-sibling::span"));
		for (int i = 0; i < mob.size(); i++) {
			int ia = Integer.parseInt(mob.get(i).findElement(By.xpath(
					".//ancestor::div[contains(@class,'a-section a-spacing-none')]//following-sibling::div[@class='puisg-row puis-desktop-list-row']//preceding-sibling::span[@class='a-price-symbol']/following-sibling::span"))
					.getText().replace(",", ""));

			str = mob.get(i).getText().split("\\(");
			if (ia <= 20000) {

				ExtentFactory.getInstance().passTest(str[0] + " Price of the mobile is " + ia);

				System.out.println(str[0] + " Price of the mobile is " + ia);

			}

		}
		String stra = DriverFactory.getInstance().getDriver()
				.findElement(By.xpath(
						"//div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::h2/child::span"))
				.getText();
		System.out.println(stra);
	}

	@SuppressWarnings("static-access")
	public void clickOnMobile() {
		String[] stra;

		mob = DriverFactory.getInstance().getDriver().findElements(By.xpath(
				"//div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::h2/child::span[contains(text(),'Samsung')]"));
		for (int i = 0; i < mob.size(); i++) {
			int ia = Integer.parseInt(mob.get(i).findElement(By.xpath(
					".//ancestor::div[contains(@class,'a-section a-spacing-none')]//following-sibling::div[@class='puisg-row puis-desktop-list-row']//preceding-sibling::span[@class='a-price-symbol']/following-sibling::span"))
					.getText().replace(",", ""));

			stra = mob.get(i).getText().split("\\(");
			if (ia <= 20000) {
				super.click(mob.get(i), "Click on Mobile form the List less than 20000");

				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;

			}

		}

		firstTabWindowID = DriverFactory.getInstance().getDriver().getWindowHandle();
		System.out.println("First tab window id is :" + firstTabWindowID);
		Set<String> allWindowIds = DriverFactory.getInstance().getDriver().getWindowHandles();

		for (String s : allWindowIds) 
		{
			System.out.println("tab window id is :" + s);
			if (!s.equals(firstTabWindowID)) {

				DriverFactory.getInstance().getDriver().switchTo().window(s);
				System.out.println("Window is switched to " + s);
				ExtentFactory.getInstance().passTest("Window is switched to " + s);
			}

		}

		
		/*
		 * DriverFactory.getInstance().getDriver().switchTo().window(DriverFactory.
		 * getInstance().getDriver().getWindowHandles().toArray()[1].toString());
		 * //Super.click(mobilesLis, "Mobile List");
		 */
		  String result = mobileTitle.getText().split("\\(")[0];
		  System.out.println("Mobile name is  " + result);
		  ExtentFactory.getInstance().passTest(" Mobile name is  " + result);
		  //commonFunctions.closeTab();
		  
		 // DriverFactory.getInstance().getDriver().switchTo().window(firstTabWindowID);
		 // ExtentFactory.getInstance().passTest("Window is switched parent window " + firstTabWindowID);
		  //ExtentFactory.getInstance().passTest("Window is closed " + firstTabWindowID);
		  
		 

	}

	@SuppressWarnings("static-access")
	public void verifyCart() 
	{
		super.click(addToCartBtn, "Add to Cart Button");
		
		String number = super.getElementText(cartCount, "Cart icon");
		
		ExtentFactory.getInstance().passTest("Number of item in cart is "+number);
		
		
	}
	
	
	public void closeTab() 
	{
		firstTabWindowID = DriverFactory.getInstance().getDriver().getWindowHandle();
		System.out.println("Active tab window id is :" + firstTabWindowID);
		
		commonFunctions.closeTab();
		
		//firstTabWindowID = DriverFactory.getInstance().getDriver().getWindowHandle();
		//System.out.println("Active tab window id is :" + firstTabWindowID);

		//DriverFactory.getInstance().getDriver().switchTo().window(firstTabWindowID);
	}
	

}
