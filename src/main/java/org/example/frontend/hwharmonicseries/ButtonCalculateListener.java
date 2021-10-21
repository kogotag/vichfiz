package org.example.frontend.hwharmonicseries;

import org.example.frontend.ButtonWithParent;

import java.awt.event.ActionEvent;

public class ButtonCalculateListener extends ButtonWithParent<FrameHarmonicSeries> {
    @Override
    public void actionPerformed(ActionEvent e) {
        parent.calculate();
        parent.renewCalculationLabels();
    }

    public ButtonCalculateListener(FrameHarmonicSeries parent) {
        super(parent);
    }
}
