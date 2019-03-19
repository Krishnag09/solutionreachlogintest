package com.smilereminder.logintest;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageobjects.LoginPage;

public class LoginTest {
	
	static WebDriver driver;
	LoginPage loginpage;



// Some initializations before the test execution. 
    @BeforeTest
     public void setup(){
    	
   	    driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.smilereminder.com/sr/login.jsp");
    }
    
    
	@Parameters({"username","password"}) //passing username and password through testng test related parameters. 
    @Test
    public void loginTest(String username, String password) {
    	 loginpage= new LoginPage(driver); //created login page object
    	 loginpage.setUserName(username); //enter username
    	 loginpage.setPassword(password); // enter password
    	 loginpage.clickLogin(); //click on login button
    	 assertEquals(loginpage.getAlertText(),"Sign in failed!"); //check for the alert text
         }


    }
	
	

