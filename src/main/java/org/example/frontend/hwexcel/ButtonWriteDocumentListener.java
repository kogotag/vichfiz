package org.example.frontend.hwexcel;

import org.example.backend.Vichfiz;
import org.example.frontend.ButtonWithParent;
import org.example.frontend.FrameErrorMessage;

import java.awt.event.ActionEvent;

public class ButtonWriteDocumentListener extends ButtonWithParent<FrameHomeworkExcel> {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (parent.getExcelDocument() == null) {
            FrameErrorMessage errorFrame = new FrameErrorMessage("Файл не найден");
            return;
        }
        if (!parent.getExcelDocument().exists()) {
            try {
                parent.getExcelDocument().createNewFile();
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }
        Vichfiz.writeToExcel(parent.getExcelDocument());
    }

    public ButtonWriteDocumentListener(FrameHomeworkExcel parent) {
        super(parent);
    }
}
