package data;

import java.io.FilterOutputStream;
import java.util.Random;

public class Data {
    public static final String _SITE = "https://practice.automationtesting.in/";
    public static final String ACCOUNT_SITE = "https://practice.automationtesting.in/my-account/";
    public static final String ACCOUNT_SITE_TITLE = "My Account – Automation Practice Site";
    public static final String ORDERS_SITE = "https://practice.automationtesting.in/my-account/orders/";
    public static final String ORDERS_SITE_MES_INFO = "No order has been made yet.";
    private static Random random = new Random();
    static int  num = random.nextInt(3000);
    public static final String RIGHT_REG_EMAIL = "kientest"+ num +"@gmail.com";
    public static final String INVALID_REG_EMAIL="trongkien1@gmail.com";
    public static final String INVALID_REG_EMAIL_ERROR_MES = "Error: An account is already registered with your email address. Please login.";
    public static final String USER_NAME = "kientest04@gmail.com";
    public static final String WRONG_USERNAME = "trongkienABCNTA@gmail.com";
    public static final String PASSWORD = "Kien123!@#ASDCASD";
    public static final String WRONG_PASSWORD= "klajdkljadjklasd";
    public static final String EMPTY_USERNAME_ERROR_MES = "Error: Username is required.";
    public static final String EMPTY_PASS_ERROR_MES = "Error: Password is required.";
    public static final String WRONG_PASSWORD_ERR_MES = "Error: the password you entered for the username "+USER_NAME+ " is incorrect. Lost your password?";
    public static final String WELCOME_USERNAME=substringText("@",USER_NAME);
    public static final String WELCOME_TEXT = "Hello "+WELCOME_USERNAME+" (not "+WELCOME_USERNAME+"? Sign out)";
    public static final String DASHBOARD_CONTENT_TEXT="From your account dashboard you can view your recent orders, manage your shipping and billing addresses and edit your password and account details.";
    public static final String NON_EXIST_USERNAME_ERR_MES = "Error: A user could not be found with this email address.";
    public static final String EMPTY_REG_EMAIL_MES_ERR= "Error: Please provide a valid email address.";
    public static final String EMPTY_REG_PASSWORD_MES_ERR= "Error: Please enter an account password.";
    public static String HIGHLIGHTED_MENU_ITEM_COLOR = "rgb(a)?\\(237, 30, 36(, 1)?\\)";

    public static String substringText(String charater, String text ){
        String expectedString;
        try{
            expectedString = text.substring(0, text.indexOf(charater));
        }catch (Exception e){
            expectedString = text;
        }
        return expectedString;
    }
}
