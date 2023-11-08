package doFlow;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class MultiUser {
	static Lib l=new Lib();
	@Test (priority=1)
		private static void maker() throws InterruptedException, AWTException, IOException {
		System.setProperty("Webdriver.chrome.driver", "E:\\Finezoom\\Selenium\\Selenium\\Driver");
		WebDriver driver=new ChromeDriver();
		driver.get("https://nbuat.kotak.com/knb2/");
		driver.manage().window().maximize();
		WebElement crnNum=driver.findElement(By.id("userName"));
		crnNum.sendKeys("10671509");
		WebElement captchaNum=driver.findElement(By.xpath("//input[@class='text-height ng-untouched ng-pristine ng-valid']"));
		captchaNum.click();
		Thread.sleep(10000);
		WebElement nextButton=driver.findElement(By.xpath("//button[text()='Next']"));
		nextButton.click();
		Thread.sleep(2000);
		WebElement passFill=driver.findElement(By.id("credentialInputField"));
		passFill.sendKeys("Quality123");
		WebElement loginButton=driver.findElement(By.xpath("//button[text()='Secure login']"));
		loginButton.click();
		Thread.sleep(2000);
		WebElement doaButton=driver.findElement(By.xpath("//span[text()='CMS DOA UAT']"));
		doaButton.click();
		Thread.sleep(5000);
		driver.switchTo().frame("knb2ContainerFrame");	
		WebElement scroll=driver.findElement(By.xpath("//span[@class='mat-checkbox-frame']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		WebElement tcButton=driver.findElement(By.xpath("//span[text()='I accept the ']"));
		tcButton.click();
		Thread.sleep(2000);
		WebElement acceptButton=driver.findElement(By.xpath("//span[text()='Accept ']"));
		acceptButton.click();
		Thread.sleep(1000);
		WebElement proceedButton=driver.findElement(By.xpath("//span[text()='Proceed']"));
		proceedButton.click();
		Thread.sleep(5000);
		WebElement nameFill=driver.findElement(By.id("mat-input-4"));
		nameFill.sendKeys("Prakash");
		WebElement nextClick=driver.findElement(By.xpath("(//span[text()='Next'])[1]"));
		nextClick.click();
		Thread.sleep(10000);
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		WebElement delButton=driver.findElement(By.xpath("(//mat-icon[text()='delete'])[2]"));
		delButton.click();
		WebElement confirmClick=driver.findElement(By.xpath("//span[text()='Confirm ']"));
		confirmClick.click();
		Thread.sleep(1000);
		WebElement nxtButton=driver.findElement(By.xpath("(//span[text()='Next'])[2]"));
		nxtButton.click();
		Thread.sleep(5000);
		WebElement submitButton=driver.findElement(By.xpath("//span[text()='Submit ']"));
		submitButton.click();
		Thread.sleep(5000);
		WebElement yesButton=driver.findElement(By.xpath("//span[text()='Yes']"));
		yesButton.click();
		Thread.sleep(5000);
		TakesScreenshot tk=(TakesScreenshot)driver;
		File temp = tk.getScreenshotAs(OutputType.FILE);
		Thread.sleep(3000);
		File dest = new File("E:\\Finezoom\\Selenium\\NewDoProject\\Screenshot\\transactionPage.png");	
		FileUtils.copyFile(temp, dest);
		WebElement refNum=driver.findElement(By.xpath("//p[contains(text(),'DOA')]"));
		String doaNum = refNum.getText();
		System.out.println(doaNum);
		l.writeInExcel("DOANum", 1, 0, doaNum);
		WebElement viewAppl=driver.findElement(By.xpath("//span[text()='View application status  >']"));
		viewAppl.click();
		Thread.sleep(5000);
		WebElement makerStatus=driver.findElement(By.xpath("//span[contains(text(),' Pending at')]"));
		String applStatus = makerStatus.getText();
		System.out.println(applStatus);
		l.writeInExcel("DOANum", 2, 1, applStatus);
		driver.quit();
		
		}

	@Test (priority=2)
	private static void checker() throws InterruptedException, IOException {
	System.setProperty("Webdriver.chrome.driver", "E:\\Finezoom\\Selenium\\Selenium\\Driver");
	WebDriver driver=new ChromeDriver();
	driver.get("https://nbuat.kotak.com/knb2/");
	driver.manage().window().maximize();
	WebElement crnNum=driver.findElement(By.id("userName"));
	crnNum.sendKeys("14213677");
	WebElement captchaNum=driver.findElement(By.xpath("//input[@class='text-height ng-untouched ng-pristine ng-valid']"));
	captchaNum.click();
	Thread.sleep(10000);
	WebElement nextButton=driver.findElement(By.xpath("//button[text()='Next']"));
	nextButton.click();
	Thread.sleep(2000);
	WebElement passFill=driver.findElement(By.id("credentialInputField"));
	passFill.sendKeys("Quality123");
	WebElement loginButton=driver.findElement(By.xpath("//button[text()='Secure login']"));
	loginButton.click();
	Thread.sleep(2000);
	WebElement doaButton=driver.findElement(By.xpath("//span[text()='CMS DOA UAT']"));
	doaButton.click();
	Thread.sleep(5000);
	driver.switchTo().frame("knb2ContainerFrame");
	WebElement pendingTab=driver.findElement(By.id("mat-tab-label-0-2"));
	pendingTab.click();
	Thread.sleep(2000);
	WebElement processButton=driver.findElement(By.xpath("//span[text()='Process']"));
	processButton.click();
	Thread.sleep(2000);
	WebElement processButton1=driver.findElement(By.xpath("//span[text()='Process']"));
	processButton1.click();
	Thread.sleep(5000);
	WebElement pendingTab1=driver.findElement(By.xpath("//mat-icon[text()='refresh']"));
	pendingTab1.click();
	Thread.sleep(5000);
	WebElement checkerStatus=driver.findElement(By.xpath("//span[contains(text(),' Pending at')]"));
	String applStatus1 = checkerStatus.getText();
	System.out.println(applStatus1);
	l.writeInExcel("DOANum", 3, 2, applStatus1);
	driver.quit();
	}
}