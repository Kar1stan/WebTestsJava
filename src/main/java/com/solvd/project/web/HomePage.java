package com.solvd.project.web;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class HomePage extends AbstractPage {
    private WebDriver driver;
    private final String url = "https://selenium.dev";

    @FindBy(xpath = "//h1[contains(text(),'Selenium')]")
    private ExtendedWebElement seleniumHeader;

    @FindBy(css = "button[aria-label='Toggle navigation']")
    private ExtendedWebElement navigationMenuBtn;

    @FindBy(css = "a[href='/documentation/webdriver/']")
    private ExtendedWebElement readMoreBtn;

    @FindBy(css = "a[href='/about/']")
    private ExtendedWebElement aboutSelenium;

    @FindBy(css = "button[aria-label='Search']")
    private ExtendedWebElement searchButton;

    @FindBy(css = "input[type='search']")
    private ExtendedWebElement searchInput;

    @FindBy(css = "a[href='https://www.selenium.dev/documentation/ide/']")
    private ExtendedWebElement seleniumIDEOption;

    @FindBy(css = "a[href='/downloads']")
    private ExtendedWebElement downloadsBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        getDriver().get(url);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getHeaderText() {
        return seleniumHeader.getText();
    }

    public void clickReadMore() {
        readMoreBtn.scrollTo();
        readMoreBtn.waitUntil(ExpectedConditions.elementToBeClickable(readMoreBtn.getElement()), 10);
        readMoreBtn.click();
    }

    public void scrollToAboutSelenium() {
        aboutSelenium.scrollTo();
    }

    public boolean isAboutSeleniumVisible() {
        return aboutSelenium.isVisible();
    }

    public void clickNavigationBtn() {
        navigationMenuBtn.click();
    }

    public void searchAndSelectSeleniumIDE() {
        searchButton.waitUntil(ExpectedConditions.elementToBeClickable(searchButton.getElement()), 10);
        searchButton.click();
        searchInput.waitUntil(ExpectedConditions.elementToBeSelected(searchInput.getElement()), 10);
        searchInput.type("Selenium");
        // Waiting "Selenium IDE" to show up.
        seleniumIDEOption.waitUntil(ExpectedConditions.elementToBeClickable(seleniumIDEOption.getElement()), 10);
        seleniumIDEOption.click();
    }

    public void clickDownloadsLink() {
        downloadsBtn.waitUntil(ExpectedConditions.elementToBeClickable(downloadsBtn.getElement()), 10);
        downloadsBtn.click();
    }

    public boolean isSearchVisible() {
        return searchInput.isVisible();
    }

}
