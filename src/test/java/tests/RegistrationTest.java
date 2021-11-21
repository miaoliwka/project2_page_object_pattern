package tests;

import common.HomePage;
import common.Utils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import webdrivers.Registration;

public class RegistrationTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = Utils.setUpDriver();
    }

    @Test
    public void RegistrationANewUser(){
        String email = Utils.generateEmail();
        String firstName = "Alice";
        String lastName = "Smith";
        String password = "qwerty12345";

        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();

        Registration registration = new Registration(driver);
        registration.fillEmailData(email);
        registration.clickCreateAccountButton();
        registration.fillRegistrationData(firstName, lastName, password);

        Assert.assertEquals("Your account has been created.", registration.alertInformation());
    }
    }

