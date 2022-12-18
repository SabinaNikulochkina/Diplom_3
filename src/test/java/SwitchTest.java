import PageObject.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SwitchTest {
    private WebDriver driver;
    LoginPage loginPage;
    AccountPage accountPage;
    HomePage homePage;
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
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        homePage = new HomePage(driver);

    }

    @Test
    public void clickOnConstructorFromAccount (){
        homePage.openHomePage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.clickButtonAccount();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        loginPage.fillingEmailPassword(email, password);
        loginPage.clickSignInButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.clickButtonAccount();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.clickConstructorButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String result = homePage.getTextHeaderConstructor();
        assertEquals("Соберите бургер", result);
    }

    @Test
    public void clickOnLogoFromAccount (){
        homePage.openHomePage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.clickButtonAccount();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        loginPage.fillingEmailPassword(email, password);
        loginPage.clickSignInButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.clickButtonAccount();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.clickLogo();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String result = homePage.getTextHeaderConstructor();
        assertEquals("Соберите бургер", result);
    }

    @Test
    public void exitFromAccount (){
        homePage.openHomePage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.clickButtonAccount();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        loginPage.fillingEmailPassword(email, password);
        loginPage.clickSignInButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.clickButtonAccount();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        accountPage.clickExitButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String result = loginPage.getTextSignInButton();
        assertEquals("Войти", result);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
