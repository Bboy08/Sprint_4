import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.MainPage;
import pageobject.OrderPage;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class ProjectOrderTest extends BaseTest {

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

    //Тест с кнопкой "Заказать" наверху

    @Test
    public void checkOrderForm_buttonAtTheTop() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        mainPage.openPage();
        mainPage.clickCookies();
        mainPage.clickOrderButton();
        orderPage.forWhomFields(NAME1, SURNAME1, ADDRESS1, PHONE1);
        orderPage.clickNextButton();
        orderPage.forWhenFields();
        orderPage.clickOrder3();
        orderPage.clickYes();
        assertTrue(orderPage.isOrderSuccess());
    }

    //Тест с кнопкой "Заказать" внизу
    @Test
    public void checkOrderForm_buttonAtTheBottom() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        mainPage.openPage();
        mainPage.clickCookies();
        mainPage.clickOrderButton2();
        orderPage.forWhomFields(NAME1, SURNAME1, ADDRESS1, PHONE1);
        orderPage.clickNextButton();
        orderPage.forWhenFields();
        orderPage.clickOrder3();
        orderPage.clickYes();
        assertTrue(orderPage.isOrderSuccess());
    }

}
