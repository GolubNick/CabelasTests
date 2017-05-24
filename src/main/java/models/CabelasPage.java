package models;

import elements.*;

public class CabelasPage extends PageObject {

    private static CabelasPage instance;

    private Button cabelasClub;
    private Button cabelasCanada;
    private Button checkout;
    private Button itemNumbers;
    private Button signIn;
    private Label categories;
    private Input searchField;
    private Button searchButton;
    private Button yourAccount;
    private Dropdown yourAccountDropdown;
    private Dropdown categoriesBlock;

    public static CabelasPage get() {
        if (instance == null) {
            instance = new CabelasPage().init();
        }
        return instance;
    }

    private CabelasPage init() {
        super.pageLocator = new Page("//*[@class = 'homeBody']");
        cabelasClub = new Button("//*[@class='headerNavClubLink']");
        cabelasCanada = new Button("//*[@class='headerNavCabelasCanadaLink']");
        checkout = new Button("//*[@class='cartCheckout']");
        itemNumbers = new Button("//*[@class='numberOfItems']");
        categories = new Label("//*[@class='numberOfItems']");
        searchField = new Input("//*[@id='searchKeyword']");
        searchButton = new Button("//*[@id='searchKeywordButton']");
        yourAccount = new Button("//*[@class='headerAccount']");
        signIn = new Button("//*[@class='icon-headerSignInBtn']");
        yourAccountDropdown = new Dropdown("//*[@class='signInDropdown']");
        categoriesBlock = new Dropdown("//*[@class='shopDropdown home']");

        return this;
    }

    public boolean isCabelasClubVisible() {
        return cabelasClub.isVisible();
    }

    public String getCabelasClubLink() {
        return cabelasClub.getUrlValue();
    }

    public boolean isCabelasCanadaVisible() {
        return cabelasCanada.isVisible();
    }

    public String getCabelasCanadaLink() {
        return cabelasCanada.getUrlValue();
    }

    public String getItemNumbers() {
        return itemNumbers.getText();
    }

    public boolean isCheckoutButtonVisible() {
        return checkout.isVisible();
    }

    public void clickYourAccount() {
        yourAccount.click();
    }

    public String getTextYourAccount() {
        return yourAccount.getText();
    }

    public boolean isYourAccountVisible() {
        return yourAccount.isVisible();
    }

    public String[] getListAllItemsYourAccount() {
        clickYourAccount();
        return yourAccountDropdown.getListAllItemsWithText();
    }

    public String[] getListAllItemsCategories() {
        return categoriesBlock.getListAllItemsWithText();
    }

    public void clickSignIn() {
        if (!yourAccountDropdown.isVisible())
            clickYourAccount();
        signIn.click();
    }

    public boolean isSearchFieldVisible(){
        return searchField.isVisible();
    }

    public boolean isSearchButtonVisible(){
        return searchButton.isVisible();
    }

    public String getGreyTextSearchField(){
        return searchField.getGreyText();
    }
}
