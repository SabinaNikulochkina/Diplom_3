import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.RecoveryPasswordPage;
import pageObject.RegistrationPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private HomePage homePage;
    private RecoveryPasswordPage recoveryPasswordPage;
    private WebDriver driver;
    private final String email = "test225@gmail.com";
    private final String password = "Qwerty123!";

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
    @DisplayName("Вход через кнопку личный кабинет")
    @Test
    public void enterFromButtonAccount() {
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
    @DisplayName("Вход через кнопку Войти в аккаунт")
    @Test
    public void enterFromSignInButton() {
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
    @DisplayName("Вход через окно регистрации")
    @Test
    public void enterFromRegistrationPage() {
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
    @DisplayName("Вход через окно восстановления пароля")
    @Test
    public void enterFromRecoveryPasswordPage() {
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
