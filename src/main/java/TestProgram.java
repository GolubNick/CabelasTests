
import managers.TestHelper;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;

public class TestProgram extends UpTests{

    private final String CABELAS_CLUB_LINK = "/custserv/custserv.jsp?pageName=clubhome";
    private final String CABELAS_CANADA_LINK = "http://www.cabelas.ca";
    private final String GREY_TEXT_SAERCH_FIELD = "What are you looking for?";
    private final String[] YOUR_ACCOUNT_NOT_SIGN_IN = new String[]{"My Account","Order History","Wish List","Preferences","Create a New Account","or"};
    private final String[] CATEGORIES = new String[]{"HUNTING","SHOOTING","FISHING","BOATING","CAMPING","AUTO & ATV","CLOTHING","FOOTWEAR","HOME & CABIN","HOBBIES"};
    private final String[] ABOUTUSNAME = new String[]{
      "Our History","Investor Relations","Careers","Diversity and Inclusion","Sponsored Events","Support and Advertising",
            "Consumer Product Safety","Brand Partners","Affiliate Programs","Pro Staff","Retail Store Survey",
            "Sponsorships/Donations","Cabela's Outdoor Fund"};
    private final String[] YOURORDERNAME = new String[]{
            "Track Your Order","Return Policy","Shipping Information","Legendary Guarantee"};
    private final String[] SHOPPINGRESOURCES = new String[]{
            "Gun Library","Online Guns","Gift Cards","Customer Reviews","Boats & Boat Centers","ATV","Corporate Outfitters","Military Discount Program","New Product Submission",
            "Catalog Quick Order","Pricing/Specifications","Site Map"};
    private final String[] OTHERDEPARTMENTS = new String[]{"Articles and Information","Game & Fish Information","Trophy Room"};

    @Test
    public void cabelasTest1(){
        logBusiness(1, "Verification both cabelasclub and cabelascanada buttons");
        assertTrue(getModel().getCabelasPage().isVisible(), "Cabelas.com is open");
        assertTrue(getModel().getCabelasPage().isCabelasClubVisible(), "CabelasClub button is visible");
        assertTrue(getModel().getCabelasPage().getCabelasClubLink().contains(CABELAS_CLUB_LINK), "\"Cabela's CLUB\" button present with link \"/custserv/custserv.jsp?pageName=clubhome\"");
        assertTrue(getModel().getCabelasPage().isCabelasCanadaVisible(), "CabelasCanada button is visible");
        assertTrue(getModel().getCabelasPage().getCabelasCanadaLink().contains(CABELAS_CANADA_LINK), "\"Cabela's Canada\" button present with link \"http://www.cabelas.ca\"");

        logBusiness(2, "Verification shopping");
        assertTrue(getModel().getCabelasPage().getItemNumbers().matches("\\d"),"Cart image present with any number");
        assertTrue(getModel().getCabelasPage().isCheckoutButtonVisible(),"Checkout button present");

        logBusiness(3, "Check 'Your Account' dropdown without sign in");
        assertTrue(getModel().getCabelasPage().isYourAccountVisible(), "Your Account block is present");
        assertTrue(getModel().getCabelasPage().getTextYourAccount().contains("Sign In or Create"), "Text higher: \"Sign In or Create\"");
        assertTrue(Arrays.equals(getModel().getCabelasPage().getListAllItemsYourAccount(), YOUR_ACCOUNT_NOT_SIGN_IN),
                "if user not signed in, next links present: " + String.valueOf(YOUR_ACCOUNT_NOT_SIGN_IN));

        logBusiness(4, "Check categories block");
        assertTrue(Arrays.equals(getModel().getCabelasPage().getListAllItemsCategories(),CATEGORIES),"Categories block present" + CATEGORIES);

        logBusiness(5, "Check search field");
        assertTrue(getModel().getCabelasPage().isSearchFieldVisible(),"Search field visible");
        assertTrue(getModel().getCabelasPage().getGreyTextSearchField().equals(GREY_TEXT_SAERCH_FIELD),"Search field contains grey text: " + GREY_TEXT_SAERCH_FIELD);
        assertTrue(getModel().getCabelasPage().isSearchButtonVisible(),"Search button is visible");
    }

