package elements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Button extends Elements {


    public Button(String locator){
        super.locator = locator;
    }

    @Override
    public void click() {
        waitForElement();
        $(By.xpath(locator)).click();
    }

    @Override
    public String getUrlValue() {
        return $(By.xpath(locator + "//a")).getAttribute("href");
    }
}
