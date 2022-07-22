package week2.day2.assignments.mandatory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {
		//name of the company to be updated
		String strNewCompany="NewCompany6";
		String strUpdatedCompanyName;
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); //verify the version, download,setup
		//launch the browser -chrome
		ChromeDriver driver=new ChromeDriver();
		//load the url
		driver.get("http://leaftaps.com/opentaps");
		//universal wait for a maximum of 30 seconds for the findelement(s) method
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//maximize the browser
		driver.manage().window().maximize();

		//Login
		driver.findElement(By.id("username")).sendKeys("demosalesmanager"); //enter the username in the username field	     
		driver.findElement(By.id("password")).sendKeys("crmsfa");  //enter the password in the password field
		driver.findElement(By.className("decorativeSubmit")).click(); //Click the login button
		WebElement logout= driver.findElement(By.className("decorativeSubmit"));  //Check if we are in the right page
		//Get the attribute and print
		String attribute=logout.getAttribute("value");
		System.out.println(attribute);
		//verify if login is successful
		if(attribute.equals("Logout")) {
			System.out.println("Successfully logged in");
		}	      
		driver.findElement(By.linkText("CRM/SFA")).click();//click CRM/SFA button

		//Edit the lead
		driver.findElement(By.linkText("Leads")).click();//CLICK THE Leads tab link
		driver.findElement(By.linkText("Find Leads")).click(); //click the find leads button
		driver.findElement(By.xpath("(//label[text()='First name:'])[3]/following::input[@name='firstName']")).sendKeys("uma"); //enter the first name
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click(); //click Find leads button
		//Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();  //click the first resulting lead

		//verify is the lead is created-page verification
		String strTitle=driver.getTitle();
		System.out.println(strTitle);
		if(strTitle.equals("View Lead | opentaps CRM")) {
			System.out.println("The lead page is opened");
			driver.findElement(By.xpath("//a[text()='Edit']")).click();  //Click the edit button
			driver.findElement(By.xpath("//span[text()='Company Name']/following::input[@name='companyName']")).clear(); //clear the company name
			driver.findElement(By.xpath("//span[text()='Company Name']/following::input[@name='companyName']")).sendKeys(strNewCompany) ; //enter new company name
			driver.findElement(By.xpath("//input[@value='Update']")).click();  //click updatebutton
			//Confirm the changed name appears
			WebElement updatedCompany = driver.findElement(By.xpath("//span[contains(text(),'NewCompany')]"));
			strUpdatedCompanyName = updatedCompany.getText();
			System.out.println(strUpdatedCompanyName);
			if(strUpdatedCompanyName.contains(strNewCompany)) {
				System.out.println("Changed company name is updated in the lead");
			}
			else {
				System.out.println("Failed!!Changed company name is not updated in the lead");
			}
		}

		else{
			System.out.println("Failed!! The lead page is not opened, cannot edit the lead");			
		}

	}

}
