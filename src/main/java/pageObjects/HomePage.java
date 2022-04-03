package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.CommonLibrary;

public class HomePage  {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "")
    public WebElement searchField;

    @FindBy (xpath = "")
    public WebElement myAccountLink;

    @FindBy (xpath = "")
    public WebElement flagContainer;

    @FindBy (id = "onetrust-accept-btn-handler")
    public WebElement cookieButton;

    public void searchAnItem(String keyword) {
        searchField.sendKeys(keyword);
    }

    public void clickMyAccountLink() {
        myAccountLink.click();
    }

    public void selectCountry() {
        flagContainer.click();
    }

    public void clickOnCookie() {
        cookieButton.click();
    }

}
