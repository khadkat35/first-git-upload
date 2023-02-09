package homework2;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework2 {
	WebDriver driver;
	
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=loging/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test
	public void depositTest() {
		
		By username_field = By.xpath("//*[@id=\'username\']");
		By password_field = By.xpath("//*[@id=\'password\']");
		By signin_field = By.xpath("/html/body/div/div/div/form/div[3]/button");
		By transactions_tab_field = By.xpath("//*[@class='fa fa-database']");
		//By new_deposit_field = By.xpath("//*[@class='nav nav-second-level collapse in']//descendant::a[text()='New Deposit']");
		By new_deposit_field = By.xpath("//ul[@class='nav nav-second-level collapse in']/child::li[1]");
		By choose_an_account_field = By.xpath("//span[@title='Choose an Account']");
		By drop_down_field = By.xpath("//li[text()='Checking555']");
		By description_field = By.xpath("//input[@id='description']");
		By amount_field = By.xpath("//input[@class='form-control amount']");
		By summit_button_field = By.xpath("//button[@id='submit']");
		
		driver.findElement(username_field).sendKeys("demo@techfios.com");
		driver.findElement(password_field).sendKeys("abc123");
		driver.findElement(signin_field).click();
		driver.findElement(transactions_tab_field).click();
		driver.findElement(new_deposit_field).click();
		driver.findElement(choose_an_account_field).click();
		driver.findElement(drop_down_field).click();
		driver.findElement(description_field).sendKeys("My Account Description");
		driver.findElement(amount_field).sendKeys("4000");
		driver.findElement(summit_button_field).click();
		
		
	}

}
