package org.ui;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_005 {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\AJITH\\eclipse-workspace\\ui_test\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.firefly-iii.org/login");

		driver.manage().window().maximize();

		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("demo@firefly-iii.org");

		WebElement pswd = driver.findElement(By.id("password"));
		pswd.sendKeys("demo");

		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();

		WebElement Transaction = driver.findElement(By.xpath("//span[text()='transaction']"));
		Transaction.click();
		
		WebElement Expenses = driver.findElement(By.xpath("//a[contains(@href,'https://demo.firefly-iii.org/transactions/withdrawal')]"));
		Expenses.click();
		
		WebElement NewTransaction = driver.findElement(By.xpath("//a[contains(@class,'btn-success')]"));
		NewTransaction.click();
		
		WebElement formSubmit = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		formSubmit.click();
		
		List<String> expectedMessages = Arrays.asList(
			    "Please select or type a valid source account name",
			    "Please select or type a valid destination account name",
			    "The transaction amount field is required."
			);

			List<WebElement> actualMessages = driver.findElements(By.xpath("//li[@class='text-danger']"));

			for (int i = 0; i < expectedMessages.size(); i++) {

			    String actual = actualMessages.get(i).getText();
			    String expected = expectedMessages.get(i);

			    System.out.println("Actual: " + actual);
			    Assert.assertEquals(actual, expected);
		}
	}
}
