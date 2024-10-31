package com.petclinic.web.pages;

import com.petclinic.web.components.NavBarComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewOwnerPage {
    private WebDriver driver;
    private NavBarComponent navBar;

    public NewOwnerPage(WebDriver driver) {
        this.driver = driver;
        this.navBar = new NavBarComponent(this.driver);

        if (!isVisible()) {
            throw new IllegalStateException("New owner page is not visible.");
        }
    }

    public boolean isVisible(){
        return isOwnerTitleDisplayed() && isNewOwnerFormVisible();
    }

    public NavBarComponent getNavBar() {
        return this.navBar;
    }

    public boolean isOwnerTitleDisplayed() {
        try {
            WebElement pageTitle = driver.findElement(By.tagName("h2"));
            return pageTitle.getText().equals("Owner");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isNewOwnerFormVisible() {
        try {
            WebElement ownerForm = driver.findElement(By.cssSelector("owner-form form"));
            return ownerForm.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void enterFirstName(String firstName) {
        WebElement firstNameField = driver.findElement(By.cssSelector("input[name='firstName']"));
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement lastNameField = driver.findElement(By.cssSelector("input[name='lastName']"));
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void enterAddress(String address) {
        WebElement addressField = driver.findElement(By.cssSelector("input[name='address']"));
        addressField.clear();
        addressField.sendKeys(address);
    }

    public void enterCity(String city) {
        WebElement cityField = driver.findElement(By.cssSelector("input[name='city']"));
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void enterTelephone(String telephone) {
        WebElement telephoneField = driver.findElement(By.cssSelector("input[name='telephone']"));
        telephoneField.clear();
        telephoneField.sendKeys(telephone);
    }

    public void submitForm() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }

}
