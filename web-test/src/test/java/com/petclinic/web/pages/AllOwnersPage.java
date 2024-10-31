package com.petclinic.web.pages;

import com.petclinic.web.components.NavBarComponent;

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

    public boolean isVisible(){
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
}
