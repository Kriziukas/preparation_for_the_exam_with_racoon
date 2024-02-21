package lt.techin.kristinaglebenkoviene;

import lt.techin.kristinaglebenkoviene.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterPageTest extends BasePageTest {
    MainPage mainPage;
    RegisterPage registerPage;
    SuccessfullyRegisterPage successfullyRegisterPage;
    LoginPage loginPage;


    private final Logger log = Logger.getLogger(RegisterPageTest.class.getName());

    String emailAddress = "mesken@gmail.com";
    String wrongEmailAddress = "meskenas2015@gmail.";
    String userName = "Meskenas";
    String userPassword = "meskenas123";
    String userConfirmPassword = "meskenas123";


    @Test
    public void userRegistration() {
        mainPage = new MainPage(driver);
        registerPage = new RegisterPage(driver);
        successfullyRegisterPage = new SuccessfullyRegisterPage(driver);
        loginPage = new LoginPage(driver);


        mainPage.clickButtonCreateAnAccount();
        assertEquals("Register", registerPage.getTextOfElementRegister(), "Registration Element should have text 'Register'");
//        registerPage.enterInputEmail(emailAddress);
//        registerPage.enterInputEmail(TestUtils.getRandomEmail());
        registerPage.enterInputEmail(TestUtils.getRandomEmailSimple());

        registerPage.enterInputName(userName);
        registerPage.enterInputPassword(userPassword);
        registerPage.enterInputConfirmPassword(userConfirmPassword);
        registerPage.clickButtonRegister();
        assertEquals("User account created successfully", successfullyRegisterPage.getMessageOfSuccessfullyRegistration(), "Successfully registration should display this text 'User account created successfully'");

        successfullyRegisterPage.clickButtonClickHereToLogIn();
        assertEquals("Login", loginPage.getTextOfElementLogin(), "Login Page Element should have text 'Login'");

        log.info("Registration test with a new user is successfully!");
        log.info("Ačiū už egzaminą!");
    }

    @Test
    public void wrongEmailRegistration() {
        mainPage = new MainPage(driver);
        registerPage = new RegisterPage(driver);

        mainPage.clickButtonCreateAnAccount();
        assertEquals("Register", registerPage.getTextOfElementRegister(), "Registration Button should have text 'Register'");
        registerPage.enterInputEmail(wrongEmailAddress);
        registerPage.clickButtonRegister();

        assertEquals("Email address is invalid", registerPage.getTextOfAlertMessageOfWrongEmail(), "Invalid email address alert should be displayed below the input field of Email address.");
//    String expectedInfoMessage = "Email address is invalid";
//    String actualInfoMessage = registerPage.getTextOfAlertMessageOfWrongEmail();
//    assertEquals(expectedInfoMessage, actualInfoMessage, "Invalid email address alert should be displayed below the input field of Email address.");
        log.info("The alert message about the invalid email address should be displayed!");
    }

    @Test
    void userEmptyRegistration() {
        mainPage = new MainPage(driver);
        registerPage = new RegisterPage(driver);

        mainPage.clickButtonCreateAnAccount();
        registerPage.clickButtonRegister();
        assertTrue(registerPage.isRegistrationFormEmpty());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/registration_data.csv", numLinesToSkip = 2)
    void userRegistrationWithCsvFileData(String userEmailCsv, String userNameCsv, String userPasswordCsv, String userConfirmPasswordCsv, String errorMessageCsv) {
        mainPage = new MainPage(driver);
        registerPage = new RegisterPage(driver);

        mainPage.clickButtonCreateAnAccount();
        registerPage.enterInputEmail(userEmailCsv);
        registerPage.enterInputName(userNameCsv);
        registerPage.enterInputPassword(userPasswordCsv);
        registerPage.enterInputConfirmPassword(userConfirmPasswordCsv);
        registerPage.clickButtonRegister();

        assertTrue(registerPage.isErrorMessageDisplayed(errorMessageCsv), "Error Message: " + errorMessageCsv);
        System.out.println("Error Message: " + errorMessageCsv);
    }


}

