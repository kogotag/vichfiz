package org.example.frontend;

import javax.swing.*;
import java.awt.event.ActionListener;

abstract public class ButtonWithParent<T extends JFrame> implements ActionListener {
    public T parent;

    public ButtonWithParent(T parent) {
        this.parent = parent;
    }
}
