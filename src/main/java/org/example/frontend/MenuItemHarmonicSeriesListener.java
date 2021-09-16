package org.example.frontend;

import org.example.frontend.hwharmonicseries.FrameHarmonicSeries;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItemHarmonicSeriesListener implements ActionListener {
    private FrameHarmonicSeries frameToOpen;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (frameToOpen != null) {
            frameToOpen.dispose();
        }
        frameToOpen = new FrameHarmonicSeries();
    }

    public MenuItemHarmonicSeriesListener(FrameHarmonicSeries frameToOpen) {
        this.frameToOpen = frameToOpen;
    }
}
