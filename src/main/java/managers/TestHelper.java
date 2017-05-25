package managers;

import java.util.HashMap;

public class TestHelper {
    private static HashMap<String, String> mapAboutUs = new HashMap<>();

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
    }

    public static HashMap<String,String> getItemsAboutUsCabelas(){
        return mapAboutUs;
    }
}
