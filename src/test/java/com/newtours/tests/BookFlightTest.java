package com.newtours.tests;

import com.newstours.pages.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

public class BookFlightTest extends BaseTest {

    private  String  noOfPassenger ;


    @BeforeTest
    @Parameters("noOfPassengers")
    public void setupParameters(String noOfPassenger)
    {
       this.noOfPassenger= noOfPassenger ;

    }

    @Test
    public void registrationPage()
    {
        RegistrationPage registrationPage = new RegistrationPage(driver) ;
        registrationPage.goTo();
        registrationPage.enterUserDetails("selenium" , "docker");
        registrationPage.enterUserCredentials("selenium","docker");

registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage()
    {
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver) ;
        registrationConfirmationPage.goToFlightDetailsPage();

    }

    @Test(dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage()
    {

        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver) ;
        flightDetailsPage.selectPassengers(noOfPassenger);
        flightDetailsPage.goToFindFlightsPage();

    }

    @Test(dependsOnMethods = "flightDetailsPage" )
    public void findFlightPage()
    {

        FindFlightPage findFlightPage = new FindFlightPage(driver) ;
        findFlightPage.submitFindFlightPage();
        findFlightPage.gotToFlightConfirmationPage();

    }

    @Test(dependsOnMethods = "findFlightPage")

    public void flightConfirmationPage(){

        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver) ;
        flightConfirmationPage.getPrice() ;

    }


}
