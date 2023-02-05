package com.fasttrack.tests;

import com.fasttrack.pages.CheckBoxPage;
import com.fasttrack.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckBoxTest {

    CheckBoxPage checkBoxPage = new CheckBoxPage();

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("http://practice.cydeo.com/checkboxes");
    }
    @Test
    public void checkBoxButtonTest(){

        //TC #1:checkboxes
        //1. Go to http://practice.cydeo.com/checkboxes

        //2. Confirm checkbox #1 is NOT selected by default
        Assert.assertTrue(!checkBoxPage.checkBox1.isSelected());

        System.out.println("After hard assert fail");

        //3. Confirm checkbox #2 is SELECTED by default.
        Assert.assertTrue(checkBoxPage.checkBox2.isSelected());

        //4. Click checkbox #1 to select it.
        checkBoxPage.checkBox1.click();

        //5. Click checkbox #2 to deselect it.
        checkBoxPage.checkBox2.click();

        //6. Confirm checkbox #1 is SELECTED.
        Assert.assertTrue(checkBoxPage.checkBox1.isSelected());

        //7. Confirm checkbox #2 is NOT selected.
        Assert.assertTrue(!checkBoxPage.checkBox2.isSelected());
    }

    @Test
    public void checkBoxButtonTestSoftAssert(){

        SoftAssert softAssert = new SoftAssert();

        //2. Confirm checkbox #1 is NOT selected by default
        softAssert.assertTrue(checkBoxPage.checkBox1.isSelected());

        System.out.println("After soft assert fail");

        //3. Confirm checkbox #2 is SELECTED by default.
        softAssert.assertTrue(checkBoxPage.checkBox2.isSelected());

        //4. Click checkbox #1 to select it.
        checkBoxPage.checkBox1.click();

        //5. Click checkbox #2 to deselect it.
        checkBoxPage.checkBox2.click();

        //6. Confirm checkbox #1 is SELECTED.
        softAssert.assertTrue(checkBoxPage.checkBox1.isSelected());

        //7. Confirm checkbox #2 is NOT selected.
        softAssert.assertTrue(checkBoxPage.checkBox2.isSelected());

        System.out.println("After soft assert fail");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
