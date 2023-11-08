package doFlow;
import java.awt.AWTException;
import java.io.IOException;
public class SingleUser extends Lib{
	static Lib l=new Lib();
	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		
		chromeBrowser();
		launchUrl("https://nbuat.kotak.com/knb2/");
		maxWindow();
		PomDO.CrnNum(driver).sendKeys("11534363");
		PomDO.CaptchaNum(driver).click();
		sleep(10000);
		PomDO.NextButton(driver).click();
		sleep(2000);
		PomDO.PassFill(driver).sendKeys("Quality123");
		PomDO.LoginButton(driver).click();
		sleep(2000);
		PomDO.doaUat(driver).click();
		sleep(5000);
		driver.switchTo().frame("knb2ContainerFrame");
		PomDO.tcButton(driver).click();
		sleep(2000);
		PomDO.acceptButton(driver).click();
		sleep(1000);
		PomDO.proceedButton(driver).click();
		sleep(5000);
		PomDO.fillName(driver).sendKeys("Prakash");
		PomDO.nextClick(driver).click();
		sleep(10000);
		tabKey();
		enterKey();
		downKey();
		enterKey();
		for (int i = 0; i <=10; i++) {
			PomDO.delUser(driver).click();
			PomDO.confirmPrompt(driver).click();
			sleep(1000);
		}
		PomDO.nxtButton(driver).click();
		sleep(5000);
		PomDO.submitButton(driver).click();
		sleep(5000);
		PomDO.yesButton(driver).click();
		sleep(5000);
		screenShot("TransactionSingle");
		String doaNum = PomDO.refNum(driver).getText();
		System.out.println(doaNum);
		writeInExcel("DOAdetails", 1, 0, doaNum);
		PomDO.viewApp(driver).click();
		sleep(5000);
		String applStatus = PomDO.makerStatus(driver).getText();
		System.out.println(applStatus);
		writeInExcel("DOAdetails", 2, 1, applStatus);
		driver.quit();
	}

}
