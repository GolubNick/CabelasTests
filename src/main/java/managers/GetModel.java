package managers;

import models.*;

public class GetModel {

    private static GetModel instance;

    public static GetModel get(){
        if (instance == null){
            instance = new GetModel();
        }
        return instance;
    }

    public CabelasPage getCabelasPage(){
        return CabelasPage.get();
    }

    public BergainCavePage getBergainCavePage(){
        return BergainCavePage.get();
    }

    public MensClothing getMensClothing(){
        return MensClothing.get();
    }

    public ItemAddedToCart getItemAddedToCart(){
        return ItemAddedToCart.get();
    }

    public CartPage getCartPage(){
        return CartPage.get();
    }

}
