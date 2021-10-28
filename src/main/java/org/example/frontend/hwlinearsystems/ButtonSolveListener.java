package org.example.frontend.hwlinearsystems;

import org.example.backend.Solution;
import org.example.backend.Vichfiz;
import org.example.frontend.ButtonListenerWithParent;
import org.example.frontend.NumberTextField;

import java.awt.event.ActionEvent;
import java.util.List;

public class ButtonSolveListener extends ButtonListenerWithParent<FrameLinearSystems> {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!checkFields()){
            return;
        }
        List<Solution> solutionList = Vichfiz
                .getLinearSystem2by2Solutions(parent.getNumberTextFieldsSystemParams()[0].getValue(),
                parent.getNumberTextFieldsSystemParams()[1].getValue(),
                parent.getNumberTextFieldsSystemParams()[2].getValue(),
                parent.getNumberTextFieldsSystemParams()[3].getValue(),
                parent.getNumberTextFieldsSystemParams()[4].getValue(),
                parent.getNumberTextFieldsSystemParams()[5].getValue());
        StringBuilder sb = new StringBuilder();
        for (Solution solution : solutionList) {
            sb.append(solution.toString()).append("\n");
        }
        parent.getTextAreaSolution().setText(sb.toString());
    }

    public ButtonSolveListener(FrameLinearSystems parent) {
        super(parent);
    }

    private boolean checkFields(){
        for (int i = 0; i < 6; i++) {
            NumberTextField n = parent.getNumberTextFieldsSystemParams()[i];
            if (!n.isValid()) {
                return false;
            }
        }
        return true;
    }
}
