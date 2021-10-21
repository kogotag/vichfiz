package org.example.hwlinearsystems;

import org.example.frontend.MathLabelDrawer;
import org.example.frontend.NumberTextField;

import javax.swing.*;
import java.awt.*;

public class FrameLinearSystems extends JFrame {
    private JPanel panelSolutions;
    private JLabel labelDescriptionText;
    private JLabel labelDescriptionExpression;
    private JLabel[] labelsSystemParams;
    private NumberTextField[] numberTextFieldsSystemParams;
    private JButton buttonSolve;
    private final String descriptionExpression = "\\begin {cases} ax+by=f \\\\ cx+dy=g \\end{cases}";

    public FrameLinearSystems() throws HeadlessException {
        super("Линейные системы уравнений");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, (int) dim.width / 3, (int) dim.height / 3);
        setVisible(true);
        setLocationRelativeTo(null);
        Container contentPane = getContentPane();

        panelSolutions = new JPanel();

        labelDescriptionText = new JLabel("решение систем уравнений вида");
        labelDescriptionExpression = new JLabel();
        labelsSystemParams = new JLabel[6];

        numberTextFieldsSystemParams = new NumberTextField[6];

        buttonSolve = new JButton("Решить");

        MathLabelDrawer.setLabelFormula(labelDescriptionExpression, descriptionExpression);

        GroupLayout layout = new GroupLayout(contentPane);
        contentPane.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelDescriptionText)
                                        .addComponent(labelDescriptionExpression))
                                .addComponent(panelSolutions)
                                .addComponent(buttonSolve))
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelDescriptionText)
                                .addComponent(labelDescriptionExpression)
                                .addComponent(panelSolutions)
                                .addComponent(buttonSolve))
        );
    }
}
