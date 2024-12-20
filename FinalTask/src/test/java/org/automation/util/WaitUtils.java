package org.automation.util;

import org.automation.driver.DriverSingleton;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static final WebDriver DRIVER = DriverSingleton.getDriver();
    private static final long DEFAULT_TIMEOUT = 20;

    public static WebElement waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DRIVER, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(DRIVER, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickability(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DRIVER, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickability(By locator) {
        WebDriverWait wait = new WebDriverWait(DRIVER, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForTextChange(By locator, String initialText) {
        WebDriverWait wait = new WebDriverWait(DRIVER, Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, initialText)));
    }
}