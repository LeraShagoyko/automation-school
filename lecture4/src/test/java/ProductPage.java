import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageObject{

    @FindBy(className="offers-list__button_basket")
    private WebElement basketButton;

    @FindBy(className = "b-top-profile__cart")
    private WebElement basketIconButton;

    @FindBy(className = "cart-navigation__button_сheckout")
    private WebElement checkoutButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickToBasketButton() {
        basketButton.click();
    }

    public void clickToBasketIconButton() {
        basketIconButton.click();
    }

    public boolean isInitialized() {
        return checkoutButton.isDisplayed();
    }
}
