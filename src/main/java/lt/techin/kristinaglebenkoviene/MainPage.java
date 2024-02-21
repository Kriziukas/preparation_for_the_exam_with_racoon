package lt.techin.kristinaglebenkoviene;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='col-lg-6']//a[@href='/notes/app/register']")
    WebElement buttonCreateAnAccount;

    public void clickButtonCreateAnAccount() {
        buttonCreateAnAccount.click();
    }
}
