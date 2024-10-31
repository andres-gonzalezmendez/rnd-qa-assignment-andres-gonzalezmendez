package com.petclinic.web.pages;

import com.petclinic.web.components.NavBarComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;
    private NavBarComponent navBar;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.navBar = new NavBarComponent(this.driver);

        if (!isWelcomeMessageDisplayed()) {
            throw new IllegalStateException("Home page is not visible.");
        }
    }

    public NavBarComponent getNavBar() {
        return this.navBar;
    }

    public boolean isWelcomeMessageDisplayed() {
        WebElement welcomeMessage = this.driver.findElement(By.xpath("//h1[text()='Welcome to Petclinic']"));
        return welcomeMessage.isDisplayed();
    }
}
