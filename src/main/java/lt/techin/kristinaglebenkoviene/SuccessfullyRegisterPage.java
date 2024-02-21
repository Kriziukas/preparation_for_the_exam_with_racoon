package lt.techin.kristinaglebenkoviene;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessfullyRegisterPage extends BasePage {
    public SuccessfullyRegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//b[text()='User account created successfully']")
    WebElement messageOfSuccessfullyRegistration;

    @FindBy(xpath = "//a[text()='Click here to Log In']")
    WebElement buttonClickHereToLogIn;

    public String getMessageOfSuccessfullyRegistration() {
       return messageOfSuccessfullyRegistration.getText();
    }

    public void clickButtonClickHereToLogIn() {
        buttonClickHereToLogIn.click();
    }


}
