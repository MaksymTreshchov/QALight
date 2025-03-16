package org.LikedItemsTest;

import org.baseTest.BaseTest;
import org.junit.Test;

public class OpeningLikedItemsWhenNotLoggedInOpensLogInPopUpTest extends BaseTest {

    @Test
    public void openingLikedItemsWhenNotLoggedInOpensLogInPopUpTest() {
        pageProvider.getHomePage().openPage().getHeaderAndShoppingCartElements().clickOnLikedProductsButton();
        pageProvider.getHomePage().getHeaderAndShoppingCartElements().checkIsLoginButtonVisible();
    }
}
