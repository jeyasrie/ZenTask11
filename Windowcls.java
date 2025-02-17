package windowFrames11.ZenTask11;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowcls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		////initialize the driver
		WebDriver driver=new ChromeDriver();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//open the website
		driver.get("https://the-internet.herokuapp.com/windows");
		//maximize the website
		driver.manage().window().maximize();
		// retrieves the handle of the currently active window.
		String ParentWindow= driver.getWindowHandle();
		System.out.println("Parent window "+ ParentWindow);
		
		//open a new child window
		driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
		//using set get the all windows
		Set <String> WindowHandles=driver.getWindowHandles();
		System.out.println("All window "+ WindowHandles);
		//check the parent window is not equal to child window
	  for(String child : WindowHandles) {
		  if(!child.equals(ParentWindow)) {
			  driver.switchTo().window(child);
			  System.out.println("The child window url "+driver.getCurrentUrl());
		  }
	  
		
	  }
	  //get the text and checking the child window opened or not
	  String msg=	driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
	  Assert.assertEquals("New Window",msg);
	  if(msg.equals("New Window")) {
		System.out.println("successfully opened new window");
	  }
	   else
	   {
		System.out.println("The window not opened");
	 }
	
	   //close the current window
	    driver.close();	
	   //check parent window active or not after closing child window
	    driver.switchTo().window(ParentWindow);
	    //get the text from parent window
	     String maintxt=driver.findElement(By.xpath("//div/h3")).getText();
             if(maintxt.equals("Opening a new window")) {
	     System.out.println("The parent window is active");
         }
          else
        {
	        System.out.println("The parent window is not visible");
         }
	      driver.quit();
	}

}

//Output
//Parent window 300EDFBF7F31B7F10187FD60235C9CCA
//All window [300EDFBF7F31B7F10187FD60235C9CCA, 100D1FBB30AFA8BDFF54B09A294DF132]
//The child window url https://the-internet.herokuapp.com/windows/new
//successfully opened new window
//The parent window is active
