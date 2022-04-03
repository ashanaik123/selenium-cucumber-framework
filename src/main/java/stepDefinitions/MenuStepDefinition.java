package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import utility.CommonLibrary;

import java.io.FileNotFoundException;
import java.time.Duration;

public class MenuStepDefinition extends CommonLibrary {

    HomePage homePage = new HomePage(driver);

    @Given("I'm on the home page {string}")
    public void i_m_on_the_home_page(String url) throws Exception {
    driver.get(getProperties("url"));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    String expectedUrl = getProperties("url");
        System.out.println("Url from properties file : "+ expectedUrl);
    String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
       homePage.clickOnCookie();
    }
    @When("I hover over on the menu option {string}")
    public void i_hover_over_on_the_menu_option(String menuText) {
    WebElement menu = driver.findElement(By.xpath("//span[text() ='" + menuText + "']"));
        Actions mouseHover = new Actions(driver);
        mouseHover.moveToElement(menu).build().perform();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOf(menu));
    }
    @When("click the link {string}")
    public void click_the_link(String menuText) throws Exception {
        WebElement menu = driver.findElement(By.xpath("//span[text() ='" + menuText + "']"));
        menu.click();
        String fileName = "/"+ menuText +".png";
        takeScreenShots(fileName);
    }
    @Then("I should navigate to the women screen {string}")
    public void i_should_navigate_to_the_women_screen(String pageTitle)  {

        String actualTitle = driver.getTitle();
        String expectedTitle = pageTitle;

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
}
