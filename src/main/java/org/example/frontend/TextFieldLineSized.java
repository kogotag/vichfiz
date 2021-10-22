package org.example.frontend;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;

public class TextFieldLineSized extends JTextField {
    private int height;
    private int length;

    public TextFieldLineSized(int height, int length) {
        this.height = height;
        this.length = length;
        setMaximumSize();
    }

    public TextFieldLineSized(String text, int height, int length) {
        super(text);
        this.height = height;
        this.length = length;
        setMaximumSize();
    }

    public TextFieldLineSized(int columns, int height, int length) {
        super(columns);
        this.height = height;
        this.length = length;
        setMaximumSize();
    }

    public TextFieldLineSized(String text, int columns, int height, int length) {
        super(text, columns);
        this.height = height;
        this.length = length;
        setMaximumSize();
    }

    public TextFieldLineSized(Document doc, String text, int columns, int height, int length) {
        super(doc, text, columns);
        this.height = height;
        this.length = length;
        setMaximumSize();
    }

    public TextFieldLineSized() {
    }

    public TextFieldLineSized(String text) {
        super(text);
    }

    public TextFieldLineSized(int columns) {
        super(columns);
    }

    public TextFieldLineSized(String text, int columns) {
        super(text, columns);
    }

    public TextFieldLineSized(Document doc, String text, int columns) {
        super(doc, text, columns);
    }

    private void setMaximumSize(){
        Dimension dim = new Dimension(length, height);
        setMaximumSize(dim);
    }
}
