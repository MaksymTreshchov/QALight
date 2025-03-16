package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.pages.elements.HeaderAndShoppingCartElements;

public class ProteinPage extends ParentPage {
    @FindBy(xpath = "(//button[contains(@class,'addToCart')])[2]")
    private WebElement addToCart2ndItemButton; // adds item from normal selection of items to cart - excludes "Top products" section

    public ProteinPage(WebDriver webDriver) {
        super(webDriver);
    }

    public HeaderAndShoppingCartElements getHeaderAndShoppingCartElements() {
        return new HeaderAndShoppingCartElements(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/ua/proteini";
    }

    public ProteinPage addItemFromNormalSectionToCart() {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(addToCart2ndItemButton).build().perform();
        actions.click(addToCart2ndItemButton).build().perform();
        return this;
    }
}
