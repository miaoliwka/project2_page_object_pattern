package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    private WebDriver driver;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[@class='account_user_name hide_xs']")
    private WebElement userName;

    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillLoginData(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();
    }

    public String getUserName(){
        return userName.getText();
    }
}
