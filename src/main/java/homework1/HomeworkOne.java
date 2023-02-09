package homework1;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeworkOne {
	WebDriver driver;
	// create By field xpath
	By username_field = By.xpath("//*[@id=\'username\']");
	By password_field = By.xpath("//*[@id=\'password\']");
	By signin_field = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By bank_and_cash_field = By.xpath("//span[text()='Bank & Cash']");
	By new_account_field = By.xpath("//a[text()='New Account']");
	By account_title_field = By.xpath("//*[@id=\"account\"]");
	By account_detail_field = By.xpath("//input[@id='description']");
	By initial_balance_field = By.xpath("//input[@id='balance']");
	By account_number = By.xpath("//input[@id='account_number']");
	By contact_person = By.xpath("//input[@id='contact_person']");
	By contact_phone = By.xpath("//input[@id='contact_phone']");
	By url_field = By.xpath("//input[@id='ib_url']");
	By button_field = By.xpath("//button[@class='btn btn-primary']");

	@Before
	public void init() {
		// opens a browser and go the the given site.
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=loging/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void LoginTest() {

		// pass the By field variable and values
		driver.findElement(username_field).sendKeys("demo@techfios.com");
		driver.findElement(password_field).sendKeys("abc123");
		driver.findElement(signin_field).click();
		driver.findElement(bank_and_cash_field).click();
		driver.findElement(new_account_field).click();
		driver.findElement(account_title_field).sendKeys("Checking50");
		driver.findElement(account_detail_field).sendKeys("Regular Checking Account12");
		driver.findElement(initial_balance_field).sendKeys("56000");
		driver.findElement(account_number).sendKeys("AC4356233");
		driver.findElement(contact_person).sendKeys("Khadka");
		driver.findElement(contact_phone).sendKeys("9876543210");
		driver.findElement(url_field).sendKeys("https://www.techfios.com");
		driver.findElement(button_field).click();

	}

}
