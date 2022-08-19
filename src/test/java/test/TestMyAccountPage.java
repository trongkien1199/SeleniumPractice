package test;

import data.Data;
import drivers.DriverBase;
import model.pages.AccountPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
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
        accountPage.login(Data.USER_NAME, Data.PASSWORD);
        //Check if the navigation list is displayed
        Assert.assertTrue(myAccountPage.navigationLinkListIsDisplayed());
    }
    @Test
    public void myAccountDashboard(){
        //Check if there is welcome and dashboard content text
        Assert.assertEquals(myAccountPage.getWelcomeText(), Data.WELCOME_TEXT);
        Assert.assertEquals(myAccountPage.getDashboardContentText(), Data.DASHBOARD_CONTENT_TEXT);
    }
    @Test
    public void MyAccountOrders(){
        // go to My account details tab
        myAccountPage.goToAccountDetails();
        // go to order tab
        myAccountPage.goToOrders();
        //Check URL is right
        Assert.assertEquals(automation.getCurrentURL(), Data.ORDERS_SITE);
       //CHeck If the message info is right
        Assert.assertTrue(myAccountPage.getMessageInfoText().contains(Data.ORDERS_SITE_MES_INFO));
    }

    @AfterMethod (alwaysRun = true)
    public void logout(){
        try{
            if(myAccountPage.navigationLinkListIsDisplayed()){
            myAccountPage.goToDashboard();
            myAccountPage.logoutAccount();
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
