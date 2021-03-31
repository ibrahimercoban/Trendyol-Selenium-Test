package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BaseMethod {

    By basketItem = By.className("pb-item");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public String getProductTitleInBasket(){
        return driver.findElement(basketItem).getAttribute("title");
    }
}
