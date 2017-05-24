package models;

import elements.Page;

public abstract class PageObject {

    protected Page pageLocator;

    public boolean isVisible(){
        return pageLocator.isVisible();
    }
}
