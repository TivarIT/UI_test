package utils;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class UploadUtil {
    private static final ISettingsFile CONFIG = new JsonSettingsFile("config.json");
    private static final int timeout = Integer.parseInt(CONFIG.getValue("/timeout").toString());

    public void uploadFile(File file) {
        StringSelection stringSelection = new StringSelection(file.getAbsolutePath());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        if (robot != null) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.delay(timeout);
            robot.keyPress(KeyEvent.VK_V);
            robot.delay(timeout);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(timeout);
        }
    }
}
