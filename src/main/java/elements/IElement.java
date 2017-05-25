package elements;

public interface IElement {

    default String getText(){return "";}

    default String getGreyText(){return "";}

    default void click(){}

    default boolean isVisible(){return false;}

    default void waitForElement(){}

    default void setText(String value){}

    default String getUrlValue(){return "";}

    default int getCount(){return 0;}


}
