package week2.day2.assignments.mandatory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToyWithTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); //verify the version, download,setup
		//launch the browser -chrome
		ChromeDriver driver=new ChromeDriver();
		//load the url
		driver.get("http://www.leafground.com/pages/table.html");
		//universal wait for a maximum of 30 seconds for the findelement(s) method
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//maximize the browser
		driver.manage().window().maximize();

		//count of number of columns
		WebElement objTableBody=driver.findElement(By.xpath("//table/tbody"));
		List<WebElement> elements = objTableBody.findElement(By.tagName("tr")).findElements(By.tagName("th"));
		System.out.println("The number of columns(header) is: " +elements.size());

		//get the number of rows
		WebElement objTable=driver.findElement(By.xpath("//table"));
		List<WebElement> elements2 = objTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
		System.out.println("The number of rows is: " + elements2.size());

		//Progress value of learn to interact with elements
		WebElement objProgressCell=driver.findElement(By.xpath("//td/font[contains(text(),'Learn to interact with')][1]/following::td[1]"));
		System.out.println("The progress value of Learn to interact with Elements is: " + objProgressCell.getText());

		//Check the vital task for the least completed progress
		List<WebElement> elements3 = driver.findElements(By.xpath("(//td/font[contains(text(),'Learn to interact with')][1]/following::td[1])"));
		int intNoOfProgressValueRows = elements3.size();
		int[] intProgressValueArray=new int[3];
		String strText,strText2;
		int intProgressValue;
		//elements3.sort();
		for(int i=0;i<intNoOfProgressValueRows;i++) {				
			strText=elements3.get(i).getText();
			strText= strText.replace("%", "");
			intProgressValueArray[i]=Integer.parseInt(strText);			
		}
		Arrays.sort(intProgressValueArray);   //sort the progress value
		//iterate through the progress value array to find the webelement which has the least progress value and click checkbox next to it
		for(int j=0;j<intNoOfProgressValueRows;j++) {
			WebElement leastCompletedProgressTD = elements3.get(j); //td tag webelement
			strText2=elements3.get(j).getText();
			strText2= strText2.replace("%", "");  //replace % symbol in the progress value for integer conversion
			intProgressValue=Integer.parseInt(strText2);  //convert the progress value to integer
			if(intProgressValueArray[0]==intProgressValue) {  //check the sorted progress value array element 0 against the table value
				leastCompletedProgressTD.findElement(By.xpath("following::td[1]/input")).click(); //click the checkbox next to the least progress value in the list
			}
		}

	}

}
