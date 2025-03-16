package org.SearchFunctionTest;

import org.baseTest.BaseTest;
import org.junit.Test;

public class SearchTest extends BaseTest {
final String SEARCH_TEXT = "Mex Nutrition, Nitro Whey, 910 g";

    @Test
    public void searchTest() {
        pageProvider.getHomePage().openPage().getHeaderAndShoppingCartElements().enterTextIntoSearchFormAndPerformSearch(SEARCH_TEXT);
        pageProvider.getSearchResultsPage().checkIsRedirectToSearchResultsPage().checkIsSearchResultsPageContainsSearchedItems(SEARCH_TEXT);

    }
}
