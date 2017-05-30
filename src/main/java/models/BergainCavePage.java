package models;

import elements.Button;
import elements.Link;
import elements.Page;

public class BergainCavePage extends PageObject{
    private static BergainCavePage instance;

    private Link mensClothing;

    public static BergainCavePage get() {
        if (instance == null) {
            instance = new BergainCavePage().init();
        }
        return instance;
    }

    private BergainCavePage init() {
        super.pageLocator = new Page("//*[@id='subcategoryTemplate1']/../../../..");
        mensClothing = new Link("(//*[@class='viewAllLink'])[1]");

        return this;
    }

    public void clickFirstItem(){
        mensClothing.click();
    }

}
