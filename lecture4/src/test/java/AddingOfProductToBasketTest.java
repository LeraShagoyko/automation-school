import org.junit.Test;

import static org.testng.Assert.assertTrue;

public class AddingOfProductToBasketTest extends BaseTest {
    @Test
    public void signUp() {
        driver.get("https://www.onliner.by");

        OnlinerPage onlinerPage = new OnlinerPage(driver);
        assertTrue(onlinerPage.isInitialized());

        onlinerPage.showLoginForm();

        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isInitialized());

        loginPage.fillData();
        loginPage.clickToSubmitButton();

        assertTrue(onlinerPage.isAuthorized());

        driver.get("https://catalog.onliner.by/smartwatch/xiaomi/miband4blkgl/prices?town=minsk");

        ProductPage productPage = new ProductPage(driver);
        productPage.clickToBasketButton();
        productPage.clickToBasketIconButton();
        assertTrue(productPage.isInitialized());
    }
}
