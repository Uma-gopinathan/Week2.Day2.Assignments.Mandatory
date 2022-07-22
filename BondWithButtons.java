package week2.day2.assignments.mandatory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BondWithButtons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup(); //verify the version, download,setup
		//launch the browser -chrome
		ChromeDriver driver=new ChromeDriver();
		//load the url
		driver.get("http://leafground.com/pages/Button.html");
		//universal wait for a maximum of 30 seconds for the findelement(s) method
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//maximize the browser
		driver.manage().window().maximize();
		
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='home']")).click();  //'go to home page' button  click
		String strURL=driver.getCurrentUrl();
		if(strURL.equals("http://leafground.com/home.html")) {
			System.out.println("home page is opened");
		}
		else {
			System.out.println("home page is not opened");
		}
		driver.navigate().back(); //go to previous page

		//location
		Point location = driver.findElement(By.xpath("//button[text()='Get Position']")).getLocation();
		System.out.println("The location of the field is: " +location);

		//get color
		WebElement colorElement = driver.findElement(By.xpath("//button[text()='What color am I?']"));
		System.out.println("The color of the field is:(x,y) "+colorElement.getCssValue("background-color"));

		//get size
		WebElement elementSize = driver.findElement(By.xpath("//button[text()='What is my size?']"));
		System.out.println("The size of the field is: (width,height) "+elementSize.getSize());
		driver.close(); //close the browser
	}

}
