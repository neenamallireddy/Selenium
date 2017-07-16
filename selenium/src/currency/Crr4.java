package currency;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Crr4 {

	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "G:\\drivers\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.x-rates.com");
		WebElement xrates_amount=driver.findElement(By.id("amount"));
		xrates_amount.clear();
		xrates_amount.sendKeys("1000");
		WebElement list=driver.findElement(By.id("to"));
		list.click();
		Thread.sleep(2000);
		list.sendKeys("INR");
		list.sendKeys(Keys.DOWN);
		list.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//span[contains(.,'Currency Calculator')]")).click();
		
		//driver.findElement(By.xpath("//span[@class='ccOutputRslt']")).click();
				
	    //Thread.sleep(2);
		//driver.quit();
		//System.out.println("Result of testCaseOne_Test_One = "+Result);
		String EResult = driver.findElement(By.xpath("//span[@class='ccOutputRslt']")).getText();
		try{
		double doubleStringAsDoubleValue = Double.parseDouble(EResult);
		System.out.println("Exchange rate from x-rates.com try = " + doubleStringAsDoubleValue);
		}
		catch(NumberFormatException ex){
			//System.out.println("not a number");
			System.out.println("Exchange rate from x-rates.com = " + EResult);
		}
	
		driver.get("http://www.xe.com/");
		WebElement erates_amount=driver.findElement(By.id("amount"));
		erates_amount.clear();
		erates_amount.sendKeys("1000");
		WebElement list2=driver.findElement(By.id("to"));
		list2.click();
		Thread.sleep(2000);
		list2.sendKeys("INR");
		list2.sendKeys(Keys.DOWN);
		list2.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//button[@id='ucc_go_btn_svg']")).click();
	
		

		
		String XResult = driver.findElement(By.xpath("//span[@class='uccResultAmount']")).getText();
		try{
		double doubleStringAsDoubleValue = Double.parseDouble(XResult);
		System.out.println("Exchange Rate from xe.com try = " + doubleStringAsDoubleValue);
		}
		catch(NumberFormatException ex){
			//System.out.println("not a number");
			System.out.println("Exchange Rate from xe.com= " + XResult);
		}
		driver.quit();
		
		if (EResult.contains(XResult))
		{
			System.out.println("rates from both are matched");
		}
		else {
			System.out.println("rates are not matched");
		}
		//assertTrue(XResult.contains(EResult));
		//System.out.println("its a match");
		
		//System.out.print("exchange rates are " +XResult + " and " +EResult);
		//Assert.assertEquals(EResult, XResult);
		
		
		
		
	
	
	}
}
