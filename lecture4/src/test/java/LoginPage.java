import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends PageObject{

    @FindBy(className="auth-input_primary")
    private List<WebElement> formOfAuthorization;

    @FindBy(className="auth-form__title_big")
    private WebElement title;

    @FindBy(className="auth-form__button_width_full")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickToSubmitButton() {
        submitButton.click();
    }

    public void fillData() {
        formOfAuthorization.get(0).sendKeys("valerynick123@gmail.com");
        formOfAuthorization.get(1).sendKeys("leravalera123");
    }

    public boolean isInitialized() {
        return formOfAuthorization.get(0).isDisplayed() && formOfAuthorization.get(1).isDisplayed() && title.isDisplayed();
    }
}
