package com.litl.www.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class DriverBase {

    public WebDriver driver;

    public DriverBase(String browser) {
        SelectDriver selectDriver = new SelectDriver();
        this.driver = selectDriver.driverName(browser);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quit() {
        driver.quit();
    }

    public WebElement findElement(By by) {
        WebElement element = driver.findElement(by);
        return element;
    }

    public List<WebElement> findElements(By by) {
        List<WebElement> elements = driver.findElements(by);
        return elements;
    }

    public void takeScreenShot() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String dateStr = sdf.format(date);
        String path = this.getClass().getSimpleName() + "_" + dateStr + ".png";
        takeScreenShot((TakesScreenshot) this.getDriver(), path);
    }

    private void takeScreenShot(TakesScreenshot driverName, String path) {
        String currentPath = System.getProperty("user.dir");
        File scrFile = driverName.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(currentPath + "\\" + path));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("截图成功");
        }
    }

    public void get(String url) {
        driver.get(url);
    }

    public void back() {
        driver.navigate().back();
    }

    public void click(WebElement element) {
        element.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void close() {
        driver.close();
    }

    public List<String> getWindowsHandles() {
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> handles = new ArrayList<>(windowHandles);
        return handles;
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public void switchWindows(String name) {
        driver.switchTo().window(name);
    }

    public void switchIframe(WebElement iframe) {
        driver.switchTo().frame(iframe);
    }

    public void switchAlert() {
        driver.switchTo().alert();
    }

    public void switchToMode() {
        driver.switchTo().activeElement();
    }

    public void action(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element);
    }

    public Set<Cookie> getCookie() {
        return driver.manage().getCookies();
    }

    public void deleteCookie() {
        driver.manage().deleteAllCookies();
    }

    public void addCookie(Cookie cookie) {
        driver.manage().addCookie(cookie);
    }

    public void getMaxSize() {
        driver.manage().window().maximize();
    }

    public void implicitlyWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void switchDefaultIframe() {
        driver.switchTo().defaultContent();
    }

    public void swtichParentFrame() {
        driver.switchTo().parentFrame();
    }
}
