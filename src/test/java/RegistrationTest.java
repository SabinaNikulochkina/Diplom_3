import PageObject.AccountPage;
import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.RegistrationPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class RegistrationTest {

    private WebDriver driver;
    RegistrationPage registrationPage;
    LoginPage loginPage;

    private String name = "Sabina10";
    private String email = "test1222@gmail.com";
    private String password = "Qwerty123!";
    private String passwordIncorrect = "Qwer";

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

    @Test
    public void registrationNewUser (){
        registrationPage.openRegistrationPage();
        registrationPage.fillingNameEmailPassword(name, email,password);
        registrationPage.clickRegistrationButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String result = loginPage.getTextSignInButton();
        assertEquals("Войти", result);
    }

    @Test
    public void registrationNewUserIncorrectPassword (){
        registrationPage.openRegistrationPage();
        registrationPage.fillingNameEmailPassword(name, email,passwordIncorrect);
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
