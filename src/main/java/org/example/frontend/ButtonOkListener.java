package org.example.frontend;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ButtonOkListener extends ButtonWithParent<JFrame> {
    @Override
    public void actionPerformed(ActionEvent e) {
        parent.dispose();
    }

    public ButtonOkListener(JFrame parent) {
        super(parent);
    }
}
