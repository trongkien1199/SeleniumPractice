package data;

import java.util.Random;

public class Data {
    public static final String _SITE = "https://practice.automationtesting.in/";
    public static final String ACCOUNT_SITE = "https://practice.automationtesting.in/my-account/";
    public static final String ACCOUNT_SITE_TITLE = "My Account – Automation Practice Site";
    private static Random random = new Random();
    static int  num = random.nextInt(3000);
    public static final String RIGHT_REG_EMAIL = "kientest"+ num +"@gmail.com";
    public static final String INVALID_REG_EMAIL="trongkien1@gmail.com";
    public static final String INVALID_REG_EMAIL_ERROR_MES = "Error: An account is already registered with your email address. Please login.";
    public static final String USER_NAME = "kientest01@gmail.com";
    public static final String PASSWORD = "Kien123!@#ASDCASD";
    public static final String EMPTY_REG_EMAIL_MES_ERR= "Error: Please provide a valid email address.";
    public static final String EMPTY_REG_PASSWORD_MES_ERR= "Error: Please enter an account password.";
    public static String HIGHLIGHTED_MENU_ITEM_COLOR = "rgb(a)?\\(237, 30, 36(, 1)?\\)";

}
