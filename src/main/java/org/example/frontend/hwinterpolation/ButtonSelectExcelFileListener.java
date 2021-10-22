package org.example.frontend.hwinterpolation;

import org.example.frontend.ButtonListenerWithParent;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.File;

public class ButtonSelectExcelFileListener extends ButtonListenerWithParent<FrameInterpolation> {
    public ButtonSelectExcelFileListener(FrameInterpolation parent) {
        super(parent);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter xlsxFileFilter = new FileNameExtensionFilter(
                "Excel Workbook .xlsx", "xlsx");
        fileChooser.setFileFilter(xlsxFileFilter);
        int test = fileChooser.showOpenDialog(null);
        if (test == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            parent.setFile(file);
            parent.setTextFieldSelectedFileText(file.getName());
        }
    }
}
