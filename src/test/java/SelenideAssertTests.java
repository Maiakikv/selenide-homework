import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class SelenideAssertTests {

    public SelenideAssertTests() {
               Configuration.browserSize = ("2048x1536");
        timeout = 10000;
        holdBrowserOpen = false;
        screenshots = true;
        reopenBrowserOnFail = true;
        assertionMode = AssertionMode.SOFT;
        reportsFolder = "src/main/resources/Reports";
        savePageSource = false;


    }

    @Test
    public void testOne() {
        open("https://demoqa.com/books ");
        ElementsCollection books = $(".rt-tbody").findAll(".rt-tr-group").filterBy(text("O'Reilly Media")).filterBy(text("Javascript"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(books.size(), 10);
        String firstMatch = books.first().find("div").find("div", 1).getText();
        softAssert.assertEquals(firstMatch, "Learning JavaScript Design Patterns");
        SelenideElement back =$(byId("addNewRecordButton"));
        books.stream().forEach(b -> b.find("a").scrollTo().pressEnter());
        //ვერ გადავდივარ უკან ვერანაირი ცდით
        back();

        softAssert.assertAll();

    }

    @Test
    public void testTwo() {
        open("https://demoqa.com/books ");
        ElementsCollection books = $(".rt-tbody").$$(".rt-tr-group").filterBy(text("O'Reilly Media")).filterBy(text("Javascript"));
        ElementsCollection images = $$(By.xpath("//img[contains(@src, 'book')]"));
        images.stream().forEach(img -> img.isImage());

    }

}
