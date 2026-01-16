package com.solvd.project.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Optional;

import com.zebrunner.carina.utils.report.ReportContext;
import com.zebrunner.carina.webdriver.DriverHelper;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

//Page for to test same selectors
public class ItemsPage extends AbstractPage {
    private final String url = "https://selenium.dev";

    public ItemsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Read More ')]")
    private List<ExtendedWebElement> items;

    public int countItems() {
        return items == null ? 0 : items.size();
    }

    // return element by 0-based index (safe to wrap in check)
    public ExtendedWebElement getItemByIndex(int index) {
        if (items == null || index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("No item at index " + index);
        }
        return items.get(index);
    }

    // click by index (0-based)
    public void clickItemByIndex(int index) {
        getItemByIndex(index).scrollTo();
        getItemByIndex(index).click();
    }

    public void open() {
        getDriver().get(url);
    }

}
