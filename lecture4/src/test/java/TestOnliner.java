import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestOnliner {

    @Test
    public static void test() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.onliner.by");

        WebElement enterButton = driver.findElement(By.cssSelector(".auth-bar__item.auth-bar__item--text"));
        enterButton.click();

        List<WebElement> formOfAuthorization = ((ChromeDriver) driver).findElements(By.cssSelector(".auth-input_primary"));
        formOfAuthorization.get(0).sendKeys("valerynick123@gmail.com");
        formOfAuthorization.get(1).sendKeys("leravalera123");
        WebElement loginButton = driver.findElement(By.cssSelector(".auth-form__button_width_full"));
        loginButton.click();
        sleeper();

        driver.navigate().to("https://catalog.onliner.by/smartwatch/xiaomi/miband4blkgl/prices?town=minsk");
        sleeper();

        WebElement basket = driver.findElement(By.xpath("//table/tbody/tr/td[3]/a"));
        basket.click();

        driver.navigate().to("https://cart.onliner.by/");
        sleeper();

        WebElement product = driver.findElement(By.cssSelector(".cart-product"));
        product.getSize();
        Assert.assertTrue(product.getSize().getWidth() > 0);

        String text = product.findElement(By.cssSelector(".cart-product-title__link_name")).getText();
        Assert.assertEquals(text, "Xiaomi Mi Smart Band 4 (глобальная версия)");

        driver.quit();
    }

    private static void sleeper() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
