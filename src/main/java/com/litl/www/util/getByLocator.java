package com.litl.www.util;

import org.openqa.selenium.By;

public class getByLocator {
    public static By getByLocator(String key) {
        ProUtil prop = new ProUtil("src/element.properties");
        String locator = prop.getPro(key);
        String locatorKey = locator.split(">")[0];
        String locatorValue = locator.split(">")[1];

        if (locatorKey.equals("id")) {
            return By.id(locatorValue);
        } else if (locatorKey.equals("name")) {
            return By.name(locatorValue);
        } else if (locatorKey.equals("className")) {
            return By.className(locatorValue);
        } else if (locatorKey.equals("cssSelector")) {
            return By.cssSelector(locatorValue);
        } else if (locatorKey.equals("tagName")) {
            return By.tagName(locatorValue);
        } else if (locatorKey.equals("linkText")) {
            return By.linkText(locatorValue);
        } else {
            return By.xpath(locatorValue);
        }

    }
}
