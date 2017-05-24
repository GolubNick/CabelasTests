
import org.testng.annotations.Test;

import java.util.Arrays;

public class TestProgram extends UpTests{

    private final String CABELAS_CLUB_LINK = "/custserv/custserv.jsp?pageName=clubhome";
    private final String CABELAS_CANADA_LINK = "http://www.cabelas.ca";
    private final String GREY_TEXT_SAERCH_FIELD = "What are you looking for?";
    private final String[] YOUR_ACCOUNT_NOT_SIGN_IN = new String[]{"My Account","Order History","Wish List","Preferences","Create a New Account","or"};
    private final String[] CATEGORIES = new String[]{"HUNTING","SHOOTING","FISHING","BOATING","CAMPING","AUTO & ATV","CLOTHING","FOOTWEAR","HOME & CABIN","HOBBIES"};

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
}
