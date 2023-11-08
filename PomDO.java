package doFlow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PomDO {
	
	public static WebElement CrnNum(WebDriver driver) {
		return driver.findElement(By.id("userName"));

	}

	public static WebElement CaptchaNum(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@class='text-height ng-untouched ng-pristine ng-valid']"));
	}

	public static WebElement NextButton(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Next']"));
		
	}

	public static WebElement PassFill(WebDriver driver) {
		return driver.findElement(By.id("credentialInputField"));
		
	}

	public static WebElement LoginButton(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Secure login']"));
		
	}
	
	public static WebElement doaUat(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='CMS DOA UAT']"));
	}
	
	public static WebElement switchFrames(WebDriver driver) {
		return (WebElement) driver.switchTo().frame("knb2ContainerFrame");

	}
	
	public static WebElement tcButton(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='I accept the ']"));

	}
	
	public static WebElement acceptButton(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='Accept ']"));

	}
	
	public static WebElement proceedButton(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='Proceed']"));

	}
	
	public static WebElement fillName(WebDriver driver) {
		return driver.findElement(By.id("mat-input-4"));

	}
	
	public static WebElement delUser(WebDriver driver) {
		return driver.findElement(By.xpath("(//mat-icon[text()='delete'])[3]"));

	}
	
	public static WebElement confirmPrompt(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='Confirm ']"));

	}
	
	
	
	public static WebElement nextClick(WebDriver driver) {
		return driver.findElement(By.xpath("(//span[text()='Next'])[1]"));

	}
	
	public static WebElement delButton(WebDriver driver) {
		return driver.findElement(By.xpath("(//mat-icon[text()='delete'])[2]"));

	}
	
	public static WebElement confirmClick(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='Confirm ']"));

	}
	
	public static WebElement nxtButton(WebDriver driver) {
		return driver.findElement(By.xpath("(//span[text()='Next'])[2]"));

	}
	
	public static WebElement submitButton(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='Submit ']"));

	}
	
	public static WebElement yesButton(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='Yes']"));

	}
	
	public static WebElement refNum(WebDriver driver) {
		return driver.findElement(By.xpath("//p[contains(text(),'DOA')]"));

	}
	
	public static WebElement viewApp(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='View application status  >']"));

	}
	public static WebElement makerStatus(WebDriver driver) {
		return driver.findElement(By.xpath("//span[contains(text(),' Pending at')]"));

	}


}
