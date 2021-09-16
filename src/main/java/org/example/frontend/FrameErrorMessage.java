package org.example.frontend;

import javax.swing.*;
import java.awt.*;

public class FrameErrorMessage extends JFrame {
    private String errorMsg;
    private JButton buttonOk;
    private JLabel label;

    public FrameErrorMessage(String errorMsg) throws HeadlessException {
        super("Ошибка");
        setSize(250, 155);
        setLocationRelativeTo(null);
        label = new JLabel(errorMsg);
        buttonOk = new JButton("OK");
        buttonOk.addActionListener(new ButtonOkListener(this));
        setVisible(true);
        setResizable(false);
        Container container = getContentPane();
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;
        container.setLayout(layout);
        constraints.weightx = 0.5d;
        constraints.gridy = 0;
        constraints.gridx = 0;
        container.add(label, constraints);
        constraints.gridy = 1;
        container.add(buttonOk, constraints);
    }
}
