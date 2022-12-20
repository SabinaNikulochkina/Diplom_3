package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {
    private final WebDriver driver;
    private final String linkAccountPage = "https://stellarburgers.nomoreparties.site/account/profile";
    // Кнопка "Выход"
    private final By exitButton = By.xpath(".//button[text()='Выход']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод открывает страницу профиля
    public void openAccountPage() {

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
