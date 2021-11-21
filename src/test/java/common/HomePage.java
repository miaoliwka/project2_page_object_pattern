package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private static String pageOfHotel = "https://hotel-testlab.coderslab.pl/en/";
    private WebDriver driver;

    @FindBy(xpath = "//li[@class='active']")
    private WebElement signInButton;

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    private WebElement mainPageButton;

    public HomePage(WebDriver driver){
        this.driver = driver;
        driver.get(pageOfHotel);
        PageFactory.initElements(driver, this);
    }

    public void clickSignInButton(){
        signInButton.click();
    }

    public void mainPage(){
        mainPageButton.click();
    }
}
