package elements;

import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;

import static com.codeborne.selenide.Selenide.$;

public class Link extends Elements {

    public Link(String locator){
        super.locator = locator;
    }

    @Override
    public void click() {
        $(By.xpath(locator)).click();
    }

    @Override
    public String getUrlValue(){
        try {
            return $(By.xpath(locator + "//a")).getAttribute("href");
        }
        catch (ElementNotFound e){
            return "";
        }
    }
}
