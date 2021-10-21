package org.example.frontend.hwexcel;

import org.example.backend.Vichfiz;
import org.example.frontend.ButtonWithParent;
import org.example.frontend.FrameErrorMessage;

import java.awt.event.ActionEvent;

public class ButtonReadFromDocumentListener extends ButtonWithParent<FrameHomeworkExcel> {
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
        super(parent);
    }
}
