import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.MainPage;


@RunWith(Parameterized.class)
public class ProjectQuestionsTest {

    private final By QUESTION;
    private final By ANSWER;
    private final String EXPECTED;

    public ProjectQuestionsTest(By QUESTION, By ANSWER, String EXPECTED) {
        this.QUESTION = QUESTION;
        this.ANSWER = ANSWER;
        this.EXPECTED = EXPECTED;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {By.id("accordion__heading-0"), By.xpath(".//div[@aria-labelledby='accordion__heading-0']"), "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {By.id("accordion__heading-1"), By.xpath(".//div[@aria-labelledby='accordion__heading-1']"), "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {By.id("accordion__heading-2"), By.xpath(".//div[@aria-labelledby='accordion__heading-2']"), "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {By.id("accordion__heading-3"), By.xpath(".//div[@aria-labelledby='accordion__heading-3']"), "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {By.id("accordion__heading-4"), By.xpath(".//div[@aria-labelledby='accordion__heading-4']"), "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {By.id("accordion__heading-5"), By.xpath(".//div[@aria-labelledby='accordion__heading-5']"), "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {By.id("accordion__heading-6"), By.xpath(".//div[@aria-labelledby='accordion__heading-6']"), "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {By.id("accordion__heading-7"), By.xpath(".//div[@aria-labelledby='accordion__heading-7']"), "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    private WebDriver driver;

    @Before
    public void before() {
       driver = new ChromeDriver();

    }

    //Выпадающий список в разделе «Вопросы о важном»
    @Test
    public void check() {
        MainPage page = new MainPage(driver);
        page.openPage();
        page.clickCookies();
        page.waitImage();
        page.scrollList();
        page.clickButtonList(QUESTION);
        assertEquals(EXPECTED, driver.findElement(ANSWER).getText());
    }

    @After
    public void after(){
        driver.quit();
    }

}
