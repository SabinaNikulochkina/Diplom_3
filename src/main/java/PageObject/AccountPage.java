package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {
    private WebDriver driver;

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }

    private String linkAccountPage = "https://stellarburgers.nomoreparties.site/account/profile";

    // Кнопка "Выход"
    private By exitButton = By.xpath(".//button[text()='Выход']");

    // метод открывает страницу профиля
    public void openAccountPage (){

        driver.get(linkAccountPage);
    }

    //метод кликает на кнопку "Выход"
    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }

    //метод ожидает появление кнопки "Выход"
    public void waitRegistrationButton() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(exitButton));
    }

}
