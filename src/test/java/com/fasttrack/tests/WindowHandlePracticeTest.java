package com.fasttrack.tests;

import com.fasttrack.pages.WindowHandlePracticePage;
import com.fasttrack.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandlePracticeTest {

    WindowHandlePracticePage windowHandlePracticePage = new WindowHandlePracticePage();

    @Test
    public void windowHandleTest(){

        //1. Go to website: http://practice.cydeo.com/windows
        Driver.getDriver().get("https://practice.cydeo.com/windows");

        String currentWindow = Driver.getDriver().getWindowHandle();

        System.out.println("currentWindow = " + currentWindow);

        //2. Assert: Title is “Windows”
        Assert.assertEquals(Driver.getDriver().getTitle(),"Windows");

        //3. Click to: “Click Here” link
        windowHandlePracticePage.clickHereLink.click();

        //4. Click to: “Cydeo” link
        windowHandlePracticePage.cydeoLink.click();

        Set<String> allWindowsHandle = Driver.getDriver().getWindowHandles();

        //5. Switch to Cydeo page
        for (String eachWindow : allWindowsHandle) {
            Driver.getDriver().switchTo().window(eachWindow);
            System.out.println("eachWindow = " + eachWindow);
            System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());

            if(Driver.getDriver().getTitle().equals("Cydeo")){
                break;
            }
        }

        //6. Assert: Title is “Cydeo”
        Assert.assertEquals(Driver.getDriver().getTitle(),"Cydeo");

        //7.Switch back to main handle
        Driver.getDriver().switchTo().window(currentWindow);
        Assert.assertEquals(Driver.getDriver().getTitle(),"Windows");

    }
}
