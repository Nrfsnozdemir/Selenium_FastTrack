package com.fasttrack.tests;

import com.fasttrack.pages.JavaFakerPage;
import com.fasttrack.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaFakerTest {

    JavaFakerPage javaFakerPage = new JavaFakerPage();

    @Test
    public void javaFakerTest(){
        //1- Open a chrome browser
        //2- Go to:http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //3- Login
        javaFakerPage.username.sendKeys("Tester");
        javaFakerPage.password.sendKeys("test");
        javaFakerPage.loginBtn.click();

        //4. Click on Order
        javaFakerPage.OrderBtn.click();

        //5. Select familyAlbum from product, set quantity to 5
        Select select = new Select(javaFakerPage.dropdown);
        select.selectByVisibleText("FamilyAlbum");

        javaFakerPage.quantity.sendKeys("5");

        //6. Click to "Calculate" button
        javaFakerPage.CalculateBtn.click();

        //7. Fill address Info with JavaFaker
        Faker faker = new Faker();
        javaFakerPage.customerName.sendKeys(faker.name().firstName());
        javaFakerPage.street.sendKeys(faker.address().streetName());
        javaFakerPage.city.sendKeys(faker.address().city());
        javaFakerPage.zip.sendKeys(faker.address().zipCode().replace("-",""));

        //8. Click on "visa" radio button
        javaFakerPage.visaBtn.click();

        //9. Generate card number using JavaFaker
        javaFakerPage.cardNo.sendKeys(faker.business().creditCardNumber().replace("-",""));

        //10Enter expiration date
        javaFakerPage.expDate.sendKeys(faker.business().creditCardExpiry().substring(0,2) + "/"
                                         + faker.business().creditCardExpiry().substring(2) );

        //11. Click on "Process"
        javaFakerPage.processBtn.click();

        //12.Verify success message "New order has been successfully added." is displayed.
        Assert.assertTrue(javaFakerPage.resultText.isDisplayed());

    }
}
