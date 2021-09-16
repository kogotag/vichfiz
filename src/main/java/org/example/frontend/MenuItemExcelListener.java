package org.example.frontend;

import org.example.frontend.hwexcel.FrameHomeworkExcel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItemExcelListener implements ActionListener {
    private FrameHomeworkExcel frameToOpen;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (frameToOpen != null) {
            frameToOpen.dispose();
        }
        frameToOpen = new FrameHomeworkExcel();
    }

    public MenuItemExcelListener(FrameHomeworkExcel frameToOpen) {
        this.frameToOpen = frameToOpen;
    }
}
