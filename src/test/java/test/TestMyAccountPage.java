package test;

import data.Data;
import drivers.DriverBase;
import model.pages.AccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestMyAccountPage extends DriverBase  {
    @BeforeMethod(alwaysRun = true)
    public void goToAccountPage()  {
        accountPage.goToAccountPageByClickMenuItem();
        //Check if right URL
        Assert.assertEquals(accountPage.getMyAccountPageUrl(), Data.ACCOUNT_SITE);
        //Check if the My account is highlighted
        Assert.assertTrue(accountPage.getColorMyAccountMenuItem().matches(Data.HIGHLIGHTED_MENU_ITEM_COLOR));
    }
    @Test
    public void myAccountDashboard(){
        //login
        accountPage.login(Data.USER_NAME, Data.PASSWORD);
        //Check if Navigation link list are present
    }


}
