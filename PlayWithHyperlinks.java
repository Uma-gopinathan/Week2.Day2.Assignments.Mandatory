package week2.day2.assignments.mandatory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PlayWithHyperlinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); //verify the version, download,setup
		//launch the browser -chrome
		ChromeDriver driver=new ChromeDriver();
		//load the url
		driver.get("http://leafground.com/pages/Link.html");
		//universal wait for a maximum of 30 seconds for the findelement(s) method
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//maximize the browser
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[1]")).click();//Go to home page & verify
		String strURL=driver.getCurrentUrl();
		if(strURL.equals("http://leafground.com/home.html")) {
			System.out.println("home page is opened");
		}
		else {
			System.out.println("home page is not opened");
		}
		driver.navigate().back(); //go back to previous page
		
		//Where the link navigates without clicking
		WebElement elementLink=driver.findElement(By.xpath("//a[text()='Find where am supposed to go without clicking me?']"));
		String StringURL=elementLink.getAttribute("href");
		System.out.println("The link will navigate to: " + StringURL + " on clicking");
		
		//verify if the link is a broken link
		driver.findElement(By.xpath("//a[text()='Verify am I broken?']")).click();
		strURL=driver.getCurrentUrl();
		if(strURL.equals("http://leafground.com/pages/error.html")) {
			System.out.println("The link is broken");
		}
		else {
			System.out.println("The link is not broken");
		}
		driver.navigate().back(); //go back to previous page
		
		//interact with the same link name - Go to home
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]")).click();//click the 2nd link with the same text
		strURL=driver.getCurrentUrl();
		if(strURL.equals("http://leafground.com/home.html")) {
			System.out.println("home page is opened by interacting with the same link name");
		}
		else {
			System.out.println("home page is not opened by interacting with the same link name");
		}
		driver.navigate().back(); //go back to previous page
		
		driver.close(); //close the browser
	}

}
