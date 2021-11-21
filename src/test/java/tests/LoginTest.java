package tests;

import common.HomePage;
import common.Utils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import webdrivers.Login;

public class LoginTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = Utils.setUpDriver();
    }

    @Test
    public void loginUser(){
        String email = "testEmail459169@mail.com";
        String password = "qwerty12345";

        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();

        Login login = new Login(driver);
        login.fillLoginData(email, password);

        Assert.assertEquals("Alice", login.getUserName());
    }
}
