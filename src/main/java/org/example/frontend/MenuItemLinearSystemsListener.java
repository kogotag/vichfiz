package org.example.frontend;

import org.example.hwlinearsystems.FrameLinearSystems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItemLinearSystemsListener implements ActionListener {
    FrameLinearSystems frameToOpen;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (frameToOpen != null) {
            frameToOpen.dispose();
        }
        frameToOpen = new FrameLinearSystems();
    }

    public MenuItemLinearSystemsListener(FrameLinearSystems frameToOpen) {
        this.frameToOpen = frameToOpen;
    }
}
