package org.CheckoutTest;

import org.baseTest.BaseTest;
import org.junit.Test;

public class ChangeQuantityInCheckoutTest extends BaseTest {

    @Test
    public void t4_changeQuantityInCheckoutTest() {
        pageProvider.getHomePage().openPage().openProteinPage().addItemFromNormalSectionToCart().getHeaderAndShoppingCartElements().clickOnGoToCheckoutButton().checkIsRedirectToCheckoutPage().clickEditCartButton().getHeaderAndShoppingCartElements().clickOnIncreaseProductQuantityButton();
        pageProvider.getCheckoutPage().getHeaderAndShoppingCartElements().clickOnCloseShoppingCartButton();
        pageProvider.getCheckoutPage().checkIsItemQuantityCorrect("2");
    }
}
