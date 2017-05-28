import managers.GetModel;
import managers.WebManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class UpTests extends AssertionNew {

    private final String URL_CABELAS = "http://cabelas.com";

    public GetModel getModel(){
        return GetModel.get();
    }

    @BeforeMethod
    protected void initDriver(){
        WebManager.get();
        open(URL_CABELAS);
    }

    @AfterMethod
    protected void closeDriver(){
        close();
    }
}
