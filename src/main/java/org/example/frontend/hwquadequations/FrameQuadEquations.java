package org.example.frontend.hwquadequations;

import org.example.frontend.NumberTextField;
import org.example.frontend.MathLabelDrawer;

import javax.swing.*;
import java.awt.*;

public class FrameQuadEquations extends JFrame {
    private JLabel labelDescription;
    private JLabel labelDescriptionFormula;
    private JLabel labelSolution;
    private NumberTextField textFieldA;
    private NumberTextField textFieldB;
    private NumberTextField textFieldC;
    private JButton buttonSolve;

    public FrameQuadEquations() throws HeadlessException {
        super("Квадратные уравнения");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, (int) dim.width / 3, (int) dim.height / 3);
        setVisible(true);
        setLocationRelativeTo(null);
        Container contentPane = getContentPane();

        labelDescription = new JLabel("Решение квадратных уравнений вида: ");
        labelDescriptionFormula = new JLabel();
        MathLabelDrawer.setLabelFormula(labelDescriptionFormula, "ax^2 + bx + c = 0");
        labelSolution = new JLabel();

        textFieldA = new NumberTextField();
        textFieldB = new NumberTextField();
        textFieldC = new NumberTextField();

        buttonSolve = new JButton("Решить");
        buttonSolve.addActionListener(new ButtonSolveListener(this));

        GroupLayout layout = new GroupLayout(contentPane);
        contentPane.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelDescription)
                                        .addComponent(labelDescriptionFormula))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(100)
                                        .addComponent(textFieldA)
                                        .addComponent(textFieldB)
                                        .addComponent(textFieldC)
                                        .addGap(100))
                                .addComponent(buttonSolve)
                                .addComponent(labelSolution)
                        )
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelDescription)
                                .addComponent(labelDescriptionFormula))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textFieldA)
                                .addComponent(textFieldB)
                                .addComponent(textFieldC))
                        .addComponent(buttonSolve)
                        .addComponent(labelSolution)
        );
    }

    public NumberTextField getTextFieldA() {
        return textFieldA;
    }

    public NumberTextField getTextFieldB() {
        return textFieldB;
    }

    public NumberTextField getTextFieldC() {
        return textFieldC;
    }

    public JLabel getLabelSolution() {
        return labelSolution;
    }
}
