package week2.day2.assignments.mandatory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//pre-requisite -  a lead with this phone number should exist
		String strLeadID,strPhoneCountryCode,strPhoneAreaCode,strPhoneNumber;
		strPhoneCountryCode="1";
		strPhoneAreaCode="222";
		strPhoneNumber="3333";
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
		driver.findElement(By.linkText("Phone")).click();   //click the Phone tab
		driver.findElement(By.name("phoneCountryCode")).clear();
		driver.findElement(By.name("phoneCountryCode")).sendKeys(strPhoneCountryCode);//enter the phone country code
		driver.findElement(By.name("phoneAreaCode")).sendKeys(strPhoneAreaCode); //Enter area code
		driver.findElement(By.name("phoneNumber")).sendKeys(strPhoneNumber); //enter phone number

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click(); //click Find leads button
		//to avoid stale element exception add sleep
		Thread.sleep(2000);
		WebElement leadID = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)"));
		strLeadID=leadID.getText(); //capture the lead id from results - first link
		System.out.println(strLeadID);
		leadID.click(); //click the lead id link

		//verify if the lead is opened-page verification
		String strTitle=driver.getTitle();
		System.out.println(strTitle);
		if(strTitle.equals("View Lead | opentaps CRM")) {
			System.out.println("The lead page is opened");

			//Delete lead
			driver.findElement(By.xpath("//a[text()='Delete']")).click(); 	//click the delete link	
			driver.findElement(By.linkText("Find Leads")).click();// leads //go to find leads page
			//verify if deleted lead is not seen in search results
			driver.findElement(By.name("id")).sendKeys(strLeadID);  //search by lead id which is deleted
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();   //click the find leads button
			Thread.sleep(1000);
			WebElement strNoRecords=driver.findElement(By.xpath("//div[@class='x-paging-info']"));  //text at the end of the search results table
			String strMessage=strNoRecords.getText();
			boolean boolFlag=strMessage.contains("displaying");  //checking the text at the below of the table
			if(strMessage.equals("No records to display")){  //table displays no records
				System.out.println("Passed!No records are displayed for the deleted lead");
			}
			else { //table displays one or more records
				if(boolFlag=true) {
					System.out.println("Failed!lead was not deleted");
				}
			}
		}
		else {
			System.out.println("Failed!!The lead is no opened for deleting.");  //lead page is not opened - fail message
		}
	
	driver.close(); //close the browser
	}
}
