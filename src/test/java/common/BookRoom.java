package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookRoom {
    private WebDriver driver;

    public BookRoom(WebDriver driver) {
        this.driver = driver;
    }

    public void bookRoom(String roomName, String quantity) {
        String roomSelector = "//*[text()='" + roomName + "']/..";
        WebElement roomSection = driver.findElement(By.xpath(roomSelector));

        WebElement quantityInput = roomSection.findElement(By.cssSelector(".cat_quantity_wanted"));
        quantityInput.clear();
        quantityInput.sendKeys(quantity);

        WebElement bookNowButton = roomSection.findElement(By.xpath("//*[text()='Book Now']"));
        bookNowButton.click();
    }
}
