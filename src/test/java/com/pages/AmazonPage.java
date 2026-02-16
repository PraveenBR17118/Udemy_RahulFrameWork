package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;
import com.driver.DriverFactory;

public class AmazonPage  extends BasePage
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
	
	
	public AmazonPage() 
	{
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}
	
	
	
	
	public void enterSearchName(String userNameValue) 
	{
		
		super.sendKeys(serachTextBox, "user entered text box", userNameValue);
		
		
		super.click(searchIcon, "Search  button");
		
	}
	
	public void returnName() 
	{
		//List<WebElement> mob = DriverFactory.getInstance().getDriver().findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::h2/child::span[contains(text(),'Samsung')]"));
		//List<WebElement> mob = DriverFactory.getInstance().getDriver().findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::h2/child::span[contains(text(),'Samsung')]"));
		List<WebElement> mob = DriverFactory.getInstance().getDriver().findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::h2/child::span[contains(text(),'Samsung')]//ancestor::div[contains(@class,'a-section a-spacing-none')]//following-sibling::div[@class='puisg-row puis-desktop-list-row']//preceding-sibling::span[@class='a-price-symbol']/following-sibling::span"));
		for(int i =0 ;i< 6;i++) 
		{
			System.out.println(mob.get(i));
		}
		String stra = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::h2/child::span")).getText();
		System.out.println(stra);
	}

}
