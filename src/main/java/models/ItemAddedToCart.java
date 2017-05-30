package models;

import elements.*;

public class ItemAddedToCart extends PageObject {
    private static ItemAddedToCart instance;

    private Element item;
    private Link itemTitle;
    private Label itemInfo;
    private Button checkOut;

    public static ItemAddedToCart get() {
        if (instance == null) {
            instance = new ItemAddedToCart().init();
        }
        return instance;
    }

    private ItemAddedToCart init() {
        super.pageLocator = new Page("//*[@id = 'itemAddedToCartTemplate']");
        item = new Element("//*[@class = 'itemColumn']");
        itemTitle = new Link("//*[@class = 'itemInfo']/a");
        itemInfo = new Label("//*[@class = 'itemInfo']/dl");
        checkOut = new Button("//*[@id = 'Checkout']");
        return this;
    }

    public boolean isItemVisible(){
        return item.isVisible();
    }

    public String getItemTitleText(){
        return itemTitle.getText();
    }

    public boolean isInfoAboutItemVisible(){
        return itemInfo.isVisible();
    }

    public void clickCheckOut(){
        checkOut.click();
    }
}
