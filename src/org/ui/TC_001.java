package org.ui;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC_001 {

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
	
	WebElement DescriptionTxt = driver.findElement(By.name("description[]"));
	DescriptionTxt.sendKeys("More Coffee..!");
	
	WebElement SourceAccount = driver.findElement(By.xpath("//input[@placeholder='Source account']"));
	SourceAccount.sendKeys("The house");
	Select s=new Select(SourceAccount);
	
	s.selectByValue("The house");
	
	WebElement DestinationAccount = driver.findElement(By.xpath("//input[@placeholder='Destination account']"));
	DestinationAccount.sendKeys("Cash wallet");
	Select desAcc=new Select(DestinationAccount);
	
	desAcc.selectByVisibleText("Cash wallet");
	
	WebElement Amount = driver.findElement(By.xpath("//input[@placeholder='Amount']"));
	Amount.sendKeys("1000");
	
	WebElement formSubmit = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
	formSubmit.click();
	}
}
