package org.example.frontend.hwexcel;

import org.example.backend.Vichfiz;
import org.example.frontend.ButtonListenerWithParent;
import org.example.frontend.FrameErrorMessage;

import java.awt.event.ActionEvent;

public class ButtonReadFromDocumentListener extends ButtonListenerWithParent<FrameExcel> {
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

    public ButtonReadFromDocumentListener(FrameExcel parent) {
        super(parent);
    }
}
