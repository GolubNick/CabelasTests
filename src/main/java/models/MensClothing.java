package models;

import elements.Button;
import elements.Dropdown;
import elements.Link;
import elements.Page;

public class MensClothing extends PageObject{
    private static MensClothing instance;

    private Link linkItem;
    private Dropdown options;
    private Button addToCard;

    public static MensClothing get() {
        if (instance == null) {
            instance = new MensClothing().init();
        }
        return instance;
    }

    private MensClothing init() {
        super.pageLocator = new Page("//*[@class='resultContainer']");
        linkItem = new Link("//*[@class='productItem'][1]//a//h3");
        options = new Dropdown("(//*[@name='dropDownGroupValues:0'])[1]");
        addToCard = new Button("//*[@class='noBorder btnAddToCart']");
        return this;
    }

    public String clickFirstItem(){
        String titleItem = linkItem.getText();
        linkItem.click();
        return titleItem;
    }

    public void selectFirstValueOption(){
        options.setText("SMALL");
    }

    public void clickAddToCard(){
        addToCard.click();
    }
}
