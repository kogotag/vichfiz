package org.example.frontend.hwexcel;

import org.example.frontend.ButtonListenerWithParent;
import org.example.frontend.FrameErrorMessage;

import java.awt.event.ActionEvent;

public class ButtonShowTableListener extends ButtonListenerWithParent<FrameExcel> {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (parent.getExcelDocument() == null || !parent.getExcelDocument().exists()) {
            FrameErrorMessage errorFrame = new FrameErrorMessage("Файл не найден");
            return;
        }
        if (parent.getTable() == null || parent.getTable().length <= 0) {
            FrameErrorMessage errorFrame = new FrameErrorMessage("Таблица не найдена или пуста");
            return;
        }
        FrameTable frameTable = new FrameTable(parent.getExcelDocument().getName(), parent.getTable());
    }

    public ButtonShowTableListener(FrameExcel parent) {
        super(parent);
    }
}
