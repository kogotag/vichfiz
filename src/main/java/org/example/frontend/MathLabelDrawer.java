package org.example.frontend;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class MathLabelDrawer {
    public static void setLabelFormula(JLabel label, String texEpression) {
        if (label == null) {
            return;
        }
        TeXFormula formula = new TeXFormula(texEpression);
        TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 18f);
        BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),
                BufferedImage.TYPE_4BYTE_ABGR);
        icon.paintIcon(label, image.getGraphics(), 0, 0);
        label.setIcon(icon);
    }
}
