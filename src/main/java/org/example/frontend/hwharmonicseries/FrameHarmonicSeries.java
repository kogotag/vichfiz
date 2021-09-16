package org.example.frontend.hwharmonicseries;

import org.example.backend.Vichfiz;
import org.example.frontend.MathLabelDrawer;
import org.example.frontend.NumberTextField;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class FrameHarmonicSeries extends JFrame {
    private JPanel panelStraightCalculation;
    private JPanel panelReversedCalculation;
    private JPanel panelLowerBoundCalculation;
    private JPanel panelLowerBoundSumHWCalculation;
    private JPanel panelDownButtons;
    private JLabel labelExpressionStraightCalculation;
    private JLabel labelExpressionReversedCalculation;
    private JLabel labelExpressionLowerBoundCalculation;
    private JLabel labelExpressionLowerBoundHWCalculation;
    private NumberTextField textFieldLowerBound;
    private JButton buttonCalculate;
    private double straightCalculation;
    private double reversedCalculation;
    private double lowerBoundCalculation;
    private double getLowerBoundHWCalculation;
    private final String mathExp = "\\sum_{k=1}^{" + Vichfiz.getHarmonicSeriesLimit() + "} \\frac {1} {k} = ";
    private final String mathExpLowerBound = "\\sum_{k=1}^{k \\leq K_{min}} \\frac {1} {k} =";
    private final String mathExpLowerBoundHW = "\\sum_{k=1}^{k \\leq K_{min}} \\frac {k} {k^2+2} =";

    public FrameHarmonicSeries() throws HeadlessException {
        super("Гармонический ряд");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, (int) dim.width / 2, (int) dim.height / 2);
        setVisible(true);
        setLocationRelativeTo(null);

        panelStraightCalculation = new JPanel();
        panelStraightCalculation.setBorder(new TitledBorder(null,
                "Сумма от 1 до n",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                null));
        panelReversedCalculation = new JPanel();
        panelReversedCalculation.setBorder(new TitledBorder(null,
                "Сумма от n до 1",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                null));
        panelLowerBoundCalculation = new JPanel();
        panelLowerBoundCalculation.setBorder(new TitledBorder(null,
                "Сумма с нижним пределом слагаемого",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                null));
        panelLowerBoundSumHWCalculation = new JPanel();
        panelLowerBoundSumHWCalculation.setBorder(new TitledBorder(null,
                "Сумма с нижним пределом слагаемого",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                null));
        panelDownButtons = new JPanel();

        textFieldLowerBound = new NumberTextField();
        textFieldLowerBound.setColumns(5);
        labelExpressionStraightCalculation = new JLabel();
        labelExpressionReversedCalculation = new JLabel();
        labelExpressionLowerBoundCalculation = new JLabel();
        labelExpressionLowerBoundHWCalculation = new JLabel();

        MathLabelDrawer.setLabelFormula(labelExpressionStraightCalculation, mathExp);
        MathLabelDrawer.setLabelFormula(labelExpressionReversedCalculation, mathExp);
        MathLabelDrawer.setLabelFormula(labelExpressionLowerBoundCalculation, mathExpLowerBound);
        MathLabelDrawer.setLabelFormula(labelExpressionLowerBoundHWCalculation, mathExpLowerBoundHW);

        buttonCalculate = new JButton("Рассчитать");
        buttonCalculate.addActionListener(new ButtonCalculateListener(this));

        panelStraightCalculation.add(labelExpressionStraightCalculation);
        panelReversedCalculation.add(labelExpressionReversedCalculation);
        panelLowerBoundCalculation.add(labelExpressionLowerBoundCalculation);
        panelLowerBoundSumHWCalculation.add(labelExpressionLowerBoundHWCalculation);
        panelDownButtons.add(buttonCalculate);
        panelDownButtons.add(textFieldLowerBound);

        Container contentPane = this.getContentPane();
        GridLayout gridLayout = new GridLayout(5, 1);
        contentPane.setLayout(gridLayout);
        contentPane.add(panelStraightCalculation);
        contentPane.add(panelReversedCalculation);
        contentPane.add(panelLowerBoundCalculation);
        contentPane.add(panelLowerBoundSumHWCalculation);
        contentPane.add(panelDownButtons);
    }

    public void renewCalculationLabels() {
        String expressionStraightCalculation = mathExp + straightCalculation;
        String expressionReversedCalculation = mathExp + reversedCalculation;
        if (textFieldLowerBound.isValid()) {
            String expressionLowerBoundCalculation = mathExpLowerBound + Vichfiz
                    .getHarmonicSum(textFieldLowerBound.getValue());
            String expressionLowerBoundHWCalculation = mathExpLowerBoundHW + Vichfiz
                    .getSumFromHomework(textFieldLowerBound.getValue());
            MathLabelDrawer.setLabelFormula(labelExpressionLowerBoundCalculation, expressionLowerBoundCalculation);
            MathLabelDrawer.setLabelFormula(labelExpressionLowerBoundHWCalculation, expressionLowerBoundHWCalculation);
        }
        MathLabelDrawer.setLabelFormula(labelExpressionStraightCalculation, expressionStraightCalculation);
        MathLabelDrawer.setLabelFormula(labelExpressionReversedCalculation, expressionReversedCalculation);
    }

    public void calculate() {
        straightCalculation = Vichfiz.getStraightHarmonicSum();
        reversedCalculation = Vichfiz.getReversedHarmonicSum();
    }
}
