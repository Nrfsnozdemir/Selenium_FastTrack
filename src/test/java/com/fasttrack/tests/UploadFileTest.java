package com.fasttrack.tests;

import com.fasttrack.pages.UploadFilePage;
import com.fasttrack.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFileTest {

    @Test
    public void uploadFileTest(){
        Driver.getDriver().get("https://practice.cydeo.com/upload");

        UploadFilePage uploadFilePage = new UploadFilePage();

        uploadFilePage.chooseFileBtn.sendKeys("/Users/aysun/Downloads/some-file.txt");

        uploadFilePage.uploadBtn.click();

        Assert.assertEquals(uploadFilePage.headerText.getText(),"File Uploaded!");

    }
}
