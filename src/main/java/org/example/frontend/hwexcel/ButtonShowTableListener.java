package org.example.frontend.hwexcel;

import org.example.frontend.FrameErrorMessage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonShowTableListener implements ActionListener {
    private FrameHomeworkExcel parent;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (parent.getExcelDocument() == null || !parent.getExcelDocument().exists()) {
            FrameErrorMessage errorFrame = new FrameErrorMessage("Файл не найден");
            return;
        }
        if (parent.getTable() == null || parent.getTable().length <= 0){
            FrameErrorMessage errorFrame = new FrameErrorMessage("Таблица не найдена или пуста");
            return;
        }
            FrameTable frameTable = new FrameTable(parent.getExcelDocument().getName(), parent.getTable());
    }

    public ButtonShowTableListener(FrameHomeworkExcel parent) {
        this.parent = parent;
    }
}
