package org.example.frontend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

public class MenuItemFrameOpenerListener implements ActionListener {
    JFrame frameToOpen;
    Class<? extends JFrame> frameToOpenClass;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(frameToOpen != null){
            frameToOpen.dispose();
        }
        try {
            frameToOpen = frameToOpenClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException
                | IllegalAccessException
                | NoSuchMethodException
                | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }

    public MenuItemFrameOpenerListener(JFrame frameToOpen, Class<? extends JFrame> frameToOpenClass) {
        this.frameToOpen = frameToOpen;
        this.frameToOpenClass = frameToOpenClass;
    }
}
