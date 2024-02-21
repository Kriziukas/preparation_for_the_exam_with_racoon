package lt.techin.kristinaglebenkoviene;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[text()='Login']")
    WebElement elementLogin;

    public String getTextOfElementLogin() {
        return elementLogin.getText();
    }


}
