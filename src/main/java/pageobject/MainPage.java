package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    // Страница приложения
    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    // Кнопка "Куки"
    private static final By COOKIES = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    // Картинка с самокатом
    private static final By IMAGE = By.xpath(".//img[@src='/assets/blueprint.png']");


    // Список "Вопросы о важном"
    private static final By IMPORTANT = By.xpath(".//div[text()='Вопросы о важном']");

    // Кнопка "Заказать" наверху
    private static final By ORDER1 = By.xpath(".//button[@class='Button_Button__ra12g']");

    // Кнопка "Заказать" внизу
    private static final By ORDER2 = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
    }

    public void clickCookies() {
        driver.findElement(COOKIES).click();
    }
    public void waitImage() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(IMAGE));

    }

    public void scrollList() {
        WebElement element = driver.findElement(IMPORTANT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

    }

    public void clickButtonList(By QUESTION) {
        driver.findElement(QUESTION).click();
    }

    public void clickOrderButton() {
        driver.findElement(ORDER1).click();
    }


    public void clickOrderButton2() {
        driver.findElement(ORDER2).click();
    }


}

