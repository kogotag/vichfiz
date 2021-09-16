package org.example.frontend;

import javax.swing.*;

public class NumberTextField extends JTextField {
    public NumberTextField() {
        super();
    }

    public boolean isValid() {
        if (getDocument() == null) {
            return false;
        }
        try {
            Double.parseDouble(getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public double getValue() {
        try {
            return Double.parseDouble(getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
