package org.example.frontend.hwinterpolation;

import org.example.backend.Graphic2D;
import org.example.backend.Vichfiz;
import org.example.frontend.ButtonWithParent;
import org.example.frontend.FrameErrorMessage;

import java.awt.event.ActionEvent;
import java.io.File;

public class ButtonCalculateListener extends ButtonWithParent<FrameInterpolation> {
    public ButtonCalculateListener(FrameInterpolation parent) {
        super(parent);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File file = parent.getFile();

        if(file == null || !file.exists()){
            new FrameErrorMessage("Файл не найден");
            return;
        }

        if(parent.getResultGraphicStep() <= 0d){
            new FrameErrorMessage("Шаг может быть только положительным числом");
            return;
        }

        if(parent.getResultGraphicRightBorder() <= parent.getResultGraphicLeftBorder()){
            new FrameErrorMessage("Правая граница должна быть больше левой");
            return;
        }

        if(parent.getOffset() < 0){
            new FrameErrorMessage("Сдвиг не может быть отрицательным числом");
            return;
        }

        if(parent.getInterpolationDotsCount() <= 0){
            new FrameErrorMessage("Количество точек для интерполяции не может быть меньше либо равно нуля");
            return;
        }

        Graphic2D graphicForInterpolation = Vichfiz.getGraphicFromExcel(file, 0,
                parent.getInterpolationDotsCount());

        Graphic2D resultGraphic = Vichfiz.getLagrangePolynomialInterpolation(graphicForInterpolation,
                parent.getResultGraphicStep(),
                parent.getResultGraphicLeftBorder(),
                parent.getResultGraphicRightBorder());
        if(resultGraphic == null){
            new FrameErrorMessage("Провести интерполяцию не удалось");
            return;
        }

        Vichfiz.writeToExcel(file, parent.getOffset(), resultGraphic.getTable2D());
    }
}
