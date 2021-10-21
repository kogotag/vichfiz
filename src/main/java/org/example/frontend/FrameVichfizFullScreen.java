package org.example.frontend;

import javax.swing.*;
import java.awt.*;

abstract public class FrameVichfizFullScreen extends JFrame {
    public FrameVichfizFullScreen(String title) throws HeadlessException {
        super(title);
        Rectangle r = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        setSize(r.width, r.height);
        setVisible(true);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
