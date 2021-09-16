package org.example.frontend.hwquadequations;

import org.example.backend.Vichfiz;
import org.example.frontend.FrameErrorMessage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonSolveListener implements ActionListener {
    FrameQuadEquations parent;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(checkFields()){
            parent.getLabelSolution().setText(Vichfiz.getQuadEquationSolution(
                    parent.getTextFieldA().getValue(),
                    parent.getTextFieldB().getValue(),
                    parent.getTextFieldC().getValue()
                    ));
        } else {
            new FrameErrorMessage("Пожалуйста, введите числа");
        }
    }

    public ButtonSolveListener(FrameQuadEquations parent) {
        this.parent = parent;
    }

    private boolean checkFields(){
        if(!parent.getTextFieldA().isValid()) {
            return false;
        }
        if(!parent.getTextFieldB().isValid()) {
            return false;
        }
        if(!parent.getTextFieldC().isValid()) {
            return false;
        }
        return true;
    }
}
