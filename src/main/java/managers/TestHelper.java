package managers;

import java.util.HashMap;

public class TestHelper {
    private static HashMap<String, String> mapAboutUs = new HashMap<>();
    private static HashMap<String, String> mapYourOrder = new HashMap<>();
    private static HashMap<String, String> mapShoppingResources = new HashMap<>();
    private static HashMap<String, String> mapOtherDepartments = new HashMap<>();

    static {
        mapAboutUs.put("Our History","content.jsp?pageName=history");
        mapAboutUs.put("Investor Relations","http://phx.corporate-ir.net/phoenix.zhtml?c=177739&p=irol-irhome");
        mapAboutUs.put("Careers","http://cabelas.jobs");
        mapAboutUs.put("Diversity and Inclusion","custserv/custserv.jsp?pageName=diversityinclusion");
        mapAboutUs.put("Sponsored Events","content.jsp?pageName=SponsoredEvents");
        mapAboutUs.put("Support and Advertising","https://information.cabelas.com/support");
        mapAboutUs.put("Consumer Product Safety","browse.cmd?categoryId=270151380");
        mapAboutUs.put("Brand Partners","content.jsp?pageName=CorporatePartners");
        mapAboutUs.put("Affiliate Programs","browse.cmd?categoryId=105627780");
        mapAboutUs.put("Pro Staff","browse.cmd?categoryId=855617580");
        mapAboutUs.put("Retail Store Survey","www.cabelas.com/retailsurvey");
        mapAboutUs.put("Sponsorships/Donations","http://www.cabelas.com/content.jsp?pageName=SponsorshipDonations");
        mapAboutUs.put("Cabela's Outdoor Fund","browse.cmd?categoryId=112097880");

        mapYourOrder.put("Track Your Order","checkout/order_status.jsp");
        mapYourOrder.put("Return Policy","custserv/custserv.jsp?pageName=ReturnsPolicy");
        mapYourOrder.put("Shipping Information","custserv/custserv.jsp?pageName=ShippingInfo");
        mapYourOrder.put("Legendary Guarantee","custserv/custserv.jsp?pageName=Guarantee");

        mapShoppingResources.put("Gun Library","browse.cmd?categoryId=103792680");
        mapShoppingResources.put("Online Guns","category/Online-Guns/1265161680.uts");
        mapShoppingResources.put("Gift Cards","browse.cmd?categoryId=106042680");
        mapShoppingResources.put("Customer Reviews","custserv/custserv.jsp?pageName=CustomerReviews");
        mapShoppingResources.put("Boats & Boat Centers","browse.cmd?categoryId=105879780");
        mapShoppingResources.put("ATV","browse.cmd?categoryId=112248180");
        mapShoppingResources.put("Corporate Outfitters","http://www.cabelas.com/browse.cmd?categoryId=1526179680");
        mapShoppingResources.put("Military Discount Program","custserv/custserv.jsp?pageName=MilitaryDiscountProgram");
        mapShoppingResources.put("New Product Submission","content.jsp?pageName=NewProductDivision");
        mapShoppingResources.put("Catalog Quick Order","catalog/catalog_quick_order.jsp");
        mapShoppingResources.put("Pricing/Specifications","https://cabelas.custhelp.com/app/answers/detail/a_id/296");
        mapShoppingResources.put("Site Map","custserv/sitemap.jsp");

        mapOtherDepartments.put("Articles and Information","browse.cmd?categoryId=105924780");
        mapOtherDepartments.put("Game & Fish Information","content.jsp?pageName=GameFishInfo");
        mapOtherDepartments.put("Trophy Room","browse.cmd?categoryId=105919380");
    }

    public static HashMap<String,String> getItemsAboutUsCabelas(){
        return mapAboutUs;
    }

    public static HashMap<String,String> getItemsYourOrderCabelas(){
        return mapYourOrder;
    }

    public static HashMap<String,String> getItemsmapShoppingResourcesCabelas(){
        return mapShoppingResources;
    }

    public static HashMap<String,String> getItemsmapOtherDepartmentsCabelas(){
        return mapOtherDepartments;
    }
}
