package tests;

import common.HomePage;
import common.Utils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import webpages.Login;
import webpages.NewAddress;

public class NewAddressTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = Utils.setUpDriver();

        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();

        Login login = new Login(driver);
        login.fillLoginData("testEmail459169@mail.com", "qwerty12345");
    }

    @Test
    public void login() {
        NewAddress newAddress = new NewAddress(driver);
        newAddress.addANewAddress();
    }
}
