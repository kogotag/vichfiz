package org.example.frontend.hwharmonicseries;

import org.example.frontend.ButtonListenerWithParent;

import java.awt.event.ActionEvent;

public class ButtonListenerCalculateListener extends ButtonListenerWithParent<FrameHarmonicSeries> {
    @Override
    public void actionPerformed(ActionEvent e) {
        parent.calculate();
        parent.renewCalculationLabels();
    }

    public ButtonListenerCalculateListener(FrameHarmonicSeries parent) {
        super(parent);
    }
}
