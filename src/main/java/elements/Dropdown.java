package elements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Dropdown extends Elements {

    public Dropdown(String locator){
        super.locator = locator;
    }

    public String[] getListAllItemsWithText(){
        return this.getText().split("\n");
    }

    @Override
    public void setText(String value) {
        $(By.xpath(locator)).selectOption(value);
    }
}
