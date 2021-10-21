package org.example.frontend.hwinterpolation;

import org.example.frontend.FrameErrorMessage;
import org.example.frontend.FrameVichfizFullScreen;
import org.example.frontend.NumberTextField;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;

public class FrameInterpolation extends FrameVichfizFullScreen {
    private JPanel panelSelectFile;
    private JPanel panelSettings;
    private JLabel labelGetGraphic = new JLabel(
            "Укажите xlsx документ для графика, который будет интерполироваться");
    private JLabel labelOffset = new JLabel(
            "Укажите сдвиг по колонкам вправо для графика, который будет интерполироваться");
    private JLabel labelSelectedFile = new JLabel("Выбран файл:");
    private JLabel labelInterpolationDotsCount = new JLabel("Укажите количество точек для интерполяции");
    private JLabel labelResultGraphic = new JLabel("Параметры конечного графика:");
    private JLabel labelResultGraphicStep = new JLabel("Шаг:");
    private JLabel labelResultGraphicLeftBorder = new JLabel("Левая граница:");
    private JLabel labelResultGraphicRightBorder = new JLabel("Правая граница:");
    private JButton buttonSelectGraphicFile = new JButton("Открыть");
    private JButton buttonCalculate = new JButton("Рассчитать");
    private ButtonSelectExcelFileListener buttonSelectExcelFileListener;
    private NumberTextField textFieldOffset = new NumberTextField(3);
    private NumberTextField textFieldInterpolationDotsCount = new NumberTextField(3);
    private NumberTextField textFieldResultGraphicStep = new NumberTextField(0.1d);
    private NumberTextField textFieldResultGraphicLeftBorder = new NumberTextField(0d);
    private NumberTextField textFieldResultGraphicRightBorder = new NumberTextField(10d);
    private JTextField textFieldSelectedFile = new JTextField("");
    private File file;

    public FrameInterpolation() throws HeadlessException {
        super("Интерполяция");
        panelSelectFile = new JPanel();
        panelSelectFile.setBorder(new LineBorder(null));
        GroupLayout layoutPanelSelect = new GroupLayout(panelSelectFile);
        layoutPanelSelect.setAutoCreateGaps(true);
        layoutPanelSelect.setAutoCreateContainerGaps(true);
        panelSelectFile.setLayout(layoutPanelSelect);
        layoutPanelSelect.setHorizontalGroup(
                layoutPanelSelect.createSequentialGroup()
                        .addGroup(layoutPanelSelect.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(labelGetGraphic)
                                .addComponent(buttonSelectGraphicFile)
                                .addGroup(layoutPanelSelect.createSequentialGroup()
                                        .addComponent(labelSelectedFile)
                                        .addComponent(textFieldSelectedFile)))
        );
        layoutPanelSelect.setVerticalGroup(layoutPanelSelect.createSequentialGroup()
                .addComponent(labelGetGraphic)
                .addComponent(buttonSelectGraphicFile)
                .addGroup(layoutPanelSelect.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelSelectedFile)
                        .addComponent(textFieldSelectedFile))
        );
        panelSettings = new JPanel();
        panelSettings.setBorder(new LineBorder(null));
        GroupLayout layoutSettings = new GroupLayout(panelSettings);
        panelSettings.setLayout(layoutSettings);
        layoutSettings.setAutoCreateGaps(true);
        layoutSettings.setAutoCreateContainerGaps(true);
        layoutSettings.setHorizontalGroup(
                layoutSettings.createSequentialGroup()
                        .addGroup(layoutSettings.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(labelOffset)
                                .addComponent(textFieldOffset)
                                .addComponent(labelInterpolationDotsCount)
                                .addComponent(textFieldInterpolationDotsCount)
                                .addComponent(labelResultGraphic)
                                .addGroup(layoutSettings.createSequentialGroup()
                                        .addComponent(labelResultGraphicStep)
                                        .addComponent(textFieldResultGraphicStep))
                                .addGroup(layoutSettings.createSequentialGroup()
                                        .addComponent(labelResultGraphicLeftBorder)
                                        .addComponent(textFieldResultGraphicLeftBorder))
                                .addGroup(layoutSettings.createSequentialGroup()
                                        .addComponent(labelResultGraphicRightBorder)
                                        .addComponent(textFieldResultGraphicRightBorder))
                                .addComponent(buttonCalculate))
        );
        layoutSettings.setVerticalGroup(
                layoutSettings.createSequentialGroup()
                        .addComponent(labelOffset)
                        .addComponent(textFieldOffset)
                        .addComponent(labelInterpolationDotsCount)
                        .addComponent(textFieldInterpolationDotsCount)
                        .addComponent(labelResultGraphic)
                        .addGroup(layoutSettings.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelResultGraphicStep)
                                .addComponent(textFieldResultGraphicStep))
                        .addGroup(layoutSettings.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelResultGraphicLeftBorder)
                                .addComponent(textFieldResultGraphicLeftBorder))
                        .addGroup(layoutSettings.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelResultGraphicRightBorder)
                                .addComponent(textFieldResultGraphicRightBorder))
                        .addComponent(buttonCalculate)
        );
        Container contentPane = getContentPane();
        GroupLayout layout = new GroupLayout(contentPane);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        contentPane.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(panelSelectFile)
                                .addComponent(panelSettings))
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(panelSelectFile)
                        .addComponent(panelSettings)
        );
        Dimension smallArea = new Dimension(100, 25);
        textFieldOffset.setMaximumSize(smallArea);
        textFieldSelectedFile.setEditable(false);
        textFieldSelectedFile.setMaximumSize(new Dimension(200, 25));
        textFieldResultGraphicStep.setMaximumSize(smallArea);
        textFieldResultGraphicLeftBorder.setMaximumSize(smallArea);
        textFieldResultGraphicRightBorder.setMaximumSize(smallArea);
        textFieldInterpolationDotsCount.setMaximumSize(smallArea);
        buttonSelectExcelFileListener = new ButtonSelectExcelFileListener(this);
        buttonSelectGraphicFile.addActionListener(buttonSelectExcelFileListener);
        buttonCalculate.addActionListener(new ButtonCalculateListener(this));
    }

    public void setTextFieldSelectedFileText(String text) {
        textFieldSelectedFile.setText(text);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getOffset() {
        if (checkNumberField(textFieldOffset)) {
            return (int) textFieldOffset.getValue();
        } else return 0;
    }

    public int getInterpolationDotsCount() {
        if (checkNumberField(textFieldInterpolationDotsCount)) {
            return (int) textFieldInterpolationDotsCount.getValue();
        } else return 0;
    }

    public double getResultGraphicStep() {
        if (checkNumberField(textFieldResultGraphicStep)) {
            return textFieldResultGraphicStep.getValue();
        } else {
            return 0;
        }
    }

    public double getResultGraphicLeftBorder() {
        if (checkNumberField(textFieldResultGraphicLeftBorder)) {
            return textFieldResultGraphicLeftBorder.getValue();
        } else {
            return 0;
        }
    }

    public double getResultGraphicRightBorder() {
        if (checkNumberField(textFieldResultGraphicRightBorder)) {
            return textFieldResultGraphicRightBorder.getValue();
        } else {
            return 0;
        }
    }

    private boolean checkNumberField(NumberTextField numberTextField) {
        if (numberTextField.isValid()) {
            return true;
        } else {
            new FrameErrorMessage("В одно из числовых полей введено не число");
            return false;
        }
    }
}
