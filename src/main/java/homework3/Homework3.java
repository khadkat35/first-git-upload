package homework3;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class Homework3 {
	WebDriver driver;
	By username_field = By.xpath("//*[@id=\'username\']");
	By password_field = By.xpath("//*[@id=\'password\']");
	By signin_field = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By dashboard_hearder_field = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
	By CUSTOMERS_FIELD = By.xpath("//span[text()='Customers']");
	By ADD_CUSTOMER_FIELD = By.xpath("//a[text()='Add Customer']");
	By addcontactheader_field = By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5");
	By FULLNAME_FIELD = By.xpath("//input[@id='account']");
	By company_drop_field = By.xpath("//select[@id='cid']");
	By EMAIL_FIELD = By.xpath("//input[@id='email']");
	By PHONE_NUMBER_FIELD = By.xpath("//input[@id='phone']");
	By ADDRESS_FIELD = By.xpath("//input[@id='address']");
	By CITY_FIELD = By.xpath("//input[@id='city']");
	By STATE_REGION_FIELD = By.xpath("//input[@id='state']");
	By ZIPCODE_FIELD = By.xpath("//input[@id='zip']");
	By COUNTRY_DROPDOWN_FIELD = By.xpath("//select[@id='country']");
	By SUBMIT_BUTTON_FIELD = By.xpath("//button[@id='submit']");

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
	public void logingTest() {

		// loging into to techfios ibilling page and getting to the
		driver.findElement(username_field).sendKeys("demo@techfios.com");
		driver.findElement(password_field).sendKeys("abc123");
		driver.findElement(signin_field).click();
		driver.findElement(CUSTOMERS_FIELD).click();
		driver.findElement(ADD_CUSTOMER_FIELD).click();

		// assert web element
		WebElement dashboardheaderElement = driver.findElement(dashboard_hearder_field);
		Assert.assertTrue("Contacts", dashboardheaderElement.isDisplayed());

		// passing fullname
		driver.findElement(FULLNAME_FIELD).sendKeys("Gautam Buddha");

		// company drop down
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addcontactheader_field));
		Select sel = new Select(driver.findElement(company_drop_field));
		sel.selectByVisibleText("Techfios");

		// passing other required variables
		driver.findElement(EMAIL_FIELD).sendKeys("techfios991@techfios.com");
		driver.findElement(PHONE_NUMBER_FIELD).sendKeys("0987654323");
		driver.findElement(ADDRESS_FIELD).sendKeys("123 techfios drive");
		driver.findElement(CITY_FIELD).sendKeys("Charlston");
		driver.findElement(STATE_REGION_FIELD).sendKeys("SC");
		driver.findElement(ZIPCODE_FIELD).sendKeys("90901");

		// country drop down
		Select sel1 = new Select(driver.findElement(COUNTRY_DROPDOWN_FIELD));
		sel1.selectByVisibleText("Nepal");
		driver.findElement(SUBMIT_BUTTON_FIELD).click();

	}

}
