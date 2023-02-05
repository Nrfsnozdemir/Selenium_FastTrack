package com.fasttrack.tests;

import com.fasttrack.pages.ExplicitWaitPracticePage;
import com.fasttrack.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplicitWaitTest {

    ExplicitWaitPracticePage explicitWaitPracticePage = new ExplicitWaitPracticePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);

    @Test
    public void dynamicLoad1(){
        //TC#1
        //1. Go to http://practice.cydeo.com/dynamic_loading/1
        Driver.getDriver().get("http://practice.cydeo.com/dynamic_loading/1");

        //2. Click to start
        explicitWaitPracticePage.startBtn.click();

        //3. Wait until loading bar disappears
        wait.until(ExpectedConditions.visibilityOf(explicitWaitPracticePage.userName));

        //4. Assert username inputbox is displayed
        Assert.assertTrue(explicitWaitPracticePage.userName.isDisplayed());

        //5. Enter username: tomsmith
        explicitWaitPracticePage.userName.sendKeys("tomsmith");

        //6. Enter password: incorrectpassword
        explicitWaitPracticePage.password.sendKeys("incorrectpassword");

        //7. Click to Submit button
        explicitWaitPracticePage.submitBtn.click();

        //8. Assert “Your password is invalid!” text is displayed.
        Assert.assertTrue(explicitWaitPracticePage.resultText.isDisplayed());
    }

    @Test
    public void dynamicLoad7(){
        //TC#2
        //1. Go to http://practice.cydeo.com/dynamic_loading/7
        Driver.getDriver().get("http://practice.cydeo.com/dynamic_loading/7");

        //2. Wait until title is “Dynamic title”
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        //3. Assert : Message “Done” is displayed.
        Assert.assertTrue(explicitWaitPracticePage.doneMsg.isDisplayed());

        //4. Assert : Image is displayed.
        Assert.assertTrue(explicitWaitPracticePage.image.isDisplayed());

    }
}
