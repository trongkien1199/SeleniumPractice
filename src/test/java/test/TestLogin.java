package test;

import data.Data;
import drivers.DriverBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin extends DriverBase {
    @BeforeMethod(alwaysRun = true)
    public void goToAccountPage()   {
        accountPage.goToAccountPageByClickMenuItem();
        //Check if right URL
        Assert.assertEquals(accountPage.getMyAccountPageUrl(), Data.ACCOUNT_SITE);
        //Check if the My account is highlighted
        Assert.assertTrue(accountPage.getColorMyAccountMenuItem().matches(Data.HIGHLIGHTED_MENU_ITEM_COLOR));
    }
    @Test(priority = 0)
    public void checkIfPasswordIsMasked()   {
        accountPage.enterPassword(Data.PASSWORD);
        //Check if the password is masked
        Assert.assertTrue(accountPage.checkPasswordIsMasked());
    }
    @Test(priority = 0)
    public void loginWithEmptyUserAndPassword()   {
        accountPage.login("","");
        //Check error message
        Assert.assertEquals(accountPage.getErrorMessage(), Data.EMPTY_USERNAME_ERROR_MES);
    }
    @Test(priority = 1)
    public void loginWithEmptyPassword()   {
        accountPage.login(Data.USER_NAME,"");
        //Check error message
        Assert.assertEquals(accountPage.getErrorMessage(), Data.EMPTY_PASS_ERROR_MES);
    }
    @Test(priority = 2)
    public void loginWithEmptyUser()   {
        accountPage.login("", Data.PASSWORD);
        //Check error message
        Assert.assertEquals(accountPage.getErrorMessage(), Data.EMPTY_USERNAME_ERROR_MES);
    }
    @Test(priority = 3)
    public void loginWithInvalidAccount()   {
        accountPage.login(Data.USER_NAME, Data.WRONG_PASSWORD);
        //Check error massage
        Assert.assertEquals(accountPage.getErrorMessage(), Data.WRONG_PASSWORD_ERR_MES);
    }
    @Test(priority = 4)
    public void loginWithNonExistAccount()   {
        accountPage.login(Data.WRONG_USERNAME, Data.WRONG_PASSWORD);
        //Check error massage
        Assert.assertEquals(accountPage.getErrorMessage(), Data.NON_EXIST_USERNAME_ERR_MES);
    }
    @Test(priority = 5)
    public void loginWithValidAccount()   {
        accountPage.login(Data.USER_NAME, Data.PASSWORD);
        //check if the nav list is displayed
        Assert.assertTrue(myAccountPage.navigationLinkListIsDisplayed());
        myAccountPage.logoutAccount();
    }
    @Test(priority = 6)
    public void loginAuthentication()   {
        accountPage.login(Data.USER_NAME, Data.PASSWORD);
        //check if the nav list is displayed
        Assert.assertTrue(myAccountPage.navigationLinkListIsDisplayed());
        //logout from homepage
        myAccountPage.logoutAccount();
        //Press back
        driver.navigate().back();
        // Check if login and register form is display
        Assert.assertTrue(accountPage.checkIfLoginFormPresent());
        Assert.assertTrue(accountPage.checkIfRegisterFormPresent());
    }
}
