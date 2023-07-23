import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.MainPage;
import pageobject.OrderPage;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class ProjectOrderTest {

    private WebDriver driver;

    private final String NAME1;
    private final String SURNAME1;
    private final String ADDRESS1;
    private final String PHONE1;



    public ProjectOrderTest(String NAME1, String SURNAME1, String ADDRESS1, String PHONE1) {
        this.NAME1 = NAME1;
        this.SURNAME1 = SURNAME1;
        this.ADDRESS1 = ADDRESS1;
        this.PHONE1 = PHONE1;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Антон","Бочаев", "Молодежная 78", "+71111111111"},
                {"Иван","Петров", "Илишкина 15", "+72222222222"},
        };
    }

    @Before
    public void before() {
        driver = new ChromeDriver();

    }

    //Тест с кнопкой заказать наверху

    @Test
    public void check1() {
        MainPage page = new MainPage(driver);
        OrderPage page1 = new OrderPage(driver);
        page.openPage();
        page.clickOrderButton();
        page1.inputName(NAME1);
        page1.inputSurname(SURNAME1);
        page1.inputAddress(ADDRESS1);
        page1.clickButtonMetro();
        page1.clickStation();
        page1.inputPhone(PHONE1);
        page1.clickNextButton();
        page1.clickWhen();
        page1.clickDate();
        page1.clickRents();
        page1.clickDay();
        page1.clickOrder3();
        page1.clickYes();
        assertTrue(page1.isOrderSuccess());
    }

    //Тест с кнопкой заказать внизу
    @Test
    public void check2() {
        MainPage page = new MainPage(driver);
        OrderPage page1 = new OrderPage(driver);
        page.openPage();
        page.clickCookies();
        page.clickOrderButton2();
        page1.inputName(NAME1);
        page1.inputSurname(SURNAME1);
        page1.inputAddress(ADDRESS1);
        page1.clickButtonMetro();
        page1.clickStation();
        page1.inputPhone(PHONE1);
        page1.clickNextButton();
        page1.clickWhen();
        page1.clickDate();
        page1.clickRents();
        page1.clickDay();
        page1.clickOrder3();
        page1.clickYes();
        assertTrue(page1.isOrderSuccess());
    }


    @After
    public void after() {
        driver.quit();
    }

}
