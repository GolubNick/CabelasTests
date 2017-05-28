package models;

import elements.Page;

public class BergainCavePage extends PageObject{
    private static BergainCavePage instance;

    public static BergainCavePage get() {
        if (instance == null) {
            instance = new BergainCavePage().init();
        }
        return instance;
    }

    private BergainCavePage init() {
        super.pageLocator = new Page("//*[@id='subcategoryTemplate1']/../../../..");

        return this;
    }

}
