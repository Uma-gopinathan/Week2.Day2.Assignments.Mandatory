package week2.day2.assignments.mandatory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithCheckboxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strValue;
		WebDriverManager.chromedriver().setup(); //verify the version, download,setup
		//launch the browser -chrome
		ChromeDriver driver=new ChromeDriver();
		//load the url
		driver.get("http://leafground.com/pages/checkbox.html");
		//universal wait for a maximum of 30 seconds for the findelement(s) method
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//maximize the browser
		driver.manage().window().maximize();

		//Select the language you know
		System.out.println(driver.findElement(By.xpath("//div[@id='contentblock']/section/div[1]/label")).getText());
		WebElement selectAllCheckBox2=driver.findElement(By.xpath("//div[@id='contentblock']/section/div[1]"));
		String strText2=selectAllCheckBox2.getText();
		String strText3=strText2.replace("Select the languages that you know?", "");
		String strText4=strText3.trim();
		String[] strLanguages=strText4.split(" ");
		System.out.println(strLanguages[0]);
		System.out.println(strLanguages[1]);
		driver.findElement(By.xpath("//div[@id='contentblock']/section/div[1]/input[1]")).click(); //java
		System.out.println("The language: "+strLanguages[0]+ " was checked");
		driver.findElement(By.xpath("//div[@id='contentblock']/section/div[1]/input[3]")).click();  //sql
		System.out.println("The language: "+strLanguages[2]+ " was checked");

		//Check if Selenium is selected
		System.out.println(driver.findElement(By.xpath("//div[@id='contentblock']/section/div[2]/label")).getText());
		WebElement checkBoxSelenium = driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following::input"));
		strValue=checkBoxSelenium.getAttribute("value");
		if(strValue.equals("on")){
			System.out.println("The Selenium checkbox is checked");
		}
		else {
			System.out.println("The Selenium checkbox is not checked");
		}
		
		//Deselect the checkbox which is checked
		System.out.println(driver.findElement(By.xpath("//div[@id='contentblock']/section/div[3]/label")).getText());
		WebElement deselectCheckBox = driver.findElement(By.xpath("//label[text()='DeSelect only checked']/following::input[1]"));
		//WebElement obj1=driver.findElement(By.xpath("//div[@id='contentblock']/section/div[3]"));
		//System.out.println(obj1.getAttribute("text"));
		//System.out.println(obj1.getText()); //retieves the text next to all checkboxes
		
		if(deselectCheckBox.isSelected()==true) {  //checking if first checkbox is selected
			deselectCheckBox.click();
			System.out.println("The check box:1 was unchecked");
		}
		else {
			System.out.println("The check box:1 was not unchecked as it was not selected");
		}
		
		WebElement deselectCheckBox2 = driver.findElement(By.xpath("//div[@id='contentblock']/section/div[3]/input[2]"));		
		if(deselectCheckBox2.isSelected()==true) {//Checking the 2nd checkbox
			deselectCheckBox2.click();
			System.out.println("The check box:2 was unchecked");
		}
		else {
			System.out.println("The check box:2 was not unchecked as it was not selected");
		}
		
		//Select all below checkboxes
		System.out.println(driver.findElement(By.xpath("//div[@id='contentblock']/section/div[4]/label")).getText());
		WebElement selectAllCheckBox = driver.findElement(By.xpath("//div[@id='contentblock']/section/div[4]"));
		String strText=selectAllCheckBox.getText();
		//System.out.println(strText); //prints the text next to each checkbox one after another
		char[] charArray=strText.toCharArray();
		int length=charArray.length;
		int checkBoxCount=Character.getNumericValue(charArray[length-1]);
		//System.out.println(checkBoxCount);
		for(int i=1;i<=checkBoxCount;i++){
			String strInputCheckBoxName="input"+"["+i+"]";
			driver.findElement(By.xpath("//div[@id='contentblock']/section/div[4]/" +strInputCheckBoxName)).click();
			System.out.println("The checkbox: "+i +" was clicked.");
			
		}
		//driver.close(); //close the browser
		}
	}



