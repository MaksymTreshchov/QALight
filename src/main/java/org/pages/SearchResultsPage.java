package org.pages;

import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends ParentPage{
    public SearchResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    private String locatorForSearchedItem = "//a[contains(text(),'%s')]";

    @Override
    protected String getRelativeUrl() {
        return "ua/search.*";
    }

    public SearchResultsPage checkIsRedirectToSearchResultsPage() {
        checkUrlWithPattern();
        return this;
    }

    public SearchResultsPage checkIsSearchResultsPageContainsSearchedItems(String SearchQuery) {
        checkIsElementVisible(String.format(locatorForSearchedItem, SearchQuery));
        return this;
    }
}
