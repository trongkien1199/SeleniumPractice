package Listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class ListenerISuite implements ISuiteListener {
    public void onStart(ISuite suite) {
        System.out.println("onStart function started "  + suite.getName());
    }
}
