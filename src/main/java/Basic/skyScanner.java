package Basic;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(invocationCount =0)
public class skyScanner {

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","path");
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.skyscanner.co.in/");
		
		driver.findElement(By.xpath("//span[text()='Create a multi-city route']")).click();
		
		driver.findElement(By.id("originInput0-input")).sendKeys("Bengaluru (BLR)");
		
		Thread.sleep(3000);
		
		WebElement destination = driver.findElement(By.id("destinationInput0-input"));
		destination.sendKeys("Mysore (MYQ)");
		
		String str = destination.getText();
		if(str.equals("Mysore (MYQ)"))
				{
			System.out.println("true");
	
				}
		else
		{
			System.out.println("False");
		}
		
		Assert.assertEquals(str.equals("Mysore (MYQ)"), true);
		
		
		driver.findElement(By.xpath("//span[text()='Add date'][1]")).click();
		
		
		driver.findElement(By.xpath("//button[contains(@aria-label,'Monday, 2 June 2025.')]")).click();
		
		
		driver.findElement(By.xpath("//input[@id='originInput1-input']")).sendKeys("Bengaluru (BLR)");
		
		
		//button[@aria-controls='children-nudger'][1]
		
		
		Select sh = new Select(driver.findElement(By.xpath("//select[@name='children-age-dropdown-0'])")));
				sh.selectByValue("6");
		
				
				driver.findElement(By.xpath("//button[text()='Apply']")).click();
				
		
		
		
		

	}

}
