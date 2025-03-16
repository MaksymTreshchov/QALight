package org.pages;

import org.openqa.selenium.WebDriver;


public class PageProvider {
    private WebDriver webDriver;

    public PageProvider(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public HomePage getHomePage() {
        return new HomePage(webDriver);
    }

    public ProteinPage getProteinPage() {
        return new ProteinPage(webDriver);
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(webDriver);
    }

    public CheckoutPage getCheckoutPage() {
        return new CheckoutPage(webDriver);
    }

}
