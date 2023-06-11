package com.veevaQA.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserWithAccountLoginStepDefinitions {
    static final String LOGIN_URL = "https://app.pluralsight.com/id";

    WebDriver driver;

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get(LOGIN_URL);
    }

    @When("I put my username and password")
    public void i_put_my_username_and_password() {
        assertEquals("https://app.pluralsight.com/id", driver.getCurrentUrl());
        assertEquals("Sign In | Pluralsight", driver.getTitle());

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginValidUser(System.getenv("PLURALSIGHT_USERNAME"),
                System.getenv("PLURALSIGHT_PASSWORD"));
    }

    @Then("I should be on the main page")
    public void i_should_be_on_the_main_page() {
        // Blocked by a Cloudflare authentication page.
        // While it might be possible to get past it...
        // I do not want to get IP banned from Pluralsight
        // This is a rough outline of how to do so

        // String[] sectionHeaders =
        // {"Continue Learning", "Trending for new learners", "Trending now on Pluralsight",
        // "Hands-on recommendations", "Personal channels", "Newest courses"};

        // HomePage homePage = new HomePage(driver);

        // assertEquals(sectionHeaders, homePage.getSectionHeaders());
        // assertEquals("Home | Pluralsight", driver.getTitle());
        // assertEquals("https://app.pluralsight.com/library/", driver.getCurrentUrl());
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
