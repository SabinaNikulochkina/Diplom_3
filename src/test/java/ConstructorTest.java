import PageObject.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class ConstructorTest {
    private WebDriver driver;
    HomePage homePage;

    @Before
    public void setup() {
        // Тестирование в Chrome
        driver = new ChromeDriver();
        // Тестирование в Yandex
        /* ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\YPPrograms\\WebDriver\\bin\\yandexdriver.exe");
        options.setBinary("C:\\Users\\nikul\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        driver = new ChromeDriver(options); */
        homePage = new HomePage(driver);
    }


    @Test
    public void switchSauces (){
        homePage.openHomePage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.clickSauces();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        assertTrue("Вкладка Соусы не активна", homePage.saucesTabIsActive());
    }

    @Test
    public void switchBuns (){
        homePage.openHomePage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.clickSauces();
        homePage.clickBuns();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        assertTrue("Вкладка Булки не активна", homePage.bunsTabIsActive());
    }

    @Test
    public void switchFillings (){
        homePage.openHomePage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.clickFillings();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        assertTrue("Вкладка Начинки не активна", homePage.fillingsTabIsActive());
    }


    @After
    public void teardown() {
        driver.quit();
    }
}
