package com.petclinic.web.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.petclinic.web.components.NavBarComponent;

public class OwnerDetailsPage {
    private WebDriver driver;
    private NavBarComponent navBar;

    public OwnerDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.navBar = new NavBarComponent(this.driver);

        if (!isVisible()) {
            throw new IllegalStateException("Owner details page is not visible.");
        }
    }

    public boolean isVisible() {
        return isOwnerDetailsTitleDisplayed() && isOwnerInfoTableVisible();
    }

    public NavBarComponent getNavBar() {
        return this.navBar;
    }

    public boolean isOwnerDetailsTitleDisplayed() {
        try {
            WebElement pageTitle = driver.findElement(By.tagName("h2"));
            return pageTitle.getText().equals("Owner Information");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isOwnerInfoTableVisible() {
        try {
            WebElement infoTable = driver.findElement(By.xpath("//table[contains(@class, 'table') and contains(@class, 'table-striped')]"));
            return infoTable.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getOwnerName() {
        try {
            return driver.findElement(By.xpath("//table[contains(@class, 'table') and contains(@class, 'table-striped')]//td/b")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public String getOwnerAddress() {
        try {
            return driver.findElement(By.xpath("//table[contains(@class, 'table') and contains(@class, 'table-striped')]/tbody/tr[2]/td")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public String getOwnerCity() {
        try {
            return driver.findElement(By.xpath("//table[contains(@class, 'table') and contains(@class, 'table-striped')]/tbody/tr[3]/td")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public String getOwnerTelephone() {
        try {
            return driver.findElement(By.xpath("//table[contains(@class, 'table') and contains(@class, 'table-striped')]/tbody/tr[4]/td")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void clickEditOwner() {
        try {
            WebElement editButton = driver.findElement(By.xpath("//a[contains(@ui-sref, 'ownerEdit')]"));
            editButton.click();
        } catch (NoSuchElementException e) {
            System.err.println("Edit Owner button not found.");
        }
    }

    public void clickAddNewPet() {
        try {
            WebElement addPetButton = driver.findElement(By.xpath("//a[contains(@ui-sref, 'petNew')]"));
            addPetButton.click();
        } catch (NoSuchElementException e) {
            System.err.println("Add New Pet button not found.");
        }
    }

    public boolean isPetVisible(String name) {
        List<WebElement> petRows = driver.findElements(By.xpath("//table[contains(@class, 'table-striped')][2]/tbody/tr"));

        for (WebElement row : petRows) {
            String petName = row.findElement(By.xpath(".//dt[text()='Name']/following-sibling::dd/a")).getText();
            
            if (petName.equals(name)) {
                return true;
            }
        }
        return false;
    }
}