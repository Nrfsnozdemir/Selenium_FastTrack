package com.fasttrack.pages;

import com.fasttrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    public GoogleSearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "q")
    public WebElement searchBox;


}
