package org.example.frontend;

import javax.swing.*;
import java.awt.*;

abstract public class FrameVichfizFullScreen extends JFrame {
    public FrameVichfizFullScreen(String title) throws HeadlessException {
        super(title);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, (int) dim.width, (int) dim.height);
        setVisible(true);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
