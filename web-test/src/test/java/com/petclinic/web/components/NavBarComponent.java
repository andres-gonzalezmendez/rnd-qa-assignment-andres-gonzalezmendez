package com.petclinic.web.components;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavBarComponent {

    public WebDriver driver;

    public NavBarComponent(WebDriver driver) {
        this.driver = driver;

        if (!isNavBarVisible()) {
            throw new IllegalStateException("Navigation bar is not visible.");
        }
    }

    public boolean isNavBarVisible() {
        WebElement navBar = driver.findElement(By.id("main-navbar"));
        return navBar.isDisplayed();
    }

    public boolean isHomeTabSelected() {
        return isTabSelected("Home");
    }

    public boolean isOwnersTabSelected() {
        return isTabSelected("Owners");
    }

    public boolean isVetsTabSelected() {
        return isTabSelected("Veterinarians");
    }

    public void selectHomeTab() {
        WebElement homeTab = driver.findElement(By.xpath("//a[@ui-sref='welcome']"));
        homeTab.click();
    }

    public void selectOwnersTab() {
        WebElement ownersTab = driver
                .findElement(By.xpath("//a[contains(@class, 'dropdown-toggle') and @href='javascript:void(0)']"));
        ownersTab.click();
    }

    public void selectAllOwners() {
        WebElement allOwnersItem = driver.findElement(By.xpath("//a[@ui-sref='owners']"));
        allOwnersItem.click();
    }

    public void selectRegisterOwner() {
        WebElement registerOwnerItem = driver.findElement(By.xpath("//a[@ui-sref='ownerNew']"));
        registerOwnerItem.click();
    }

    public void selectVetsTab() {
        WebElement vetsTab = driver.findElement(By.xpath("//a[@ui-sref='vets']"));
        vetsTab.click();
    }

    private boolean isTabSelected(String tabName) {
        try {
            WebElement tab = driver.findElement(By.linkText(tabName));
            return tab.getAttribute("class").contains("active");
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
