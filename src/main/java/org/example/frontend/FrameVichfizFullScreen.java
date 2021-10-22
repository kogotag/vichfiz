package org.example.frontend;

import javax.swing.*;
import java.awt.*;

abstract public class FrameVichfizFullScreen extends JFrame {
    protected final int textFieldSmallHeight = 25;
    protected final int textFieldSmallLength = 100;
    protected final int textFieldMediumLength = 200;
    protected final int textFieldLargeLength = 300;
    protected Dimension screenSize;
    public FrameVichfizFullScreen(String title) throws HeadlessException {
        super(title);
        Rectangle r = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        setSize(r.width, r.height);
        setVisible(true);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    }
}
