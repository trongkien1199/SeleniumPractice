package utils;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PressKey {
    Robot robot = new Robot();

    public PressKey() throws AWTException {
    }
    public void pressKeyUP(){
        robot.keyPress(KeyEvent.VK_UP);
        robot.keyRelease(KeyEvent.VK_UP);
    }
}
