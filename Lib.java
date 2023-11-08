package doFlow;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lib {
	
	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static Select s;
	public static Alert al;
	public static Robot ro;
	public static Actions ac;
	public static WebElement data;
	//public static String capchaVal;
	
	public static void chromeBrowser() {
		
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
	}
	
	public static void launchUrl(String url) {
		
		driver.get(url);
	}
	
	public static void maxWindow() {
		
		driver.manage().window().maximize();
	}
	
	public static void quitBrowser() {
		
		driver.quit();
	}
	
	public static void pageTitle() {
		
		String pageTitle = driver.getTitle();
		System.out.println("Title of the Page is: "+pageTitle);
	}
	
	public static void printUrl() {
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println("The Current URL of the Page is: "+currentUrl);
	}
	
	public static void fillTextBox(WebElement element, String data ) {
		
		element.sendKeys(data);
	}
	
	public static void btnClick(WebElement element) {
		
		element.click();
	}
	
	public static void printText(WebElement element) {
		
		String text = element.getText();
		System.out.println("Text to Print is: "+text);
	}
	
	public static void printAttributeValue(WebElement element,String attName) {
	
		String attribute = element.getAttribute(attName);
        System.out.println("Value of the Attribute Name is: "+attribute);
	}
	
	public static void sleep(int time) throws InterruptedException {
		
		Thread.sleep(time);
	}
	
//	public static void capchaAlert() {
//		capchaVal = JOptionPane.showInputDialog("CapchaValue");
//
//	}
	
	public static void scrollDown(WebElement element) {
		
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public static void scrollUp(WebElement element) {
		
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	
	public static void jsFillTextBox(WebElement elements,String input) {
		
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+input+"')", elements);
	}
	
	public static void jsPrintText(WebElement element, String attName) {
		
		js=(JavascriptExecutor)driver;
		String attValue =(String)js.executeScript("return arguments[0].getAttribute('"+attName+"')", element);
	    System.out.println("Value of the Attribute is: "+attValue);
	}
	
	public static void jsBtnClick(WebElement elements) {
		
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", elements);
	}
	
	public static void screenShot(String imageName) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("E:\\Finezoom\\Selenium\\NewDoProject\\Screenshot\\"+imageName+".png");
		FileUtils.copyFile(temp, dest);
	}
	
	public static void selectValue(WebElement element,String value) {
		
		s=new Select(element);
		s.selectByValue(value);
	}
	
	public static void selectIndex(WebElement element,int index) {
		
		s=new Select(element);
		s.selectByIndex(index);
	}
	
	public static void selectText(WebElement element,String text) {

        s=new Select(element);
        s.selectByVisibleText(text);
	}
	
	public static void alertAccept() {
		
		al=driver.switchTo().alert();
		al.accept();
	}
	
	public static void alertDismiss() {
		
		al=driver.switchTo().alert();
		al.dismiss();
	}
	
	public static void alertInput(String data) {
		
		al=driver.switchTo().alert();
		al.sendKeys(data);
	}
	
	public static void alertGetText() {
		
		al=driver.switchTo().alert();
	    String alertText = al.getText();
	    System.out.println("Text In the Alert Box: "+alertText);
	}
	
	public static void selectAll() throws AWTException {
		ro=new Robot();
		ro.keyPress(KeyEvent.VK_CONTROL);
		ro.keyPress(KeyEvent.VK_A);
		ro.keyRelease(KeyEvent.VK_A);
		ro.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	
	public static void copyOperation() throws AWTException {
		
		ro=new Robot();
		ro.keyPress(KeyEvent.VK_CONTROL);
		ro.keyPress(KeyEvent.VK_C);
		ro.keyRelease(KeyEvent.VK_C);
		ro.keyRelease(KeyEvent.VK_CONTROL);
	}
	
    public static void cutOperation() throws AWTException {
		
		ro=new Robot();
		ro.keyPress(KeyEvent.VK_CONTROL);
		ro.keyPress(KeyEvent.VK_X);
		ro.keyRelease(KeyEvent.VK_X);
		ro.keyRelease(KeyEvent.VK_CONTROL);
	}
	
    public static void pasteOperation() throws AWTException {
		
		ro=new Robot();
		ro.keyPress(KeyEvent.VK_CONTROL);
		ro.keyPress(KeyEvent.VK_V);
		ro.keyRelease(KeyEvent.VK_V);
		ro.keyRelease(KeyEvent.VK_CONTROL);
	}
    
    public static void enterKey() throws AWTException {
		
		ro=new Robot();
		ro.keyPress(KeyEvent.VK_ENTER);
		ro.keyRelease(KeyEvent.VK_ENTER);
	}
    
    public static void tabKey() throws AWTException {
		
		ro=new Robot();
		ro.keyPress(KeyEvent.VK_TAB);
		ro.keyRelease(KeyEvent.VK_TAB);
	}
    
    public static void clear() throws AWTException {
		
		ro=new Robot();
		ro.keyPress(KeyEvent.VK_BACK_SPACE);
		ro.keyRelease(KeyEvent.VK_BACK_SPACE);
	}
    
    public static void downKey() throws AWTException {
		
		ro=new Robot();
		ro.keyPress(KeyEvent.VK_DOWN);
		ro.keyRelease(KeyEvent.VK_DOWN);
	}
    
    public static void upKey() throws AWTException {
		
		ro=new Robot();
		ro.keyPress(KeyEvent.VK_UP);
		ro.keyRelease(KeyEvent.VK_UP);
	}
    
    public static void mouseHover(WebElement element) {
    	
    	ac=new Actions(driver);
    	ac.moveToElement(element).perform();
	}
    
    public static void dragAndDrop(WebElement source,WebElement target) {
    	
    	ac=new Actions(driver);
    	ac.dragAndDrop(source, target).perform();
	}
    
    public static void clickDouble(WebElement element) {
		
    	ac=new Actions(driver);
    	ac.doubleClick(element).perform();
	}
    
    public static void rightClick(WebElement element) {
    	
    	ac=new Actions(driver);
    	ac.contextClick(element).perform();
	}
    
    public static void capsUsingShift(String data) {
    	
    	ac.keyDown(Keys.SHIFT).sendKeys(data).keyUp(Keys.SHIFT).build().perform();
	}
    
    public static void implicitWait() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
    
    
//    public static String readFromExcel(String fileName, int rowNum,int cellNum) throws IOException {
//    	
//    	File f=new File("E:\\Java Photon\\NewMavenProject\\ExcelFiles\\"+fileName+".xlsx");
//    	FileInputStream fin=new FileInputStream(f);
//    	Workbook book =new XSSFWorkbook(fin);
//    	Sheet sh=book.getSheet("Sheet1");
//    	Row r = sh.getRow(rowNum);
//    	Cell c = r.getCell(cellNum);
//    	int type = c.getCellType();
//    	String data="";
//    	
//    	if (type==1) {
//			data = c.getStringCellValue();
//		}
//    	
//    	else if (DateUtil.isCellDateFormatted(c)) {
//		    Date date = c.getDateCellValue();
//		    SimpleDateFormat sim=new SimpleDateFormat("dd/MM/yyyy");
//		    data = sim.format(date);
//		}
//    	
//    	else {
//			double d = c.getNumericCellValue();
//			long l=(long)d;
//			data= String.valueOf(l);
//		}
//    	
//    	return data;
//	}
     
    public static void writeInExcel(String fileName, int rowNum,int cellNum,String value) throws IOException {
    	
    	File f=new File("E:\\Finezoom\\Selenium\\NewDoProject\\Files\\"+fileName+".xlsx");
    	FileInputStream fin=new FileInputStream(f);
    	XSSFWorkbook book=new XSSFWorkbook(fin);
        XSSFSheet sh = book.getSheet("Sheet1");  	
	    Row r = sh.createRow(rowNum);
        Cell c = r.createCell(cellNum);
        c.setCellValue((value));
        FileOutputStream fo=new FileOutputStream(f);
        book.write(fo);  
        book.close();
    }


  
}
