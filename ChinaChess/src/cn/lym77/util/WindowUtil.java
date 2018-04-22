package cn.lym77.util;

import java.awt.*;

public class WindowUtil {
    public static void center(Component com) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        com.setLocation(dim.width / 2 - com.getWidth() / 2, dim.height / 2 - com.getHeight() / 2);
    }
}
