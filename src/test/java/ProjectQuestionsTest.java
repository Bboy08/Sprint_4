import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import pageobject.MainPage;


@RunWith(Parameterized.class)
public class ProjectQuestionsTest extends BaseTest {


    private final By QUESTION;
    private final By ANSWER;
    private final String EXPECTED;

    public ProjectQuestionsTest(By QUESTION, By ANSWER, String EXPECTED) {
        this.QUESTION = QUESTION;
        this.ANSWER = ANSWER;
        this.EXPECTED = EXPECTED;
    }

    @Parameterized.Parameters(name = "Ожидается текст: {2}")
    public static Object[][] getData() {
        return new Object[][]{
                {MainPage.QUESTION0, MainPage.ANSWER0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {MainPage.QUESTION1, MainPage.ANSWER1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {MainPage.QUESTION2, MainPage.ANSWER2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {MainPage.QUESTION3, MainPage.ANSWER3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {MainPage.QUESTION4, MainPage.ANSWER4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {MainPage.QUESTION5, MainPage.ANSWER5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {MainPage.QUESTION6, MainPage.ANSWER6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {MainPage.QUESTION7, MainPage.ANSWER7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }



    //Выпадающий список в разделе «Вопросы о важном»
    @Test
    public void checkTextInTheList() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickCookies();
        mainPage.waitImage();
        mainPage.scrollList();
        mainPage.clickButtonList(QUESTION);
        assertEquals(EXPECTED, driver.findElement(ANSWER).getText());
    }


}
