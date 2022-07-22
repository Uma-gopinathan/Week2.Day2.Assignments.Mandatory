package week2.day2.assignments.mandatory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnListBoxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); //verify the version, download,setup
		//launch the browser -chrome
		ChromeDriver driver=new ChromeDriver();
		//load the url
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		//universal wait for a maximum of 30 seconds for the findelement(s) method
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//maximize the browser
		driver.manage().window().maximize();
		
		//select by Index
		WebElement dropDown1 = driver.findElement(By.id("dropdown1"));
		Select selectDropDown1 = new Select(dropDown1);
		selectDropDown1.selectByIndex(1); //select by index 1
		
		//select by text
		WebElement dropDown2 = driver.findElement(By.name("dropdown2"));
		Select selectDropDown2 = new Select(dropDown2);
		selectDropDown2.selectByVisibleText("Appium");
		
		//Select by value
		WebElement dropDown3 = driver.findElement(By.id("dropdown3"));
		Select selectDropDown3 = new Select(dropDown3);
		selectDropDown3.selectByValue("3");
		
		//Select using sendkeys
		WebElement dropDown4 = driver.findElement(By.xpath("//option[text()='You can also use sendKeys to select']/.."));
		dropDown4.sendKeys("Loadrunner");			 
		
	    //number of dropdown options
		WebElement dropDown5 =driver.findElement(By.xpath("//option[text()='Get the number of dropdown options']/.."));
		Select selectDropDown5 = new Select(dropDown5);
		List<WebElement> options = selectDropDown5.getOptions();		
		System.out.println("The number of dropdown options: "+options.size());		
		
		//Select multiple options
		WebElement dropDown6 = driver.findElement(By.xpath("//option[text()='Select your programs']/.."));
		Select selectDropDown6 = new Select(dropDown6);
		selectDropDown6.selectByVisibleText("Selenium");
		selectDropDown6.selectByVisibleText("Appium");
		selectDropDown6.selectByVisibleText("UFT/QTP");
		
		driver.close();	
		

	}

}
