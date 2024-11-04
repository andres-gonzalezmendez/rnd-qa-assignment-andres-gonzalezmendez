package com.petclinic.web.pages;

import com.petclinic.web.components.NavBarComponent;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllOwnersPage {
    private WebDriver driver;
    private NavBarComponent navBar;

    public AllOwnersPage(WebDriver driver) {
        this.driver = driver;
        this.navBar = new NavBarComponent(this.driver);

        if (!isVisible()) {
            throw new IllegalStateException("All owners page is not visible.");
        }
    }

    public boolean isVisible() {
        return isOwnersTitleDisplayed() && isOwnersTableVisible();
    }

    public NavBarComponent getNavBar() {
        return this.navBar;
    }

    public boolean isOwnersTitleDisplayed() {
        try {
            WebElement pageTitle = driver.findElement(By.tagName("h2"));
            return pageTitle.getText().equals("Owners");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isOwnersTableVisible() {
        try {
            WebElement ownersTable = driver
                    .findElement(By.xpath("//table[contains(@class, 'table') and contains(@class, 'table-striped')]"));
            return ownersTable.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isOwnerVisible(String firstName, String lastName, String address, String city, String telephone) {
        WebElement ownerLink = findOwner(firstName, lastName, address, city, telephone);
        return ownerLink != null;
    }

    public void selectOwner(String firstName, String lastName, String address, String city, String telephone) {
        WebElement ownerLink = findOwner(firstName, lastName, address, city, telephone);
        if (ownerLink != null) {
            ownerLink.click();
        } else {
            System.err.println("Owner " + firstName + " " + lastName + " not found.");
        }
    }

    private WebElement findOwner(String firstName, String lastName, String address, String city, String telephone) {
        List<WebElement> ownerRows = driver.findElements(By.xpath("//table[contains(@class, 'table') and contains(@class, 'table-striped')]/tbody/tr"));

        for (WebElement row : ownerRows) {
            String ownerFullName = row.findElement(By.xpath(".//td[1]//a")).getText();
            String ownerAddress = row.findElement(By.xpath(".//td[2]")).getText();
            String ownerCity = row.findElement(By.xpath(".//td[3]")).getText();
            String ownerTelephone = row.findElement(By.xpath(".//td[4]")).getText();

            if (ownerFullName.equals(firstName + " " + lastName) &&
                ownerAddress.equals(address) &&
                ownerCity.equals(city) &&
                ownerTelephone.equals(telephone)) {
                return row.findElement(By.xpath(".//td[1]//a"));
            }
        }
        return null; // Return null if not found
    }
}
