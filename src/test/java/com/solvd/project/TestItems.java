package com.solvd.project;

import com.solvd.project.web.ItemsPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.IAbstractTest;
import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestItems implements IAbstractTest {

    @Test(priority = 1)
    @MethodOwner(owner = "vladislav.karastan")
    public void testClickSecondItem() {
        WebDriver driver = new ChromeDriver();
        ItemsPage itemsPage = new ItemsPage(driver);
        itemsPage.open(); // if you have open implemented
        assertTrue(itemsPage.countItems() >= 2, "Need at least 2 items to run test");

        // click second item (index 1)
        itemsPage.clickItemByIndex(1);

        // Assertion: verify the item was indeed clicked
        Assert.assertTrue(
                driver.getCurrentUrl().contains("blog/2025/selenium_manager_usage_whats_behind_chrome_127.0.6533.99/"),
                "Should navigate to Selenium Manager Usage page");
        driver.quit();
    }
}
