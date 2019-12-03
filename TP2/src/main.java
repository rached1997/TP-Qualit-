import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class main {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		driver.manage().window().maximize();

		driver.navigate().to("https://www.mytek.tn");

		TimeUnit.SECONDS.sleep(3);

		// Accessing the login page
		WebElement login = driver.findElement(By.className("login"));
		login.click();

		TimeUnit.SECONDS.sleep(3);

		// Authentication
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("passwd"));
		WebElement submit = driver.findElement(By.id("SubmitLogin"));
		email.sendKeys("TpQualite@gmail.com");
		password.sendKeys("123456");
		submit.click();

		TimeUnit.SECONDS.sleep(3);

		// Searching for product named Nikon
		WebElement search = driver.findElement(By.id("search_query_top"));
		search.sendKeys("Nikon");
		WebElement clickOnSearch = driver.findElement(By.name("submit_search"));
		clickOnSearch.click();

		TimeUnit.SECONDS.sleep(5);

		// Opening the product details
		WebElement product = driver.findElement(By.xpath("//a[contains(@title,'Objectif NIKON 18-55mm F/3.5-5.6G VR')]"));
		product.click();

		TimeUnit.SECONDS.sleep(3);

		// Purchasing the product
		WebElement buy = driver.findElement(By.name("Submit"));
		buy.click();

		TimeUnit.SECONDS.sleep(2);

		WebElement submitComand = driver.findElement(By.xpath("//a[contains(@title,'Passer la Commander')]"));
		submitComand.click();

		TimeUnit.SECONDS.sleep(2);

		WebElement startCommand = driver.findElement(By.xpath("//a[contains(@href,'https://www.mytek.tn/commande?step=1')]"));
		String link = startCommand.getAttribute("href");
		driver.navigate().to(link);

		TimeUnit.SECONDS.sleep(2);

		// Filling the adress inputs
		WebElement cin = driver.findElement(By.id("input_cin"));
		cin.sendKeys("12345678");

		WebElement adress = driver.findElement(By.id("address1"));
		adress.sendKeys("Adress rue Adress 123");

		WebElement postcode = driver.findElement(By.id("postcode"));
		postcode.sendKeys("2097");

		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys("BelleVue");

		WebElement phone = driver.findElement(By.id("phone_mobile"));
		phone.sendKeys("20121008");

		WebElement submitAdress = driver.findElement(By.name("submitAddress"));
		submitAdress.click();

		TimeUnit.SECONDS.sleep(3); 

		// Confirming the adress
		WebElement processAdress = driver.findElement(By.name("processAddress"));
		executor.executeScript("arguments[0].click()", processAdress);

		TimeUnit.SECONDS.sleep(3);

		// Confirming carrier choice
		WebElement processCarrier = driver.findElement(By.name("processCarrier"));
		executor.executeScript("arguments[0].click()", processCarrier);

		TimeUnit.SECONDS.sleep(3);

		// Confirming payment
		WebElement pay = driver.findElement(By.xpath("//a[contains(@title,'Payer comptant à la livraison')]"));
		executor.executeScript("arguments[0].click()", pay);

		TimeUnit.SECONDS.sleep(3);

		// Confirming purchase
		WebElement confirm = driver.findElement(By.xpath("//button[contains(@class,'btn-warning btn-medium')]"));
		executor.executeScript("arguments[0].click()", confirm);
		

		TimeUnit.SECONDS.sleep(6);

		driver.close();

	}

}
