package reflections;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainClass {

	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setUp();

		search();
		
		searchButtonClick();
		
		firstResult();
		
		browserQuit();
		
		

	}


	public static void browserQuit() {
		driver.quit();
	}


	public static void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.amazon.in/");
		
	}

	
	public static void firstResult() {
		driver.findElement(By.partialLinkText("INV12TDN")).click();
		Set<String> allhandles = driver.getWindowHandles();
		String currentwindowhandle = allhandles.iterator().next();
		allhandles.remove(allhandles.iterator().next());
		String lastHandle = allhandles.iterator().next();
		driver.switchTo().window(lastHandle);
		driver.findElement(By.id("add-to-cart-button")).click();
		}
	
	

	public static void searchButtonClick() {
		driver.findElement(By.className("nav-input")).click();
	}

	public static void search() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("inverter AC");
	}

}

