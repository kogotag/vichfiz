package org.example.frontend;

import org.example.frontend.hwquadequations.FrameQuadEquations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItemQuadEquationsListener implements ActionListener {
    private FrameQuadEquations frameToOpen;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (frameToOpen != null) {
            frameToOpen.dispose();
        }
        frameToOpen = new FrameQuadEquations();
    }

    public MenuItemQuadEquationsListener(FrameQuadEquations frameToOpen) {
        this.frameToOpen = frameToOpen;
    }
}
