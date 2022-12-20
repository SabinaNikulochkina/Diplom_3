package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver driver;
    private final String linkRegistrationPage = "https://stellarburgers.nomoreparties.site/register";
    // Поле "Имя"
    private final By nameInput = By.xpath(".//fieldset[1]//input");
    // Поле "Email"
    private final By emailInput = By.xpath(".//fieldset[2]//input");
    // Поле "Пароль"
    private final By passwordInput = By.xpath(".//fieldset[3]//input");
    // Кнопка "Зарегистрироваться"
    private final By registrationButton = By.xpath(".//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    // Ошибка "Некорректный пароль"
    private final By passwordIncorrect = By.xpath(".//p[text()='Некорректный пароль']");
    // Кнопка "Войти"
    private final By signInButton = By.className("Auth_link__1fOlj");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод открывает страницу регистрации
    public void openRegistrationPage() {

        driver.get(linkRegistrationPage);
    }

    // Метод для ввода имени в поле Имя
    public void setName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    // Метод для ввода email в поле Email
    public void setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    // Метод для ввода пароля в поле Пароль
    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    //метод, котрый объединяет ввод данных в поля
    public void fillingNameEmailPassword(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
    }

    // Метод для клика на кнопку Зарегистрироваться
    public void clickRegistrationButton() {

        driver.findElement(registrationButton).click();
    }

    // Метод для клика на кнопку Войти
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    // Метод получает текст ошибки "Некорректный пароль"
    public String getTextPasswordIncorrect() {

        return driver.findElement(passwordIncorrect).getText();
    }


}
