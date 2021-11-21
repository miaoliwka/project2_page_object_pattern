package tests;

import common.BookRoom;
import common.HomePage;
import common.Utils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import webpages.Login;
import webpages.SearchHotel;

public class SearchHotelTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = Utils.setUpDriver();

        HomePage homePage = new HomePage(driver);
        Login login = new Login(driver);

        homePage.clickSignInButton();
        login.fillLoginData("testEmail459169@mail.com", "qwerty12345");
        homePage.mainPage();
    }

    @Test
    public void searchAndBookAHotel(){
        String hotelLocation = "Warsaw";
        String checkIn = "22-12-2021";  //date format DD-MM-YYYY
        String checkOut = "02-01-2022"; //date format DD-MM-YYYY
        String roomName = "General Rooms"; //roomName: General Rooms, Delux Rooms, Executive Rooms, luxury Rooms
        String roomQuantity = "2";

        SearchHotel searchHotel = new SearchHotel(driver);
        BookRoom bookRoom = new BookRoom(driver);

        searchHotel.searchAHotel(hotelLocation, checkIn, checkOut);
        bookRoom.bookRoom(roomName, roomQuantity);
        searchHotel.bookHotel();
        searchHotel.payment();
        Assert.assertEquals("Your order on MyBooking is complete.", searchHotel.getAlertSuccess());
        }
    }
