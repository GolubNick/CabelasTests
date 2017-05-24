package managers;

import models.CabelasPage;

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

}
