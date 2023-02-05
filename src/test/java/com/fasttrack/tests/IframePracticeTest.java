package com.fasttrack.tests;

import com.fasttrack.pages.IframePracticePage;
import com.fasttrack.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframePracticeTest {

    IframePracticePage iframePracticePage = new IframePracticePage();

    @Test
    public void iframeTest(){

        //1. Go to website: http://practice.cydeo.com/iframe
        Driver.getDriver().get("https://practice.cydeo.com/iframe");

        Driver.getDriver().switchTo().frame(0);
        //Driver.getDriver().switchTo().frame("mce_0_ifr");
       // Driver.getDriver().switchTo().frame(iframePracticePage.iframe);

        //2. Assert: "Your content goes here." Text is displayed.
        String actualText = iframePracticePage.contentTextArea.getText();
        String expectedText = "Your content goes here.";
        Assert.assertEquals(actualText,expectedText);

        //4. switch back to default frame
        Driver.getDriver().switchTo().defaultContent();

        //3. Assert: "An iFrame containing the TinyMCE WYSIWYG Editor" Text is displayed.
        String actualHeader = iframePracticePage.headerText.getText();
        String expectedHeader = "An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actualHeader,expectedHeader);




    }
}
