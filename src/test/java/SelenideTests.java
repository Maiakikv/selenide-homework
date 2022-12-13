import org.testng.annotations.Test;
import com.codeborne.selenide.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
public class SelenideTests {
    public SelenideTests() {
        timeout = 5000;
        holdBrowserOpen=false;
    }

    @Test
    public void testOne(){
        open("http://the-internet.herokuapp.com/checkboxes" );
        $("input[type=checkbox]", 0).click();
        $$("input[type=checkbox]").stream().forEach(ch-> ch.should(checked));
    }

    @Test
    public void testTwo(){
        open("http://the-internet.herokuapp.com/dropdown ");
        $("#dropdown").getSelectedOption().shouldHave(text("Please select an option"));
        $("#dropdown").selectOption("Option 2");
        $("#dropdown").getSelectedOption().shouldHave(text("Option 2"));
    }

    @Test
    public void testThree(){
        open("https://demoqa.com/text-box ");
        SelenideElement fullName =$(byAttribute("placeholder", "Full Name"));
        fullName.setValue("Mako");
        SelenideElement email=$("[type=email]");
        email.setValue("mako@gmail.com");
        SelenideElement currentAdress =$("[placeholder='Current Address']");
        currentAdress.sendKeys("tbilisi");
        SelenideElement permanentAdress =$("#permanentAddress");
        permanentAdress.setValue("iaponia");
        SelenideElement submit = $("#submit");
        submit.scrollTo().click();
        $$(".mb-1").shouldHave(texts("Mako", "mako@gmail.com", "tbilisi", "iaponia"));


    }

}
