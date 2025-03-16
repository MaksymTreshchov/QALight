package org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.pages.elements.HeaderAndShoppingCartElements;

public class HomePage extends org.pages.ParentPage {
    private Logger logger = Logger.getLogger(getClass());

    @FindBy(xpath = "//div[@class='main_wrapper']//a[@href='/ua/proteini' and @class='catalog__link with_arrow']")
    private WebElement proteiniLink;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "";
    }

    public HeaderAndShoppingCartElements getHeaderAndShoppingCartElements() {
        return new HeaderAndShoppingCartElements(webDriver);
    }

    public HomePage openPage(){
        webDriver.get(baseUrl);
        logger.info("Home page was opened");
        return this;
    }

    public HomePage checkIsRedirectToHomePage(){
        checkUrl();
        return this;
    }

    public ProteinPage openProteinPage(){
        Actions actions = new Actions(webDriver);
        actions.moveToElement(proteiniLink).build().perform();
        actions.click(proteiniLink).build().perform();
        return new ProteinPage(webDriver);
    }

    public HomePage openNewTabAndOpenHomePage(){
        openNewTab();
        switchToTab(1);
        openPage();
        return this;
    }
}
