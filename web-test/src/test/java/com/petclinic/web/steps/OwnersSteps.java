package com.petclinic.web.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.petclinic.web.components.NavBarComponent;
import com.petclinic.web.pages.AllOwnersPage;
import com.petclinic.web.pages.HomePage;

import io.cucumber.java.en.*;

public class OwnersSteps {

    public WebDriver driver;
    public HomePage homePage;
    public NavBarComponent navBar;
    public AllOwnersPage allOwnersPage;

    @Given("User launches browser")
    public void userLaunchesBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    @When("User opens URL {string}")
    public void userOpensURL(String url) {
        this.driver.get(url);
        this.homePage = new HomePage(this.driver);
        this.navBar = homePage.getNavBar();
    }

    @When("User selects {string} tab in top menu")
    public void userSelectsTabInTopMenu(String tab) {
        if (tab.equals("Owners"))
            this.navBar.selectOwnersTab();
    }

    @When("User selects {string} option in dropdown menu")
    public void userSelectsOptionInDropdownMenu(String option) {
        if (option.equals("All"))
            this.navBar.selectAllOwners();
    }

    @Then("List of all owners is presented")
    public void list_of_all_owners_is_presented() {
        this.allOwnersPage = new AllOwnersPage(this.driver);
        Assert.assertTrue(this.allOwnersPage.isOwnersTableVisible());
    }
    @Then("User closes browser")
    public void user_closes_browser() {
        if (this.driver != null) {
            driver.quit();
        }
    }
}
