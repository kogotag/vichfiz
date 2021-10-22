package org.example.frontend;

import javax.swing.*;

public class MenuItemFrameOpener extends JMenuItem {
    JFrame frameToOpen;
    Class<? extends JFrame> frameToOpenClass;

    public MenuItemFrameOpener(JFrame frameToOpen, Class<? extends JFrame> frameToOpenClass) {
        this.frameToOpen = frameToOpen;
        this.frameToOpenClass = frameToOpenClass;
        addActionListener(new MenuItemFrameOpenerListener(frameToOpen, frameToOpenClass));
    }

    public MenuItemFrameOpener(Icon icon, JFrame frameToOpen, Class<? extends JFrame> frameToOpenClass) {
        super(icon);
        this.frameToOpen = frameToOpen;
        this.frameToOpenClass = frameToOpenClass;
        addActionListener(new MenuItemFrameOpenerListener(frameToOpen, frameToOpenClass));
    }

    public MenuItemFrameOpener(String text, JFrame frameToOpen, Class<? extends JFrame> frameToOpenClass) {
        super(text);
        this.frameToOpen = frameToOpen;
        this.frameToOpenClass = frameToOpenClass;
        addActionListener(new MenuItemFrameOpenerListener(frameToOpen, frameToOpenClass));
    }

    public MenuItemFrameOpener(Action a, JFrame frameToOpen, Class<? extends JFrame> frameToOpenClass) {
        super(a);
        this.frameToOpen = frameToOpen;
        this.frameToOpenClass = frameToOpenClass;
        addActionListener(new MenuItemFrameOpenerListener(frameToOpen, frameToOpenClass));
    }

    public MenuItemFrameOpener(String text, Icon icon, JFrame frameToOpen, Class<? extends JFrame> frameToOpenClass) {
        super(text, icon);
        this.frameToOpen = frameToOpen;
        this.frameToOpenClass = frameToOpenClass;
        addActionListener(new MenuItemFrameOpenerListener(frameToOpen, frameToOpenClass));
    }

    public MenuItemFrameOpener(String text, int mnemonic, JFrame frameToOpen, Class<? extends JFrame> frameToOpenClass) {
        super(text, mnemonic);
        this.frameToOpen = frameToOpen;
        this.frameToOpenClass = frameToOpenClass;
        addActionListener(new MenuItemFrameOpenerListener(frameToOpen, frameToOpenClass));
    }
}
