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

    public static final By QUESTION0 = By.id("accordion__heading-0");
    public static final By QUESTION1 = By.id("accordion__heading-1");
    public static final By QUESTION2 = By.id("accordion__heading-2");
    public static final By QUESTION3 = By.id("accordion__heading-3");
    public static final By QUESTION4 = By.id("accordion__heading-4");
    public static final By QUESTION5 = By.id("accordion__heading-5");
    public static final By QUESTION6 = By.id("accordion__heading-6");
    public static final By QUESTION7 = By.id("accordion__heading-7");
    public static final By ANSWER0 = By.xpath(".//div[@aria-labelledby='accordion__heading-0']");
    public static final By ANSWER1 = By.xpath(".//div[@aria-labelledby='accordion__heading-1']");
    public static final By ANSWER2 = By.xpath(".//div[@aria-labelledby='accordion__heading-2']");
    public static final By ANSWER3 = By.xpath(".//div[@aria-labelledby='accordion__heading-3']");
    public static final By ANSWER4 = By.xpath(".//div[@aria-labelledby='accordion__heading-4']");
    public static final By ANSWER5 = By.xpath(".//div[@aria-labelledby='accordion__heading-5']");
    public static final By ANSWER6 = By.xpath(".//div[@aria-labelledby='accordion__heading-6']");
    public static final By ANSWER7 = By.xpath(".//div[@aria-labelledby='accordion__heading-7']");



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

    // Нажатие на кнопку "Заказать наверху"
    public void clickOrderButton() {
        driver.findElement(ORDER1).click();
    }

    // Нажатие на кнопку "Заказать внизу"
    public void clickOrderButton2() {
        driver.findElement(ORDER2).click();
    }


}

