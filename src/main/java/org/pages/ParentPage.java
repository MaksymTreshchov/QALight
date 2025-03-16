package org.pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.utils.ConfigProvider;

abstract public class ParentPage extends CommonActionsWithElements {
    Logger logger = Logger.getLogger(getClass());

    protected String baseUrl = ConfigProvider.configProperties.base_url();

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    abstract protected String getRelativeUrl();

    protected void checkUrl(){
        Assert.assertEquals("URL is not expected",
                baseUrl +  getRelativeUrl(),
                webDriver.getCurrentUrl());
    }

    protected void checkUrlWithPattern(){
        Assert.assertTrue("URL is not expected \n" +
                        "Expected url: " + baseUrl + getRelativeUrl() +
                        "\n Actual url: " + webDriver.getCurrentUrl(),
                webDriver.getCurrentUrl().matches(baseUrl +  getRelativeUrl()));
    }

    protected void switchToTab(int tabNumber) {
        try {
            webDriver.switchTo().window((String) webDriver.getWindowHandles().toArray()[tabNumber]);
            logger.info("Switched to tab " + tabNumber);
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void openNewTab() {
        try {
            ((JavascriptExecutor) webDriver).executeScript("window.open()");
            logger.info("New tab was opened");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

}
