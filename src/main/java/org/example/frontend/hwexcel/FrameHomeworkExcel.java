package org.example.frontend.hwexcel;

import org.example.frontend.FrameVichfizFullScreen;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FrameHomeworkExcel extends FrameVichfizFullScreen {
    private final String excelDocNotFoundMsg = "документ не найден";
    private File excelDocument;
    private JButton buttonSelectDocument;
    private JButton buttonWriteToDocument;
    private JButton buttonReadFromDocument;
    private JButton buttonShowTable;
    private LabelSelectedDocument labelSelectDocument;
    private String[][] table;

    public FrameHomeworkExcel() throws HeadlessException {
        super("Excel");
        labelSelectDocument = new LabelSelectedDocument(excelDocNotFoundMsg);
        buttonSelectDocument = new JButton("Открыть");
        buttonWriteToDocument = new JButton("Записать");
        buttonReadFromDocument = new JButton("Прочитать");
        buttonShowTable = new JButton("Показать таблицу");
        Container contentPane = this.getContentPane();
        GroupLayout layout = new GroupLayout(contentPane);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        contentPane.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(labelSelectDocument)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonSelectDocument)
                                        .addComponent(buttonWriteToDocument)
                                        .addComponent(buttonReadFromDocument)
                                        .addComponent(buttonShowTable)
                                )
                        )
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(labelSelectDocument)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonSelectDocument)
                                .addComponent(buttonWriteToDocument)
                                .addComponent(buttonReadFromDocument)
                                .addComponent(buttonShowTable))
        );
        buttonSelectDocument.addActionListener(new ButtonSelectDocumentListener(labelSelectDocument, this));
        buttonWriteToDocument.addActionListener(new ButtonWriteDocumentListener(this));
        buttonReadFromDocument.addActionListener(new ButtonReadFromDocumentListener(this));
        buttonShowTable.addActionListener(new ButtonShowTableListener(this));
    }

    public File getExcelDocument() {
        return excelDocument;
    }

    public void setExcelDocument(File excelDocument) {
        this.excelDocument = excelDocument;
    }

    public String[][] getTable() {
        return table;
    }

    public void setTable(String[][] table) {
        this.table = table;
    }
}
