package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BaseMethod {

    private String url = "https://www.trendyol.com/uyelik";
    private By mailField = By.id("register-email");
    private By passwordField = By.id("register-password-input");
    private By submitBtn = By.className("submit");
    private By componentListBy = By.className("component-list");
    WebDriverWait wait;

    public SignUpPage(WebDriver driver){
        super(driver);
        wait = new WebDriverWait(super.driver, 15);
    }

    public void goToSignUpPage(){
        driver.get(url);
    }

    public HomePage signUp(String mail, String password){

        sendKeys(mailField, mail);
        sendKeys(passwordField, password);
        click(submitBtn, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(componentListBy));
        return new HomePage(driver);
    }
}