package com.solvd.project;

import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private final String url = "https://selenium.dev";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
