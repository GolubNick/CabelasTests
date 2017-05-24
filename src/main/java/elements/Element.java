package elements;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public abstract class Element implements IElement {

    String locator;


    @Override
    public boolean isVisible() {
        waitForElement();
        return $(By.xpath(locator)).exists();
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
    public void waitForElement() {
        $(By.xpath(locator)).waitUntil(Condition.appear, 2000l);
    }
}
