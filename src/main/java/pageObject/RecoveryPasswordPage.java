package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecoveryPasswordPage {

    private final WebDriver driver;
    private final String linkRecoveryPasswordPage = "https://stellarburgers.nomoreparties.site/forgot-password";
    // Кнопка "Восстановить"
    private final By recoveryPasswordButton = By.xpath(".//button[text()='Восстановить']");
    // Кнопка "Войти"
    private final By signInButton = By.linkText("Войти");

    public RecoveryPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод открывает страницу восстановления пароля
    public void openRecoveryPasswordPage() {

        driver.get(linkRecoveryPasswordPage);
    }

    //метод кликает на кнопку "Войти"
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    // Метод ожидает появление кнопки "Восстановить"
    public void waitRegistrationButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(recoveryPasswordButton));
    }


}
