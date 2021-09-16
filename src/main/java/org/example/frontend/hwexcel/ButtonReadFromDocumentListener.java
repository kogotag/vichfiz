package org.example.frontend.hwexcel;

import org.example.backend.Vichfiz;
import org.example.frontend.FrameErrorMessage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonReadFromDocumentListener implements ActionListener {
    private FrameHomeworkExcel parent;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (parent.getExcelDocument() == null || !parent.getExcelDocument().exists()) {
            FrameErrorMessage errorFrame = new FrameErrorMessage("Файл не найден");
            return;
        }
        String[][] s = Vichfiz.readFromExcel(parent.getExcelDocument());
        if (s == null) {
            FrameErrorMessage errorFrame = new FrameErrorMessage("Не удалось прочитать таблицу");
            return;
        }
        parent.setTable(s);
    }

    public ButtonReadFromDocumentListener(FrameHomeworkExcel parent) {
        this.parent = parent;
    }
}
