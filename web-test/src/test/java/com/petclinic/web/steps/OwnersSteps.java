package com.petclinic.web.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;
import com.petclinic.web.components.NavBarComponent;
import com.petclinic.web.pages.AllOwnersPage;
import com.petclinic.web.pages.HomePage;
import com.petclinic.web.pages.NewOwnerPage;

import io.cucumber.java.en.*;

public class OwnersSteps {

    public WebDriver driver;
    public Faker faker;
    public HomePage homePage;
    public NavBarComponent navBar;
    public AllOwnersPage allOwnersPage;
    public NewOwnerPage newOwnerPage;
    private String newOwnerFirstName;
    private String newOwnerLastName;
    private String newOwnerAddress;
    private String newOwnerCity;
    private String newOwnerTelephone;

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
        if (option.equals("All")) {
            this.navBar.selectAllOwners();
            this.allOwnersPage = new AllOwnersPage(this.driver);
            Assert.assertTrue(this.allOwnersPage.isVisible());
        } else if (option.equals("Register")) {
            this.navBar.selectRegisterOwner();
            this.newOwnerPage = new NewOwnerPage(this.driver);
            Assert.assertTrue(this.newOwnerPage.isVisible());
        }
    }

    @Then("List of all owners is presented")
    public void listOfAllOwnersIsPresented() {
        Assert.assertTrue(this.allOwnersPage.isOwnersTableVisible());
    }

    @When("User enters values for all fields")
    public void userEntersValuesForAllFields() {
        this.faker = new Faker();
        this.newOwnerFirstName = faker.name().firstName();
        this.newOwnerLastName = faker.name().lastName();
        this.newOwnerAddress = faker.address().streetAddress();
        this.newOwnerCity = faker.address().cityName();
        this.newOwnerTelephone = "6" + faker.number().digits(9).toString();

        this.newOwnerPage.enterFirstName(newOwnerFirstName);
        this.newOwnerPage.enterLastName(newOwnerLastName);
        this.newOwnerPage.enterAddress(newOwnerAddress);
        this.newOwnerPage.enterCity(newOwnerCity);
        this.newOwnerPage.enterTelephone(newOwnerTelephone);
    }

    @When("User selects {string} button")
    public void userSelectsButton(String button) {
        if (button.equals("Submit")) {
            this.newOwnerPage.submitForm();
            this.allOwnersPage = new AllOwnersPage(this.driver);
            this.allOwnersPage.isVisible();
        }
    }

    @Then("New owner is in the list")
    public void newOwnerIsInTheList() {
        Assert.assertTrue(this.allOwnersPage.isOwnerVisible(this.newOwnerFirstName, this.newOwnerLastName, this.newOwnerAddress, this.newOwnerCity, this.newOwnerTelephone));
    }

    @Then("User closes browser")
    public void user_closes_browser() {
        if (this.driver != null) {
            driver.quit();
        }
    }
}
