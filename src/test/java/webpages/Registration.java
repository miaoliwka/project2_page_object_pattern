package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration {
    private WebDriver driver;

    @FindBy(xpath = "//input[@name='email_create']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    private WebElement createAnAccountButton;

    @FindBy(xpath = "//input[@name='id_gender' and @value='1']")
    private WebElement MrCheckbox;

    @FindBy(xpath = "//input[@name='id_gender' and @value='2']")
    private WebElement MrsCheckbox;

    @FindBy(xpath = "//input[@name='customer_firstname']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='customer_lastname']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='passwd']")
    private WebElement passwordInput;

    @FindBy(xpath = "//select[@id='days'] /option [@value='8']") // day of birth (select value 1-31)
    private WebElement dayOfBirth;

    @FindBy(xpath = "//select[@id='months'] /option [@value='4']") //month of birth (select value 1-12) 1 - January,...,12 - December
    private WebElement monthOfBirth;

    @FindBy(xpath = "//select[@id='years'] /option [@value='1987']") //year of birth (select value 1900-2021)
    private WebElement yearOfBirth;

    @FindBy(xpath = "//input[@name='newsletter']")
    private WebElement newsletterCheckbox;

    @FindBy(xpath = "//input[@name='optin']")
    private WebElement specialOffersCheckbox;

    @FindBy(xpath = "//button[@name='submitAccount']")
    private WebElement registerButton;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    private WebElement successAlert;


    public Registration(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillEmailData(String email){
        emailInput.sendKeys(email);
    }
    public void clickCreateAccountButton(){
        createAnAccountButton.click();
    }
    public void fillRegistrationData(String firstName, String lastName, String password){
        MrsCheckbox.click();
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        passwordInput.sendKeys(password);
        dayOfBirth.click();
        monthOfBirth.click();
        yearOfBirth.click();

        if(!newsletterCheckbox.isSelected())
            newsletterCheckbox.click();

        if(!specialOffersCheckbox.isSelected())
            specialOffersCheckbox.click();

        registerButton.click();
    }
    public String alertInformation(){
        return successAlert.getText();
    }
}
