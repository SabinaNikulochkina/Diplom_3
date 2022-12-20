package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final String linkLoginPage = "https://stellarburgers.nomoreparties.site/login";
    // Кнопка "Войти"
    private final By signInButton = By.xpath(".//button[text()='Войти']");
    // Поле "Email"
    private final By emailInput = By.name("name");
    // Поле "Пароль"
    private final By passwordInput = By.name("Пароль");
    // Кнопка "Зарегистрироваться"
    private final By registrationButton = By.xpath(".//*[@href='/register']");
    // Кнопка "Восстановить пароль"
    private final By restorePassword = By.xpath(".//*[@href='/forgot-password']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод открывает страницу авторизации
    public void openLoginPage() {

        driver.get(linkLoginPage);
    }

    // метод кликает на кнопку "Войти"
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    // метод кликает на кнопку "Зарегистрироваться"
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    // метод кликает на кнопку "Восстановить пароль"
    public void clickRestorePassword() {
        driver.findElement(restorePassword).click();
    }

    // метод заполняет поле email
    public void setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    //метод заполняет поле пароль
    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    //метод, котрый объединяет ввод данных в поля
    public void fillingEmailPassword(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    // Получение текста "Войти"
    public String getTextSignInButton() {

        return driver.findElement(signInButton).getText();
    }

}