    @Test
    public void cabelasTest2(){
        logBusiness(1, "Check AboutUs section");
        assertTrue(getModel().getCabelasPage().getURLAboutUs().contains("content.jsp?pageName=AboutUs"),"Link About Us contains: /content.jsp?pageName=AboutUs");
        HashMap<String,String> actualMap = getModel().getCabelasPage().getAllItemsAboutUs();
        HashMap<String,String> expectedMap = TestHelper.getItemsAboutUsCabelas();
        for (int i = 0; i < ABOUTUSNAME.length; i++){
            assertTrue(actualMap.get(ABOUTUSNAME[i]).contains(expectedMap.get(ABOUTUSNAME[i])), ABOUTUSNAME[i] + ": " + expectedMap.get(ABOUTUSNAME[i]));
        }

        logBusiness(2, "Check Your order section");
        assertTrue(getModel().getCabelasPage().getURLYourOrder().isEmpty(), "YOUR ORDER without link");
        actualMap = getModel().getCabelasPage().getAllItemsYourOrder();
        expectedMap = TestHelper.getItemsYourOrderCabelas();
        for (int i = 0; i < YOURORDERNAME.length; i++){
            assertTrue(actualMap.get(YOURORDERNAME[i]).contains(expectedMap.get(YOURORDERNAME[i])), YOURORDERNAME[i] + ": " + expectedMap.get(YOURORDERNAME[i]));
        }

        logBusiness(3, "Check Shopping Resources");
        assertTrue(getModel().getCabelasPage().getURLShoppingResources().isEmpty(), "SHOPPING RESOURCES without link");
        actualMap = getModel().getCabelasPage().getAllItemsShoppingResources();
        expectedMap = TestHelper.getItemsmapShoppingResourcesCabelas();
        for (int i = 0; i < SHOPPINGRESOURCES.length; i++){
            assertTrue(actualMap.get(SHOPPINGRESOURCES[i]).contains(expectedMap.get(SHOPPINGRESOURCES[i])), SHOPPINGRESOURCES[i] + ": " + expectedMap.get(SHOPPINGRESOURCES[i]));
        }

        logBusiness(4, "Check Other Departments");
        assertTrue(getModel().getCabelasPage().getURLOtherDepartments().isEmpty(), "OTHER DEPARTMENTS without link");
        actualMap = getModel().getCabelasPage().getAllItemsOtherDepartments();
        expectedMap = TestHelper.getItemsmapOtherDepartmentsCabelas();
        for (int i = 0; i < OTHERDEPARTMENTS.length; i++){
            assertTrue(actualMap.get(OTHERDEPARTMENTS[i]).contains(expectedMap.get(OTHERDEPARTMENTS[i])));
        }
    }

    @Test
    public void cabelasTest3(){
        logBusiness(1, "Go to Cabelas.com");
        assertTrue(getModel().getCabelasPage().isVisible(), "Page opens");

        logBusiness(2, "Bargain Cave > New This Week");
        getModel().getCabelasPage().showBergainCave();
        getModel().getCabelasPage().clickNewThisWeek();
        assertTrue(getModel().getBergainCavePage().isVisible(), "New This Week page opens");

        logBusiness(3, "Open any item, select random options and Add to Cart");
        getModel().getBergainCavePage().clickFirstItem();
        String title = getModel().getMensClothing().clickFirstItem();
        getModel().getMensClothing().selectFirstValueOption();
        getModel().getMensClothing().clickAddToCard();
        assertTrue(getModel().getItemAddedToCart().isVisible(), "Item Added to Cart page opens");
        assertTrue(getModel().getItemAddedToCart().isItemVisible(), "Added item present in Cart");
        assertTrue(getModel().getItemAddedToCart().getItemTitleText().equals(title), "Title, item number, options of item is the same");
        assertTrue(getModel().getItemAddedToCart().isInfoAboutItemVisible(), "Info about Cart present\n" +
                "\"Items in Cart: 1\", \"Sub-Total XXX\", buttons \"View All Items in Cart\" and \"Checkout\"");

        logBusiness(4, "Press Checkout");
        getModel().getItemAddedToCart().clickCheckOut();
        assertTrue(getModel().getCartPage().isVisible(), "Cart page opens");
        assertTrue(getModel().getCartPage().getTitleItemText().contains("CART (1)"), "CART (1) title");
        assertTrue(getModel().getCartPage().isItemVisible(), "Item present in cart.");
        assertTrue(getModel().getCartPage().isItemTitleVisible(), "Item have title.");
        assertTrue(getModel().getCartPage().isItemAttributesVisible(), "Item have options and item number");
        assertTrue(getModel().getCartPage().isRemoveVisible(), "Item have remove button");
        assertTrue(getModel().getCartPage().getQuantity().equals("1"), "Field with correct qty");
        assertTrue(getModel().getCartPage().isPriceVisible(), "Price");
        assertTrue(getModel().getCartPage().isKeepShoppingVisible(), "Button \"Keep Shopping\"");
        assertTrue(getModel().getCartPage().isBeinCheckoutVisible(), "Button \"Begin Checkout\"");

        logBusiness(5, "Press Remove for second item");
        getModel().getCartPage().clickRemove();
        assertTrue(getModel().getCartPage().getTitleItemText().contains("CART (0)"), "Item renoved from cart");
    }

}
