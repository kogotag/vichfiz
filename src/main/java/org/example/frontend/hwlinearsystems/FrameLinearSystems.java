package org.example.frontend.hwlinearsystems;

import org.example.frontend.FrameVichfizFullScreen;
import org.example.frontend.MathLabelDrawer;
import org.example.frontend.NumberTextField;

import javax.swing.*;
import java.awt.*;

public class FrameLinearSystems extends FrameVichfizFullScreen {
    private JLabel labelDescriptionText;
    private JLabel labelDescriptionExpression;
    private JLabel[] labelsSystemParams;
    private NumberTextField[] numberTextFieldsSystemParams;
    private JButton buttonSolve = new JButton("Решить");
    private final String descriptionExpression = "\\begin {cases} ax+by=f \\\\ cx+dy=g \\end{cases}";
    private JTextArea textAreaSolution = new JTextArea();

    public FrameLinearSystems() throws HeadlessException {
        super("Линейные системы уравнений");
        Container contentPane = getContentPane();

        labelDescriptionText = new JLabel("решение систем уравнений вида");
        labelDescriptionExpression = new JLabel();
        labelsSystemParams = new JLabel[]{new JLabel("a"),
                new JLabel("b"),
                new JLabel("c"),
                new JLabel("d"),
                new JLabel("f"),
                new JLabel("g")
        };

        textAreaSolution.setEditable(false);

        numberTextFieldsSystemParams = new NumberTextField[6];

        MathLabelDrawer.setLabelFormula(labelDescriptionExpression, descriptionExpression);

        GroupLayout layout = new GroupLayout(contentPane);
        contentPane.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup groupFillInHorizont = layout.createSequentialGroup();
        GroupLayout.SequentialGroup groupFillInVert = layout.createSequentialGroup();
        GroupLayout.ParallelGroup groupFillInHorParallel1 = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        GroupLayout.ParallelGroup groupFillInHorParallel2 = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        for (int i = 0; i < 6; i++) {
            numberTextFieldsSystemParams[i] = new NumberTextField(0, textFieldSmallHeight, textFieldSmallLength);
            groupFillInHorParallel1
                    .addComponent(labelsSystemParams[i]);
            groupFillInHorParallel2
                    .addComponent(numberTextFieldsSystemParams[i]);
            GroupLayout.ParallelGroup groupFillInVertParallel = layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelsSystemParams[i])
                    .addComponent(numberTextFieldsSystemParams[i]);
            groupFillInVert.addGroup(groupFillInVertParallel);
        }
        groupFillInHorizont
                .addGroup(groupFillInHorParallel1)
                .addGroup(groupFillInHorParallel2);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelDescriptionText)
                                        .addComponent(labelDescriptionExpression))
                                .addGroup(groupFillInHorizont)
                                .addComponent(buttonSolve)
                                .addComponent(textAreaSolution))
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelDescriptionText)
                                .addComponent(labelDescriptionExpression))
                        .addGroup(groupFillInVert)
                        .addComponent(buttonSolve)
                        .addComponent(textAreaSolution)
        );

        textAreaSolution.setMaximumSize(new Dimension(600, 100));
        buttonSolve.addActionListener(new ButtonSolveListener(this));
    }

    public NumberTextField[] getNumberTextFieldsSystemParams() {
        return numberTextFieldsSystemParams;
    }

    public JTextArea getTextAreaSolution() {
        return textAreaSolution;
    }
}
