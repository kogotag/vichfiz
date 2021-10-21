package org.example.frontend;

import org.example.frontend.hwexcel.FrameHomeworkExcel;
import org.example.frontend.hwinterpolation.FrameInterpolation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItemInterpolationListener implements ActionListener {
    private FrameInterpolation frameToOpen;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (frameToOpen != null) {
            frameToOpen.dispose();
        }
        frameToOpen = new FrameInterpolation();
    }

    public MenuItemInterpolationListener(FrameInterpolation frameToOpen) {
        this.frameToOpen = frameToOpen;
    }
}
