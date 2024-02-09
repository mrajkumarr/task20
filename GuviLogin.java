package task20;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GuviLogin {

	public static void main(String[] args) {
			
		//Using Edge Browser Instead of Chrome 
		WebDriver driver = new EdgeDriver();

		//Maximizing the window 
		driver.manage().window().maximize();
		
		//Navigating the URL
		driver.navigate().to("https://www.guvi.in/");
		
		//Using ImplicitlyWait for page to wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Clicking Login button
		driver.findElement(By.xpath("(//a[text()='Login'])[1]")).click();
		
		//Input for Login Page
		driver.findElement(By.id("email")).sendKeys("mrajkumarr@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Gamer619@");
		driver.findElement(By.xpath("(//a[text()='Login'])[1]")).click();

		//Using ExplicitWait for page to wait
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Wait.until(ExpectedConditions.titleContains("GUVI | courses"));
		
		//To verify the page
		String verify = driver.getTitle();
	    System.out.println("\nCurrent Page -> " +verify);
	    
        if (verify.equals("GUVI | courses")) 
        {
			System.out.println("\nGuvi Login Success");
		} 
        else 
        {
			System.out.println("\nGuvi Login Failed");
		}

        //Closing the driver
        driver.close();
	}

}
