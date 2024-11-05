package com.petclinic.web.pages;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.petclinic.web.components.NavBarComponent;

public class NewPetPage {
    private WebDriver driver;
    private NavBarComponent navBar;

    public NewPetPage(WebDriver driver) {
        this.driver = driver;
        this.navBar = new NavBarComponent(this.driver);

        if (!isVisible()) {
            throw new IllegalStateException("New Pet page is not visible.");
        }
    }

    public boolean isVisible() {
        return isPetFormTitleDisplayed() && isPetFormVisible();
    }

    public NavBarComponent getNavBar() {
        return this.navBar;
    }

    public boolean isPetFormTitleDisplayed() {
        try {
            WebElement pageTitle = driver.findElement(By.tagName("h2"));
            return pageTitle.getText().equals("Pet");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isPetFormVisible() {
        try {
            WebElement form = driver.findElement(By.tagName("form"));
            return form.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getOwnerName() {
        try {
            return driver.findElement(By.xpath("//p[@class='form-control-static ng-binding']")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void setPetName(String name) {
        WebElement nameInput = driver.findElement(By.name("name"));
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void setPetBirthDate(String birthDate) {
        WebElement birthDateInput = driver.findElement(By.xpath("//input[@type='date']"));
        birthDateInput.clear();
        birthDateInput.sendKeys(birthDate);
    }

    public void selectPetType(String petType) {
        WebElement petTypeSelect = driver.findElement(By.xpath("//select[@ng-model='$ctrl.petTypeId']"));
        petTypeSelect.click();
        petTypeSelect.findElement(By.xpath("//option[text()='" + petType + "']")).click();
    }

    public void selectRandomPetType() {
        List<String> availablePetTypes = getAllPetTypes();

        if (availablePetTypes.isEmpty()) {
            throw new IllegalStateException("No pet types available to select.");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(availablePetTypes.size());

        String randomPetType = availablePetTypes.get(randomIndex);
        selectPetType(randomPetType);
    }

    public List<String> getAllPetTypes() {
        WebElement petTypeSelect = driver.findElement(By.xpath("//select[@ng-model='$ctrl.petTypeId']"));
        petTypeSelect.click();

        List<WebElement> options = petTypeSelect.findElements(By.tagName("option"));
        return options.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void submitForm() {
        try {
            WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
            submitButton.click();
        } catch (NoSuchElementException e) {
            System.err.println("Submit button not found.");
        }
    }
}