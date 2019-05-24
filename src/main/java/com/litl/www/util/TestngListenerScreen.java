package com.litl.www.util;

import com.litl.www.testcase.LoginCase;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.*;

public class TestngListenerScreen extends TestListenerAdapter {
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        super.onTestSuccess(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        super.onTestFailure(iTestResult);
        takeScreenShot(iTestResult);
    }

    private void takeScreenShot(ITestResult iTestResult) {
        LoginCase instance = (LoginCase) iTestResult.getInstance();
        instance.driver.takeScreenShot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        super.onTestSkipped(iTestResult);
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        super.onStart(iTestContext);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        super.onFinish(iTestContext);
        ArrayList<ITestResult> testsToBeRemoved = new ArrayList<>();

        Set<Integer> passedTestIds = new HashSet<Integer>();
        for (ITestResult passedtTest : iTestContext.getPassedTests().getAllResults()) {
            passedTestIds.add(getId(passedtTest));
        }

        Set<Integer> failedTestIds = new HashSet<Integer>();
        for (ITestResult failedTest : iTestContext.getPassedTests().getAllResults()) {
            int failedTestId = getId(failedTest);
            if (failedTestIds.contains(failedTestId) || passedTestIds.contains(failedTestId)) {
                testsToBeRemoved.add(failedTest);
            } else {
                failedTestIds.add(failedTestId);
            }
        }

        for (Iterator<ITestResult> iterator = iTestContext.getFailedTests().getAllResults().iterator(); iterator.hasNext(); ) {
            ITestResult result = iterator.next();
            if (testsToBeRemoved.contains(result)) {
                iterator.remove();
            }
        }
    }

    private Integer getId(ITestResult iTestResult) {
        int id = iTestResult.getName().hashCode();
        id = id + iTestResult.getMethod().getMethodName().hashCode();
        id = id + (iTestResult.getParameters() != null ? Arrays.hashCode(iTestResult.getParameters()) : 0);
        return id;
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        super.onTestStart(iTestResult);
    }
}
