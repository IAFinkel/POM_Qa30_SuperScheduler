package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;

public class ListenerTestNg implements ITestListener {
    Logger logger = LoggerFactory.getLogger(ListenerTestNg.class);
    @Override

    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        logger.info("LTestNg: Start test getTestName-->"+result.getTestName());
        logger.info("LTestNg: Start test getStatus-->"+result.getStatus());
        logger.info("LTestNg: Start test getTestClass-->"+result.getTestClass());
        logger.info("LTestNg: Start test getName-->"+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        logger.info("LTestNg: Start test getTestName-->"+result.getTestName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        logger.info("LTestNg: Start test getTestName-->"+result.getTestName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
        logger.info("LTestNg: Error-->"+result.getThrowable().getMessage());
        logger.info("LTestNg: Error-->"+result.getThrowable().getStackTrace().toString());
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        logger.info("LTestNg: on Start-->"+context.getOutputDirectory());
        logger.info("LTestNg: on Start-->"+context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
