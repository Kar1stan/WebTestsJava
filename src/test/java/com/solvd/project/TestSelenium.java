package com.solvd.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.solvd.project.web.HomePage;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.utils.config.Configuration;

public class TestSelenium implements IAbstractTest {

    @BeforeClass
    public void setUpClass() {
        System.out.println("=== @BeforeClass: Initializing test resources ===");

    }

    @Test(priority = 1)
    @MethodOwner(owner = "vladislav.karastan")
    @TestLabel(name = "header", value = { "web", "regression" })
    public void testHeader() {
        System.out.println("=== Checking Selenium header ===");
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();

        String headerText = homePage.getHeaderText();
        System.out.println("Header text: " + headerText);

        Assert.assertTrue(headerText.contains("Selenium"), "Header should contain 'Selenium'");
        driver.quit();
    }

    @Test(priority = 2)
    @MethodOwner(owner = "vladislav.karastan")
    @TestLabel(name = "button", value = { "web", "regression" })
    public void testReadMoreBtn() {
        System.out.println("=== Checking Selenium WebDriver Button===");
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();

        homePage.clickReadMore();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("documentation/webdriver"), "Should navigate to WebDriver documentation");
        driver.quit();
    }

    @Test(priority = 3, enabled = false)
    @MethodOwner(owner = "vladislav.karastan")
    @TestLabel(name = "footer", value = { "web", "regression" })
    public void testScrollToFooter() {
        System.out.println("=== Testing Scrooling to Footer===");
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();

        homePage.scrollToAboutSelenium();
        Assert.assertTrue(homePage.isAboutSeleniumVisible(), "'About Selenium' link should be visible after scroll");
        driver.quit();
    }

    @Test(priority = 4)
    @MethodOwner(owner = "vladislav.karastan")
    @TestLabel(name = "search", value = { "web", "regression" })
    public void testSearchInput() {
        System.out.println("=== Testing Search Input ===");
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();

        homePage.clickNavigationBtn();
        homePage.searchAndSelectSeleniumIDE();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("documentation/ide/"), "Should navigate to Selenium IDE page");
        driver.quit();
    }

    @Test(priority = 5)
    @MethodOwner(owner = "vladislav.karastan")
    @TestLabel(name = "download", value = { "web", "regression" })
    public void testDownloadsLink() {
        System.out.println("=== Testing Downloads Link ===");
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();

        homePage.clickNavigationBtn();
        homePage.clickDownloadsLink();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/downloads/"), "Should navigate to downloads page");
        driver.quit();
    }
}
