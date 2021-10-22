package org.example.frontend;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ButtonListenerOkListener extends ButtonListenerWithParent<JFrame> {
    @Override
    public void actionPerformed(ActionEvent e) {
        parent.dispose();
    }

    public ButtonListenerOkListener(JFrame parent) {
        super(parent);
    }
}
