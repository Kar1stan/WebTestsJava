package com.solvd.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import com.solvd.project.HomePage;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.Test;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;

public class TestSelenium implements IAbstractTest {

    @Test
    @MethodOwner(owner = "vladislav.karastan")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testBrowser() {
        System.out.println("Launching Chrome...");
        WebDriver driver = new ChromeDriver();

        HomePage homePage = new HomePage(driver);
        homePage.open();

        String title = homePage.getTitle();
        System.out.println("Page title: " + title);

        Assert.assertTrue(title.contains("Selenium"), "Title should contain 'Selenium'");

        driver.quit();
    }
}
