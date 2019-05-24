package com.litl.www.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestngRetry implements IRetryAnalyzer {
    private static int maxRetryCount = 3;
    private int retryCount = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (maxRetryCount >= retryCount) {
            String message = "Running retry for '" + iTestResult.getName() + "' on class " + this.getClass().getName() + " Retrying " + retryCount + " times";
            Reporter.setCurrentTestResult(iTestResult);
            Reporter.log("RunCount=" + (retryCount + 1));
            retryCount++;
            return true;
        }
        return false;
    }
}
