package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.pages.elements.HeaderAndShoppingCartElements;

public class CheckoutPage extends ParentPage{

    @FindBy(xpath = "//button[@class='edit_cart']")
    private WebElement editCartButton;

    private String locatorForItemQuantity = "//div[@class='my_order']//div[contains(text(),'%s шт')]";

    public HeaderAndShoppingCartElements getHeaderAndShoppingCartElements() {
        return new HeaderAndShoppingCartElements(webDriver);
    }

    public CheckoutPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "ua/checkout";
    }

    public CheckoutPage checkIsRedirectToCheckoutPage() {
        checkUrl();
        return this;
    }

    public CheckoutPage clickEditCartButton() {
        editCartButton.click();
        return this;
    }

    public CheckoutPage checkIsItemQuantityCorrect(String quantity) {
        checkIsElementVisible(String.format(locatorForItemQuantity, quantity));
        return this;
    }


}
