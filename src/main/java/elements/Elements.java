package elements;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public abstract class Elements implements IElement {

    String locator;


    @Override
    public boolean isVisible() {
        waitForElement();
        return $(By.xpath(locator)).isDisplayed();
    }

    @Override
    public String getText() {
        waitForElement();
        return $(By.xpath(locator)).getText();
    }

    @Override
    public String getGreyText() {
        waitForElement();
        return $(By.xpath(locator)).getAttribute("placeholder");
    }

    @Override
    public int getCount(){
        return $$(By.xpath(locator)).size();
    }

    @Override
    public void waitForElement() {
        $(By.xpath(locator)).waitUntil(Condition.appear, 2000l);
    }

    public String getLocator(){
        return locator.toString();
    }
}
