import PageObject.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    private WebDriver driver;
    RegistrationPage registrationPage;
    LoginPage loginPage;
    HomePage homePage;
    RecoveryPasswordPage recoveryPasswordPage;
    private String email = "test225@gmail.com";
    private String password = "Qwerty123!";

    @Before
    public void setup() {
        // Тестирование в Chrome
        driver = new ChromeDriver();
        // Тестирование в Yandex
        /* ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\YPPrograms\\WebDriver\\bin\\yandexdriver.exe");
        options.setBinary("C:\\Users\\nikul\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        driver = new ChromeDriver(options); */

        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        recoveryPasswordPage = new RecoveryPasswordPage(driver);
        homePage = new HomePage(driver);

    }

    @Test
    public void enterFromButtonAccount (){
        homePage.openHomePage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.clickButtonAccount();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        loginPage.fillingEmailPassword(email, password);
        loginPage.clickSignInButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String result = homePage.getTextHeaderConstructor();
        assertEquals("Соберите бургер", result);
    }

    @Test
    public void enterFromSignInButton (){
        homePage.openHomePage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.clickSignInButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        loginPage.fillingEmailPassword(email, password);
        loginPage.clickSignInButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String result = homePage.getTextHeaderConstructor();
        assertEquals("Соберите бургер", result);
    }

    @Test
    public void enterFromRegistrationPage (){
        registrationPage.openRegistrationPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        registrationPage.clickSignInButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        loginPage.fillingEmailPassword(email, password);
        loginPage.clickSignInButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String result = homePage.getTextHeaderConstructor();
        assertEquals("Соберите бургер", result);
    }

    @Test
    public void enterFromRecoveryPasswordPage (){
        recoveryPasswordPage.openRecoveryPasswordPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        recoveryPasswordPage.clickSignInButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        loginPage.fillingEmailPassword(email, password);
        loginPage.clickSignInButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String result = homePage.getTextHeaderConstructor();
        assertEquals("Соберите бургер", result);
    }


    @After
    public void teardown() {
        driver.quit();
    }
}
