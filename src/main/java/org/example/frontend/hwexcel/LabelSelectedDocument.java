package org.example.frontend.hwexcel;

import javax.swing.*;

public class LabelSelectedDocument extends JLabel {
    public void setText(String text) {
        super.setText("Выбранный файл: " + text);
    }

    public LabelSelectedDocument(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
    }

    public LabelSelectedDocument(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    public LabelSelectedDocument(String text) {
        super(text);
    }

    public LabelSelectedDocument(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
    }

    public LabelSelectedDocument(Icon image) {
        super(image);
    }

    public LabelSelectedDocument() {
    }
}
