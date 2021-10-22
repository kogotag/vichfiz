package org.example.frontend;

public class NumberTextField extends TextFieldLineSized {
    public NumberTextField() {
        super();
    }

    public NumberTextField(Number number) {
        super(number.toString());
    }

    public NumberTextField(int height, int length) {
        super(height, length);
    }

    public NumberTextField(Number number, int height, int length) {
        super(number.toString(), height, length);
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
