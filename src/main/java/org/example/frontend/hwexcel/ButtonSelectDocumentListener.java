package org.example.frontend.hwexcel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ButtonSelectDocumentListener implements ActionListener {
    private JFileChooser fileChooser;
    private JLabel labelSelectedFile;
    private FrameHomeworkExcel parent;
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
        this.labelSelectedFile = labelSelectedFile;
        this.parent = parent;
    }
}
