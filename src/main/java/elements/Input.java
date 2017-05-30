package elements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Input extends Elements {

    public Input(String locator){
        super.locator = locator;
    }


    @Override
    public void setText(String value) {
        $(By.xpath(locator)).setValue(value);
    }
}
