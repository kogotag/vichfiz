package org.example.frontend.hwharmonicseries;

import org.example.backend.Vichfiz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonCalculateListener implements ActionListener {
    private FrameHarmonicSeries parent;

    @Override
    public void actionPerformed(ActionEvent e) {
        parent.calculate();
        parent.renewCalculationLabels();
    }

    public ButtonCalculateListener(FrameHarmonicSeries parent) {
        this.parent = parent;
    }
}
