package test;

import data.Data;
import drivers.DriverBase;
import model.pages.Navigate;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestRegister extends DriverBase {
    @BeforeMethod(alwaysRun = true)
    public void goToAccountPage()  {
        accountPage.goToAccountPageByClickMenuItem();
        //Check if right URL
        Assert.assertEquals(accountPage.getMyAccountPageUrl(),Data.ACCOUNT_SITE);
        //Check if the My account is highlighted
        Assert.assertTrue(accountPage.getColorMyAccountMenuItem().matches(Data.HIGHLIGHTED_MENU_ITEM_COLOR));
    }
    @Test(priority = 0)
    public void registerWithEmptyEmailAndPass()  {
        accountPage.register("","");
        //Check the error message
        Assert.assertEquals(accountPage.getErrorMessage(),Data.EMPTY_REG_EMAIL_MES_ERR);
    }
    @Test(priority = 1)
    public void registerWithEmptyEmail()  {
        accountPage.register("",Data.PASSWORD);
        //Check the error message
        Assert.assertEquals(accountPage.getErrorMessage(),Data.EMPTY_REG_EMAIL_MES_ERR);
    }
    @Test(priority = 2)
    public void registerWithEmptyPass()   {
        accountPage.register(Data.RIGHT_REG_EMAIL,"");
        //Check the error message
        Assert.assertEquals(accountPage.getErrorMessage(),Data.EMPTY_REG_PASSWORD_MES_ERR);
    }
    @Test (priority = 3)
    public void registerWithInvalidEmail()  {
        accountPage.register(Data.INVALID_REG_EMAIL, Data.PASSWORD);
        //Check the error message for INVALID REG EMAIL
        Assert.assertEquals(accountPage.getErrorMessage(), Data.INVALID_REG_EMAIL_ERROR_MES);

    }
    @Test(priority = 4)
    public void registerWithValidAccount()  {
        //register
        accountPage.register(Data.RIGHT_REG_EMAIL, Data.PASSWORD);
        //check if the nav list is displayed
        Assert.assertTrue(homePage.navigationLinkListIsDisplayed());
    }
}
