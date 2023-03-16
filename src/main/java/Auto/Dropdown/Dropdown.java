package Auto.Dropdown;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class Dropdown 
{
	WebDriver driver;
	
	
	@Test
	public void setup() {
		Scanner sc =new Scanner(System.in);
		 System.out.print("Enter Keyword to search:  ");
		 String inputString = sc.next();
		
		 driver = new FirefoxDriver();
		 driver.get("https://clintmcmahon.github.io/add-filter-datatable/");
		 
		 driver.findElement(By.xpath("//label[contains(text(),'Search')]/input[@type='search']")).sendKeys(inputString);
		 
		// List<String> al = new List<>();
		// al.addAll(driver.findElements(By.xpath("//tbody/tr/td[1]")).get(i));
		 
		 WebElement table = driver.findElement(By.xpath("*//tbody"));
		    List<WebElement> rows = table.findElements(By.xpath("//tbody/tr/td[1]"));
	//	    List<WebElement> column = table.findElements(By.tagName("td"));
	//	    List<String> value = new ArrayList<String>();

		    System.out.println(rows.size());
		    
		    
		    ArrayList<String> al = new ArrayList<String>();
		    for(WebElement i : rows )
		    {
		    	//System.out.println(i.getText());
		    	al.add(i.getText());
		    	
		    	String temp =i.getText().toLowerCase();
		    	boolean isFound = temp.contains(inputString);
		    	
		    	
		    	if(isFound == true) {
		    		System.out.println(i.getText()+" "+ isFound);
		    		Assert.assertEquals(true, isFound);
		    	}
		    	else {
		    		System.out.println("No matching records found.  "+isFound );
		    		Assert.assertEquals(false, isFound);
		    	}
		    		
		    
		    }	

		    
		       /* for (int j=0; j<column.size(); j++){
		        	 value.add(column.get(j).getText());
		        	 if (value.contains("on")){ 
		   			  System.out.println(rows); }
		   		  else{
		   		  System.out.println(""); }*/
		        	//  System.out.println(column.get(j).getText());
		           
		        }
		
		 
		 
	}
	
	
  

