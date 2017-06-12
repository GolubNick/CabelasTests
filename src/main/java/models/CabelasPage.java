package models;

import elements.*;

import java.util.HashMap;

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
    private Dropdown bergainCaveDropdown;
    private Button bergainCave;
    private Link aboutUs;
    private Link yourOrder;
    private Link shoppingResources;
    private Link otherDepartments;
    private Link yourOrderLink;
    private Link shoppingResourcesLink;
    private Link otherDepartmentsLink;
    private Link newThisWeek;

    public static CabelasPage get() {
        if (instance == null) {
            instance = new CabelasPage().init();
        }
        return instance;
    }

    private CabelasPage init() {
        super.pageLocator = new Page("//*[@class='homeBody']");
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
        aboutUs = new Link("//*[@id='footer_aboutUs']");
        yourOrder = new Link("//*[@id='footer_yourOrder']");
        shoppingResources = new Link("//*[@id='footer_shoppingResources']");
        otherDepartments = new Link("//*[@id='footer_otherDepartments']");
        yourOrderLink = new Link("//*[@id='footer_yourOrder']/b[1]");
        shoppingResourcesLink = new Link("//*[@id='footer_shoppingResources']/b[1]");
        otherDepartmentsLink = new Link("//*[@id='footer_otherDepartments']/b[1]");
        newThisWeek = new Link("//*[@class='saveFlyoutSection']//a[2]");
        bergainCave = new Button("//*[contains(@class,'saveContainer')]");

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

    public String getURLAboutUs(){
        return aboutUs.getUrlValue();
    }

    public String getURLYourOrder(){
        return yourOrderLink.getUrlValue();
    }

    public String getURLShoppingResources(){
        return shoppingResourcesLink.getUrlValue();
    }

    public String getURLOtherDepartments(){
        return otherDepartmentsLink.getUrlValue();
    }

    public HashMap<String, String> getAllItemsAboutUs(){
        HashMap<String, String> mapItems = new HashMap<>();
        Label labels = new Label(aboutUs.getLocator() + "/p");
        int count = labels.getCount();
        for (int i = 1; i <= count; i++){
            Link link = new Link(labels.getLocator() + "[" + i + "]");
            mapItems.put(link.getText(), link.getUrlValue());
        }
        return mapItems;
    }

    public HashMap<String, String> getAllItemsYourOrder(){
        HashMap<String, String> mapItems = new HashMap<>();
        Label labels = new Label(yourOrder.getLocator() + "/p");
        for (int i = 1; i <= 4; i++){
            Link link = new Link(labels.getLocator() + "[" + i + "]");
            mapItems.put(link.getText(), link.getUrlValue());
        }
        return mapItems;
    }

    public HashMap<String, String> getAllItemsShoppingResources(){
        HashMap<String, String> mapItems = new HashMap<>();
        Label labels = new Label(shoppingResources.getLocator() + "/p");
        int count = labels.getCount();
        for (int i = 1; i <= count; i++){
            Link link = new Link(labels.getLocator() + "[" + i + "]");
            mapItems.put(link.getText(), link.getUrlValue());
        }
        return mapItems;
    }

    public HashMap<String, String> getAllItemsOtherDepartments(){
        HashMap<String, String> mapItems = new HashMap<>();
        Label labels = new Label(otherDepartments.getLocator() + "/p");
        for (int i = 1; i <= 3; i++){
            Link link = new Link(labels.getLocator() + "[" + i + "]");
            mapItems.put(link.getText(), link.getUrlValue());
        }
        return mapItems;
    }

    public void showBergainCave(){
        bergainCave.click();
    }

    public void clickNewThisWeek(){
        newThisWeek.click();
    }
}
