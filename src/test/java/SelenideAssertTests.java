import com.codeborne.selenide.*;
import com.codeborne.selenide.selector.ByText;
import com.codeborne.selenide.testng.SoftAsserts;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@Listeners({SoftAsserts.class})
public class SelenideAssertTests {

    public SelenideAssertTests() {

        Configuration.browserSize = ("2048x1536");
        timeout = 10000;
        holdBrowserOpen = false;
        screenshots = true;
        reopenBrowserOnFail = true;
        assertionMode = AssertionMode.SOFT;
        reportsFolder = "src/main/resources/Reports";


    }

    @Test
    public void testOne()  {
        open("https://demoqa.com/books ");
        //ჩვეულებრივი იქსპასით აკეთებს და მეორეში რა მერევა, ვერ გავიგე
        // List<SelenideElement> books= $$(By.xpath("//div[contains(text(), 'Reilly Media')]//ancestor-or-self::div[@role='row']//div[2]//div//span//a[contains(text(), 'JavaScript')]"));
        List<SelenideElement> books = $(withText("Reilly")).closest("[role=row]").find(("div"), 1)
                .find("div").find("span").findAll(withText("JavaScript"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(books.size(), 10);
        softAssert.assertEquals(books.get(0).getText(), "Learning JavaScript Design Patterns");
        books.stream().forEach(el -> el.click());
        softAssert.assertAll();

    }

    @Test
    public void testTwo() {
        open("https://demoqa.com/books ");
        //find-ის ნაცვლად დოლარის ნიშნებიც ჩავსვი და ისევ ამაოდ
        List<SelenideElement> books = $$(By.xpath("//div[contains(text(), 'Reilly Media')]//ancestor-or-self::div[@role='row']//div[2]//div//span//a[contains(text(), 'JavaScript')]"));
        // $$("img[src*='book']").stream.forEach(img -> img.shouldBe(not(empty));
        books.stream().forEach(img -> img.shouldBe(not(empty)));

    }

}
