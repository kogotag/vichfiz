package org.example.frontend.hwexcel;

import org.example.frontend.ButtonWithParent;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.File;

public class ButtonSelectDocumentListener extends ButtonWithParent<FrameHomeworkExcel> {
    private JFileChooser fileChooser;
    private JLabel labelSelectedFile;
    private FileNameExtensionFilter xlsxFileFilter = new FileNameExtensionFilter(
            "Excel Workbook .xlsx", "xlsx");

    @Override
    public void actionPerformed(ActionEvent e) {
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(xlsxFileFilter);
        int test = fileChooser.showOpenDialog(null);
        if (test == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            labelSelectedFile.setText(selectedFile.getAbsolutePath());
            parent.setExcelDocument(selectedFile);
        }
    }

    public ButtonSelectDocumentListener(JLabel labelSelectedFile, FrameHomeworkExcel parent) {
        super(parent);
        this.labelSelectedFile = labelSelectedFile;
    }
}
