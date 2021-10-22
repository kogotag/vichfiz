package org.example.frontend;

import org.example.frontend.hwexcel.FrameExcel;
import org.example.frontend.hwharmonicseries.FrameHarmonicSeries;
import org.example.frontend.hwinterpolation.FrameInterpolation;
import org.example.frontend.hwquadequations.FrameQuadEquations;
import org.example.frontend.hwlinearsystems.FrameLinearSystems;

import javax.swing.*;
import java.awt.*;

public class Mainframe extends FrameVichfizFullScreen {
    private JMenuBar menuBar;
    private JMenu menuOpenHomework;
    private MenuItemFrameOpener menuItemExcel;
    private MenuItemFrameOpener menuItemHarmonicSeries;
    private MenuItemFrameOpener menuItemQuadEquations;
    private MenuItemFrameOpener menuItemLinearSystems;
    private MenuItemFrameOpener menuItemInterpolation;
    private JTextArea textAreaDescription;
    private FrameExcel frameExcel;
    private FrameHarmonicSeries frameHarmonicSeries;
    private FrameQuadEquations frameQuadEquations;
    private FrameLinearSystems frameLinearSystems;
    private FrameInterpolation frameInterpolation;
    private final String description = "Это программа для демонстрации выполненных домашних заданий" +
            " по вычислительной физике Дубровским Н. В. 23Ф191-1 (2021-2022 учебный год).";

    public Mainframe() throws HeadlessException {
        super("Вычислительная физика");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();

        menuOpenHomework = new JMenu("Выбор задания");
        menuItemExcel = new MenuItemFrameOpener("Excel",
                frameExcel,
                FrameExcel.class);
        menuItemHarmonicSeries = new MenuItemFrameOpener("Суммы рядов",
                frameHarmonicSeries,
                FrameHarmonicSeries.class);
        menuItemQuadEquations = new MenuItemFrameOpener("Квадратные уравнения",
                frameQuadEquations,
                FrameQuadEquations.class);
        menuItemLinearSystems = new MenuItemFrameOpener("Линейные уравнения",
                frameLinearSystems,
                FrameLinearSystems.class);
        menuItemInterpolation = new MenuItemFrameOpener("Интерполяция",
                frameInterpolation,
                FrameInterpolation.class);

        menuOpenHomework.add(menuItemExcel);
        menuOpenHomework.add(menuItemHarmonicSeries);
        menuOpenHomework.add(menuItemQuadEquations);
        //menuOpenHomework.add(menuItemLinearSystems);
        menuOpenHomework.add(menuItemInterpolation);

        menuBar.add(menuOpenHomework);

        setJMenuBar(menuBar);

        textAreaDescription = new JTextArea(description);
        textAreaDescription.setEditable(false);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setMaximumSize(new Dimension(screenSize.width / 3, screenSize.height / 3));

        Container contentPane = getContentPane();
        GroupLayout layout = new GroupLayout(contentPane);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(textAreaDescription)
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(textAreaDescription)
        );
        contentPane.setLayout(layout);
    }
}
