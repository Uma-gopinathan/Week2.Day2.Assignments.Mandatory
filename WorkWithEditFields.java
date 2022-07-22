package week2.day2.assignments.mandatory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithEditFields {

	public static void main (String[] args) throws Exception {
		// TODO Auto-generated method stub
		String strAppendNew="Appended new string";
		String strDefaultText;
		boolean boolEnabled;
		//boolean boolSelected;
		WebDriverManager.chromedriver().setup(); //verify the version, download,setup
		//launch the browser -chrome
		ChromeDriver driver=new ChromeDriver();
		//load the url
		driver.get("http://leafground.com/pages/Edit.html");
		//universal wait for a maximum of 30 seconds for the findelement(s) method
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//maximize the browser
		driver.manage().window().maximize();

		driver.findElement(By.id("email")).sendKeys("uma_g@gmail.com"); //enter email in the field
		WebElement appendTextField = driver.findElement(By.xpath("//input[contains(@value,'Append')]"));
		appendTextField.sendKeys(strAppendNew+Keys.TAB); //Append to existing value and press TAB
		Thread.sleep(1000);

		//Getting default string in the text field
		WebElement defaultTextField = driver.findElement(By.name("username"));
		//boolSelected=defaultTextField.isSelected();   //Check if tab key has moved the cursor to next line
		//System.out.println(boolSelected);
		System.out.print("Default text in the text field is: ");		
		strDefaultText=defaultTextField.getAttribute("value");
		System.out.println(strDefaultText);

		//clear the next field
		WebElement clearField = driver.findElement(By.xpath("(//input[@name='username'])[2]"));
		clearField.clear();
		if(clearField.getText()=="") {
			System.out.println("passed!the field is cleared");
		}
		else {
			System.out.println("failed!The field is not cleared");
		}

		//check if the next field is disabled
		WebElement objDisabled = driver.findElement(By.xpath("//label[text()='Confirm that edit field is disabled']/following::input"));
		boolEnabled=objDisabled.isEnabled();
		System.out.println("isEnabled method returns: "+boolEnabled);
		System.out.println("Printing the 'Disabled' attribute of the field: "+objDisabled.getAttribute("disabled"));
		if(boolEnabled==false) {
			System.out.println("The edit field is disabled");
		}
		else {
			System.out.println("The edit field is not disabled");
		}
		driver.close();// close the broswer
	}

}