package org.pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.pages.CheckoutPage;
import org.pages.CommonActionsWithElements;

public class HeaderAndShoppingCartElements extends CommonActionsWithElements {
    @FindBy(xpath = "//div[@class='btn_wr']//button[@aria-label='Кошик товарів'")
    private WebElement shoppingCartButtonUA;

    @FindBy(xpath = "//button[@onclick=\"window.location='/ua/checkout'\" and @class='btn btn_1']")
    private WebElement goToCheckoutButton;

    @FindBy(xpath = "//form[@id='searchForm']")
    private WebElement searchForm;

    @FindBy(xpath = "//button[@class='cart__plus cart__symbol']")
    private WebElement increaseProductQuantityButton;

    @FindBy(xpath = "//div[@class='cart__bottom_wr']//button[@class='close']")
    private WebElement closeShoppingCartButton;

    @FindBy(xpath = "//div[@class='header__btns']//a[@data-href='/ua/spisok_pokupok']")
    private WebElement LikedProductsButton;

    @FindBy(xpath = "//button[contains(text(),'Увійти')]")
    private WebElement loginButton;

    public HeaderAndShoppingCartElements(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnShoppingCartButtonUA(){
        clickOnElementUsingActions(shoppingCartButtonUA);
    }

    public void checkIsCheckoutButtonVisible(){
        webDriverWait_10.until(ExpectedConditions.visibilityOf(goToCheckoutButton));
        checkIsElementVisible(goToCheckoutButton);
    }

    public CheckoutPage clickOnGoToCheckoutButton(){
        webDriverWait_10.until(ExpectedConditions.elementToBeClickable(goToCheckoutButton));
        clickOnElementUsingActions(goToCheckoutButton);
        return new CheckoutPage(webDriver);
    }

    public void enterTextIntoSearchFormAndPerformSearch(String text){
        clickOnElementUsingActions(searchForm);
        enterTextUsingActions(text);
        searchForm.submit();
    }

    public void clickOnIncreaseProductQuantityButton(){
        clickOnElementUsingActions(increaseProductQuantityButton);
    }

    public void clickOnCloseShoppingCartButton(){
        clickOnElementUsingActions(closeShoppingCartButton);
    }

    public void clickOnLikedProductsButton(){
        clickOnElementUsingActions(LikedProductsButton);
    }

    public void checkIsLoginButtonVisible(){
        webDriverWait_10.until(ExpectedConditions.visibilityOf(loginButton));
        checkIsElementVisible(loginButton);
    }


}
