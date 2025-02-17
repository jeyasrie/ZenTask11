package windowFrames11.ZenTask11;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Framecls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		//switch to the top frame
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));
		//check the top frame size and print the size
		int  topframe=driver.findElements(By.tagName("frame")).size();
	     System.out.println("The top frame size is "+topframe);
	     
	     //switch to the left frame
	     
	   WebElement leftframe=driver.findElement(By.cssSelector("frame[name='frame-left']"));
	   driver.switchTo().frame(leftframe);
	   //get the text from left frame
	   String lefttxt =driver.findElement(By.tagName("body")).getText();
	    System.out.println("The left frame text is  "+lefttxt);
	    //
	    //using assert check the text are matching
	     Assert.assertEquals("LEFT", lefttxt);
	     //Switch back to the parent frame(previous frame)
	     driver.switchTo().parentFrame();
	     
	     // switch to the middle frame
	     
	     WebElement middleframe=driver.findElement(By.cssSelector("frame[name='frame-middle']"));
		   driver.switchTo().frame(middleframe);
		   //get the text from middle frame
		    String middletxt =driver.findElement(By.tagName("body")).getText();
		    System.out.println("The middle frame text is  "+middletxt);
		    
		    //using assert check the text are matching
		     Assert.assertEquals("MIDDLE", middletxt);
		     //Switch back to the parent frame(previous frame)
		     driver.switchTo().parentFrame();
		     
		     //switch to right frame
		     
		     WebElement rightframe=driver.findElement(By.cssSelector("frame[name='frame-right']"));
			   driver.switchTo().frame(rightframe);
			   //get the text from right frame
			    String righttxt =driver.findElement(By.tagName("body")).getText();
			    System.out.println("The right frame text is  "+righttxt);
			    
			    //using assert check the text are matching
			     Assert.assertEquals("RIGHT", righttxt);
			     //switch back the main
			     driver.switchTo().defaultContent();
	
			 	
			//switch to the bottom frame
				
			WebElement bottomframe=driver.findElement(By.cssSelector("frame[name='frame-bottom']"));   
			driver.switchTo().frame(bottomframe);
			   //get the text from bottom frame
		    String bottomtxt =driver.findElement(By.tagName("body")).getText();
		    System.out.println("The bottom frame text is  "+bottomtxt);
		    
		    //using assert check the text are matching
		     Assert.assertEquals("BOTTOM", bottomtxt);
		     //switch back the main page
		     driver.switchTo().defaultContent(); 
	     
	}

}


//Output
//The top frame size is 3
//The left frame text is  LEFT
//The middle frame text is  MIDDLE
//The right frame text is  RIGHT
//The bottom frame text is  BOTTOM
