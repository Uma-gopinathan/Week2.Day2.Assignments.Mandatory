package week2.day2.assignments.mandatory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithImages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup(); //verify the version, download,setup
		//launch the browser -chrome
		ChromeDriver driver=new ChromeDriver();
		//load the url
		driver.get("http://leafground.com/pages/Image.html");
		//universal wait for a maximum of 30 seconds for the findelement(s) method
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//maximize the browser
		driver.manage().window().maximize();

		//1
		driver.findElement(By.xpath("//img[contains(@src,'home.png')]")).click();  //click the home image and verify
		String strURL=driver.getCurrentUrl();
		if(strURL.equals("http://leafground.com/home.html")) {
			System.out.println("passed!home page is opened on clicking the first button");
		}
		else {
			System.out.println("failed!home page is not opened on clicking the first button");
		}
		driver.navigate().back(); //go back to previous page

		//2
		WebElement brokenImage = driver.findElement(By.xpath("//label[text()='Am I Broken Image?']/following::img")); //Click the broken image
		String strHref=brokenImage.
				getAttribute("onclick");
		//System.out.println(strHref);
		if(strHref==null) {
			System.out.println("passed!It is a broken image");
		}
		else {
			System.out.println("failed!It is not a broken image");
		}

		//3
		WebElement Image = driver.findElement(By.xpath("//label[text()='Click me using Keyboard or Mouse']/following-sibling::img")); //Click image using keyboard or mouse
		Image.click();
		//Image.sendKeys(Keys.INSERT);
		//		Image.sendKeys(Keys.ENTER);
		strURL=driver.getCurrentUrl();
		if(strURL.equals("http://leafground.com/home.html")) {
			System.out.println("passed!home page is opened upon clicking the image using keyboard");
		}
		else {
			System.out.println("failed!home page is not opened upon clicking the image using keyboard");
		}
        driver.navigate().back();
		driver.close(); //close the browser
	}
}