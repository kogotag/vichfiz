package org.example.frontend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonOkListener implements ActionListener {
    private JFrame parent;

    @Override
    public void actionPerformed(ActionEvent e) {
        parent.dispose();
    }

    public ButtonOkListener(JFrame parent) {
        this.parent = parent;
    }
}
