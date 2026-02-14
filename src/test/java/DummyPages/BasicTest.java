package DummyPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicTest 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.out.println("main");
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://www.amazon.in/");
		
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("mobiles");
		driver.findElement(By.id("nav-search-submit-button")).click();
	
//		List<WebElement> ele = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::h2/child::span"));
//		
//		System.out.println(ele.size());
//		
//		for(WebElement elsd : ele) 
//		{
//			String strgb = elsd.getText();
//			System.out.println(strgb);
//		}
		
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='a-section']/descendant::span[@class='a-price-whole']"));
		for(WebElement eledfg : price) 
		{
			String strgb = eledfg.getText();
			System.out.println(strgb);
		}
		System.out.println("+_+_+_+_+_+_+_+_+_+_+_+_");
		List<WebElement> nameA =  driver.findElements(By.xpath("//div[@class='a-section']/descendant::span[@class='a-price-whole']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::h2"));
		for(int k =0;k<price.size();k++) 
		{
			
			String PriceValue = price.get(k).getText();
			String getExactValue = "";
			for(char cgb :PriceValue.toCharArray() ) 
			{
				if(Character.isDigit(cgb)) 
				{
					getExactValue =getExactValue+cgb;
				}
			}
			int ia = Integer.parseInt(getExactValue);
			//System.out.println("Integer value is : "+ia);
			//int ba = Integer.valueOf( price.get(k).getText());
			if(ia<10000) 
			{
				String outAS = nameA.get(k).getText();
				String [] phName =  outAS.split(" ");
				System.out.println("Price less than 10K phones are : "+phName[0]+" "+phName[1]);
			}
		}
//		List<WebElement> name =  driver.findElements(By.xpath("//div[@class='a-section']/descendant::span[@class='a-price-whole']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::h2"));
//		for(int i =0 ;i<name.size();i++ ) 
//		{
//			String trf = name.get(i).getText();
//			System.out.println(trf);
//			
//		}
		
		/*
		 * String stra = driver.findElement(By.
		 * xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::h2/child::span"
		 * )).getText(); System.out.println(stra); Thread.sleep(3000);
		 */
		driver.quit();
		


		
	}

}
