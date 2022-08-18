package test;

import data.Data;
import drivers.DriverBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin extends DriverBase {
    @BeforeMethod(alwaysRun = true)
    public void goToAccountPage() throws InterruptedException {
        accountPage.goToAccountPageByClickMenuItem();
        //Check if right URL
        Assert.assertEquals(accountPage.getMyAccountPageUrl(), Data.ACCOUNT_SITE);
        //Check if the My account is highlighted
        Assert.assertTrue(accountPage.getColorMyAccountMenuItem().matches(Data.HIGHLIGHTED_MENU_ITEM_COLOR));
    }
    @Test(priority = 0)
    public void checkIfPasswordIsMasked() throws InterruptedException {
        accountPage.enterPassword(Data.PASSWORD);
        //Check if the password is masked
        Assert.assertTrue(accountPage.checkPasswordIsMasked());
    }
    @Test(priority = 0)
    public void loginWithEmptyUserAndPassword() throws InterruptedException {
        accountPage.login("","");
        //Check error message
        Assert.assertEquals(accountPage.getErrorMessage(), Data.EMPTY_USERNAME_ERROR_MES);
    }
    @Test(priority = 1)
    public void loginWithEmptyPassword() throws InterruptedException {
        accountPage.login(Data.USER_NAME,"");
        //Check error message
        Assert.assertEquals(accountPage.getErrorMessage(), Data.EMPTY_PASS_ERROR_MES);
    }
    @Test(priority = 2)
    public void loginWithEmptyUser() throws InterruptedException {
        accountPage.login("", Data.PASSWORD);
        //Check error message
        Assert.assertEquals(accountPage.getErrorMessage(), Data.EMPTY_USERNAME_ERROR_MES);
    }
    @Test(priority = 3)
    public void loginWithInvalidAccount() throws InterruptedException {
        accountPage.login(Data.USER_NAME, Data.WRONG_PASSWORD);
        //Check error massage
        Assert.assertEquals(accountPage.getErrorMessage(), Data.WRONG_PASSWORD_ERR_MES);
    }
    @Test(priority = 4)
    public void loginWithNonExistAccount() throws InterruptedException {
        accountPage.login(Data.WRONG_USERNAME, Data.WRONG_PASSWORD);
        //Check error massage
        Assert.assertEquals(accountPage.getErrorMessage(), Data.NON_EXIST_USERNAME_ERR_MES);
    }
    @Test(priority = 5)
    public void loginWithValidAccount() throws InterruptedException {
        accountPage.login(Data.USER_NAME, Data.PASSWORD);
        //check if the nav list is displayed
        Assert.assertTrue(homePage.navigationLinkListIsDisplayed());
        homePage.logoutAccount();
    }
    @Test(priority = 6)
    public void loginAuthentication() throws InterruptedException {
        accountPage.login(Data.USER_NAME, Data.PASSWORD);
        //check if the nav list is displayed
        Assert.assertTrue(homePage.navigationLinkListIsDisplayed());
        //logout from homepage
        homePage.logoutAccount();
        // Check if the nav list not displayed anymore
        Assert.assertFalse(homePage.navigationLinkListIsDisplayed());
    }
}
