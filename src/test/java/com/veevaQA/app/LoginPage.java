package com.veevaQA.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    protected WebDriver driver;

    private By usernameBy = By.id("Username");
    private By passwordBy = By.id("Password");
    private By loginBy = By.id("login");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage loginValidUser(String username, String password) {
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginBy).click();
        return new HomePage(driver);
    }
}
