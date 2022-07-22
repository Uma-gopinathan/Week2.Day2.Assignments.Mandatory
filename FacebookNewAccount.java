package week2.day2.assignments.mandatory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookNewAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); //verify the version, download,setup
		//launch the browser -chrome
		ChromeDriver driver=new ChromeDriver();
		//load the url
		driver.get("https://en-gb.facebook.com/");
		//universal wait for a maximum of 30 seconds for the findelement(s) method
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//maximize the browser
		driver.manage().window().maximize();

		//singup a new user
		driver.findElement(By.xpath("//a[contains(text(),'Create New Account')]")).click() ; //click create new button
		driver.findElement(By.name("firstname")).sendKeys("uma");  //enter first name
		driver.findElement(By.name("lastname")).sendKeys("G");  //enter last name
		driver.findElement(By.xpath("(//input[contains(@name,'email')])[2]")).sendKeys("9988776655");//enter email id
		//driver.findElement(By.name("reg_email__")).sendKeys("9988776655");//enter email id
		//driver.findElement(By.name("reg_email_confirmation__")).sendKeys("9988776655");//enter email id
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("tester$1234"); //enter password

		//select the date of birth from dropdown
		WebElement source = driver.findElement(By.id("day")); //day dropdown1
		Select selectDay=new Select(source);	      
		selectDay.selectByValue("3");

		WebElement source2 = driver.findElement(By.id("month")); //month dropdown2
		Select selectMonth=new Select(source2);	      
		selectMonth.selectByValue("6");

		WebElement source3 = driver.findElement(By.id("year")); //year dropdown3
		Select selectYear=new Select(source3);	      
		selectYear.selectByValue("1987");	      

		driver.findElement(By.xpath("//input[@value='1']")).click();  //selecting gender

	}
}