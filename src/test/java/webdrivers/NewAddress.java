package webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddress {
    private WebDriver driver;

    @FindBy(xpath = "//a[@title='Add my first address']")
    private WebElement addFirstAddressButton;

    @FindBy(xpath = "//input[@id='address1']")
    private WebElement addressInput;

    @FindBy(xpath = "//input[@id='postcode']")
    private WebElement postcode;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityInput;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement homePhone;

    @FindBy(xpath = "//input[@id='phone_mobile']")
    private WebElement mobilePhoneInput;

    @FindBy(xpath = "//input[@id='alias']")
    private WebElement addressTitle;

    @FindBy(xpath = "//button[@id='submitAddress']")
    private WebElement saveButton;

    public NewAddress(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addANewAddress(){
        addFirstAddressButton.click();
        addressInput.sendKeys("Nyska 55");
        postcode.sendKeys("50-516"); //format: 00-000
        cityInput.sendKeys("Wroclaw");
        mobilePhoneInput.sendKeys("385726507");
        addressTitle.clear();
        addressTitle.sendKeys("My home address");
        saveButton.click();
    }
}
