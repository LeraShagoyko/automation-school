import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnlinerPage extends PageObject {

    @FindBy(className="auth-bar__item--text")
    private WebElement enterButton;

    @FindBy(className="b-top-profile__image")
    private WebElement accountElement;

    public OnlinerPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return enterButton.isDisplayed();
    }

    public void showLoginForm() {
        enterButton.click();
    }

    public boolean isAuthorized() {
        return accountElement.isDisplayed();
    }
}
