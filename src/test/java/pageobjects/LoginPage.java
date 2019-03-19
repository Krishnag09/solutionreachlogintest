package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
    public static WebDriver driver;
    

	public LoginPage(WebDriver driver){

    	LoginPage.driver = driver;

    }

    //Set user name

    public void setUserName(String strUserName){
        WebElement username = driver.findElement(By.id("okta-signin-username"));
        username.sendKeys(strUserName);

    }

    //Set password 

    public void setPassword(String strPassword){
        WebElement password = driver.findElement(By.id("okta-signin-password"));
    	password.sendKeys(strPassword);

    }

    //Click on login button

    public void clickLogin(){
        WebElement loginbutton = driver.findElement(By.id("okta-signin-submit"));
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
    	executor.executeScript("arguments[0].click();", loginbutton);

    }

    //Get the url of the landing Page after login attempt to verify successful login
    
    
    public String getAlertText(){
    	
        WebElement loginalert = driver.findElement(By.className("okta-form-infobox-error"));
        return loginalert.getText().toString();

    }

    public void login(String strUserName,String strPasword){


        this.setUserName(strUserName);
        this.setPassword(strPasword);

        this.clickLogin();        
    }

}
