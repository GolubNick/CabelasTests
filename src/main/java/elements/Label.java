package elements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Label extends Element {

    public Label(String locator){
        super.locator = locator;
    }

}
