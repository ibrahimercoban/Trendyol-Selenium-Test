import User.User;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import pages.HomePage;
import pages.SignUpPage;
import pages.TakeMail;
import org.testng.Assert;
import org.testng.annotations.Test;
import User.User;

public class AddBasketAndSignUpTest extends BaseTest{

    @Test
    public void succesfulAddToBasket(){
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();
        ProductList productList =  homePage.goToTvDisplayAndSound();
        productList.scrollToPage();
        productList.addToBasketProduct();
        String productTitle = productList.getProductTitle();
        BasketPage basketPage = productList.clickBasket();
        String productTitleInBasket = basketPage.getProductTitleInBasket();
        Assert.assertTrue(productTitleInBasket.contains(productTitle));
    }
    @Test
    public void successfulSignUp(){
        String expectedAccountName = "Hesabım";
        TakeMail takeMail = new TakeMail(driver);
        User user = new User();
        user.setEmail(takeMail.takeMail());
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.goToSignUpPage();
        HomePage homePage = signUpPage.signUp(user.getEmail(), user.getPassword());
        String accountText =  homePage.getAccountText();
        Assert.assertEquals(accountText, expectedAccountName);
        }
}
