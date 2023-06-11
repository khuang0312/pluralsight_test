package com.veevaQA.app;

import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    protected WebDriver driver;

    private By sectionHeaderContainer = By.className("XXZwpOcbrFZ717ads5m+bQ==");

    // why there's a period in the CSS class name
    // https://stackoverflow.com/questions/32043877/compound-class-names-not-permitted-error-webdriver
    private By sectionHeader = By.className(".JIXt8mwHozuiPTDdXioD0g==.pd-carousel-title");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String[] getSectionHeaders() {
        ArrayList<String> sectionHeadersFound = new ArrayList<String>();

        // was trying to set up an wait to allow time to verify cloudflare
        WebElement sections = new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(driver -> driver.findElement(sectionHeaderContainer));

        sections.findElements(sectionHeader)
                .forEach(sectionHeader -> sectionHeadersFound.add(sectionHeader.getText()));

        return (String[]) sectionHeadersFound.toArray();
    }
}
