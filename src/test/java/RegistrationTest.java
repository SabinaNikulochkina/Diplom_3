import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.LoginPage;
import pageObject.RegistrationPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class RegistrationTest {

    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private WebDriver driver;
    private final String name = "Sabina10";
    private final String email = "test1222@gmail.com";
    private final String password = "Qwerty123!";
    private final String passwordIncorrect = "Qwer";

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

    }
    @DisplayName("Регистрация нового пользователя")
    @Test
    public void registrationNewUser() {
        registrationPage.openRegistrationPage();
        registrationPage.fillingNameEmailPassword(name, email, password);
        registrationPage.clickRegistrationButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String result = loginPage.getTextSignInButton();
        assertEquals("Войти", result);
    }
    @DisplayName("Регистрация нового пользователя с некорретным паролем")
    @Test
    public void registrationNewUserIncorrectPassword() {
        registrationPage.openRegistrationPage();
        registrationPage.fillingNameEmailPassword(name, email, passwordIncorrect);
        registrationPage.clickRegistrationButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String result = registrationPage.getTextPasswordIncorrect();
        assertEquals("Некорректный пароль", result);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
