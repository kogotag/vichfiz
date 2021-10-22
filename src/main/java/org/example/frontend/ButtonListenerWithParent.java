package org.example.frontend;

import javax.swing.*;
import java.awt.event.ActionListener;

abstract public class ButtonListenerWithParent<T extends JFrame> implements ActionListener {
    public T parent;

    public ButtonListenerWithParent(T parent) {
        this.parent = parent;
    }
}
