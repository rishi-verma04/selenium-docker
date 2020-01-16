package com.newstours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightConfirmationPage {

    private WebDriver driver ;
    private WebDriverWait wait ;

    @FindBy(xpath = "//font[contains(text() , 'Summary')]")
    private WebElement flightConfirmationHeader ;

    @FindBy(xpath = "//font[contains(text() , '$')]")
    private WebElement prices ;

    @FindBy(linkText = "SIGN-OFF")
    private  WebElement signOffLink ;

    public FlightConfirmationPage(WebDriver driver)
    {
        this.driver = driver ;
        this.wait= new WebDriverWait(driver, 30) ;
        PageFactory.initElements(driver,this);
    }

 public void getPrice()
 {

     this.wait.until(ExpectedConditions.visibilityOf(this.flightConfirmationHeader)) ;
     System.out.println(this.flightConfirmationHeader.getText());
     //System.out.println(this.prices.get(1).getText());
    // String price = this.prices.get(1).getText();
     this.signOffLink.click();

     //System.out.println(this.prices.get(2).getText());
 }
}
