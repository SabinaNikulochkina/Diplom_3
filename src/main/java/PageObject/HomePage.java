package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private String linkHomePage = "https://stellarburgers.nomoreparties.site/";

    // Кнопка "Личный кабинет"
    private By buttonAccount = By.linkText("Личный Кабинет");

    // Кнопка "Войти в аккаунт"
    private By signInButton = By.xpath(".//button[text()='Войти в аккаунт']");

    // Кнопка "Конструктор"
    private By constructorButton = By.linkText("Конструктор");

    // Лого "stellar burgers"
    private By logo = By.className("AppHeader_header__logo__2D0X2");

    // Заголовок конструктора "Соберите бургер"
    private By headerConstructor = By.xpath(".//*[@class='text text_type_main-large mb-5 mt-10']");

    // Раздел "Булки"
    private By bunsTab = By.xpath(".//div/span[text()='Булки']");
    private By  bunsIsDisplayed = By.xpath(".//section[1]/div[2]/h2[1]");

    // Раздел "Соусы"
    private By saucesTab = By.xpath(".//div/span[text()='Соусы']");
    private By saucesIsDisplayed = By.xpath(".//section[1]/div[2]/h2[2]");

    // Раздел "Начинки"
    private By fillingsTab = By.xpath(".//div/span[text()='Начинки']");
    private By fillingsIsDisplayed = By.xpath(".//section[1]/div[2]/h2[3]");

    // Выбранный раздел
    private By activeTab = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span");

    // метод открывает главную страницу
    public void openHomePage (){

        driver.get(linkHomePage);
    }
    // клик по кнопке "Личный кабинет"
    public void clickButtonAccount() {

        driver.findElement(buttonAccount).click();
    }

    // клик по кнопке "Войти в аккаунт"
    public void clickSignInButton() {

        driver.findElement(signInButton).click();
    }

    // клик по кнопке "Конструктор"
    public void clickConstructorButton() {

        driver.findElement(constructorButton).click();
    }

    // клик по Лого
    public void clickLogo() {

        driver.findElement(logo).click();
    }

    // клик по вкладке "Булки"
    public void clickBuns() {

        driver.findElement(bunsTab).click();
    }

    // Вклалка Булки активна
    public boolean bunsTabIsActive() {
        return driver.findElement(bunsIsDisplayed).isDisplayed();
    }

    // клик по вкладке "Соусы"
    public void clickSauces() {

        driver.findElement(saucesTab).click();
    }
    // Вклалка Соусы активна
    public boolean saucesTabIsActive() {
        return driver.findElement(saucesIsDisplayed).isDisplayed();
    }

    // клик по вкладке "Начинки"
    public void clickFillings() {

        driver.findElement(fillingsTab).click();
    }

    public boolean fillingsTabIsActive() {
        return driver.findElement(fillingsIsDisplayed).isDisplayed();
    }


    // Получение текста "Соберите бургер"
    public String getTextHeaderConstructor() {

        return driver.findElement(headerConstructor).getText();
    }



}
