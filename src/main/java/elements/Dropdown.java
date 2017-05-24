package elements;

public class Dropdown extends Element {

    public Dropdown(String locator){
        super.locator = locator;
    }

    public String[] getListAllItemsWithText(){
        return this.getText().split("\n");
    }
}
