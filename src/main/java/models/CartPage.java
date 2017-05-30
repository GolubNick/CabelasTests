package models;

import elements.*;

public class CartPage extends PageObject {
    private static CartPage instance;

    private Element item;
    private Label titleItem;
    private Label itemAttributes;
    private Label itemTitle;
    private Label price;
    private Link remove;
    private Link update;
    private Button keepShopping;
    private Button beginCheckout;
    private Input fieldQuantity;

    public static CartPage get() {
        if (instance == null) {
            instance = new CartPage().init();
        }
        return instance;
    }

    private CartPage init() {
        super.pageLocator = new Page("//*[@class = 'contentWrapper']");
        titleItem = new Label("//*[@class = 'cartHeader basketHeader']");
        item = new Element("//*[@id = 'cartItemTable']");
        itemTitle = new Label("//*[@id = 'itemDescription']");
        itemAttributes = new Label("//*[@class = 'itemAttributes']");
        price = new Label("//*[@class = 'basketItemTotal']");
        remove = new Link("//*[@class = 'cart-item-actions clearfix']//a");
        update = new Link("//*[@id = 'updateItemDiv']/a");
        keepShopping = new Button("//*[@id = 'keepShoppingButton']");
        beginCheckout = new Button("//*[@id = 'checkout-link']");
        fieldQuantity = new Input("//*[@id = 'itemQuantityBox']");

        return this;
    }

    public String getTitleItemText(){
        return titleItem.getText();
    }

    public boolean isItemVisible(){
        return item.isVisible();
    }

    public boolean isItemAttributesVisible(){
        return itemAttributes.isVisible();
    }

    public boolean isItemTitleVisible(){
        return itemTitle.isVisible();
    }

    public boolean isRemoveVisible(){
        return remove.isVisible();
    }

    public boolean isKeepShoppingVisible(){
        return keepShopping.isVisible();
    }

    public boolean isBeinCheckoutVisible(){
        return beginCheckout.isVisible();
    }

    public boolean isPriceVisible(){
        return price.isVisible();
    }

    public String getQuantity(){
        return fieldQuantity.getText();
    }

    public void setFieldQuantityValue(String value){
        fieldQuantity.setText(value);
    }

    public void clickUpdate(){
        update.click();
    }

    public void clickRemove(){
        remove.click();
    }

}
