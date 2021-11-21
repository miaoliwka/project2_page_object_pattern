package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel {
    private WebDriver driver;

    @FindBy(xpath = "//input[@name='hotel_location']")
    private WebElement hotelLocation;

    @FindBy(xpath = "//i[@class='icon icon-angle-down']")
    private WebElement selectHotelButton;

    @FindBy(xpath = "//ul/li[@data-id-hotel='1']")
    private WebElement selectTheHotelPrime;

    @FindBy(xpath = "//input[@id='check_in_time']")
    private WebElement checkInDate;

    @FindBy(xpath = "//input[@id='check_out_time']")
    private WebElement checkOutDate;

    @FindBy(xpath = "//button[@id='search_room_submit']")
    private WebElement searchNowButton;

    @FindBy(xpath = "//a[@rm_product_id='8']")
    private WebElement bookNowButton;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//input[@class='payment_type' and @value='1']")
    private WebElement fullPaymentOption;

    @FindBy(xpath = "//input[@class='payment_type' and @value='2']")
    private WebElement partialPaymentOption;

    @FindBy(xpath = "//input[@id='cgv']")
    private WebElement termsCheckbox;

    @FindBy(xpath = "//a[@title='Pay by check.']")
    private WebElement payByCheckOption;

    @FindBy(xpath = "//button[@class='btn pull-right htl-reservation-form-btn-default']")
    private WebElement confirmOrderButton;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    private WebElement alertSuccess;

    public SearchHotel(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchAHotel(String location, String checkIn, String checkOut){
        hotelLocation.sendKeys(location);
        selectHotelButton.click();
        selectTheHotelPrime.click();
        checkInDate.sendKeys(checkIn);
        checkOutDate.sendKeys(checkOut);
        searchNowButton.click();
    }
    public void bookHotel(){
        bookNowButton.click();
        proceedToCheckoutButton.click();
    }
    public void payment(){
        if(!fullPaymentOption.isSelected())
            fullPaymentOption.click();
       // if(!partialPaymentOption.isSelected())
       //   partialPaymentOption.click();
        termsCheckbox.click();
        payByCheckOption.click();
        confirmOrderButton.click();
    }
    public String getAlertSuccess(){
        return alertSuccess.getText();
    }
}
