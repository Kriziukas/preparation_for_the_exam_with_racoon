package lt.techin.kristinaglebenkoviene;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#email")
    WebElement inputEmail;

    @FindBy(id = "name")
    WebElement inputName;

    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;

    @FindBy(css = "#confirmPassword")
    WebElement inputConfirmPassword;
    @FindBy(xpath = "//button[text()='Register']")
    WebElement buttonRegister;
    @FindBy(xpath = "//h1[text()='Register']")
    WebElement elementRegister;

    @FindBy(xpath = "//div[text()='Email address is invalid']")
    WebElement alertMessageOfWrongEmail;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    WebElement errorMessageOfEmptyRegistration;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    List<WebElement> registrationOfAllErrorMessages;

    @FindBy(xpath = "//a[@href='/notes/app/']")
    WebElement linkHomeMyNotes;

    public String getTextOfLinkHomeMyNotes(){
        return linkHomeMyNotes.getText();
    }

    public String getPartOfTheTextOfLinkHomeMyNotes() {
        return getTextOfLinkHomeMyNotes().split(" - ")[1].trim();
    }


    public void enterInputEmail(String emailAddress) {
        inputEmail.sendKeys(emailAddress);
    }

    public void enterInputName(String userName) {
        inputName.sendKeys(userName);
    }

    public void enterInputPassword(String userPassword) {
        inputPassword.sendKeys(userPassword);
    }

    public void enterInputConfirmPassword(String confirmEmailPassword) {
        inputConfirmPassword.sendKeys(confirmEmailPassword);
    }

    public void clickButtonRegister() {
        buttonRegister.click();
    }

    public String getTextOfElementRegister() {
        return elementRegister.getText();
    }

    public String getTextOfAlertMessageOfWrongEmail() {
        return alertMessageOfWrongEmail.getText();
    }

    public boolean isRegistrationFormEmpty() {
        return errorMessageOfEmptyRegistration.isDisplayed();
    }

    public boolean isErrorMessageDisplayed(String errorMessageText) {
        ArrayList<String> newErrorMessages = new ArrayList<>();
        for (WebElement errorMessage : registrationOfAllErrorMessages) {
            newErrorMessages.add(errorMessage.getText());
        }
        return newErrorMessages.contains(errorMessageText);
    }


}
