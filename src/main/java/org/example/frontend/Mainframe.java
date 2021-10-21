package org.example.frontend;

import org.example.frontend.hwexcel.FrameHomeworkExcel;
import org.example.frontend.hwharmonicseries.FrameHarmonicSeries;
import org.example.frontend.hwinterpolation.FrameInterpolation;
import org.example.frontend.hwquadequations.FrameQuadEquations;
import org.example.hwlinearsystems.FrameLinearSystems;

import javax.swing.*;
import java.awt.*;

public class Mainframe extends FrameVichfizFullScreen {
    private JMenuBar menuBar;
    private JMenu menuOpenHomework;
    private JMenuItem menuItemExcel;
    private JMenuItem menuItemHarmonicSeries;
    private JMenuItem menuItemQuadEquations;
    private JMenuItem menuItemLinearSystems;
    private JMenuItem menuItemInterpolation;
    private FrameHomeworkExcel frameHomeworkExcel;
    private FrameHarmonicSeries frameHarmonicSeries;
    private FrameQuadEquations frameQuadEquations;
    private FrameLinearSystems frameLinearSystems;
    private FrameInterpolation frameInterpolation;

    public Mainframe() throws HeadlessException {
        super("Вычислительная физика");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();

        menuOpenHomework = new JMenu("Выбор задания");
        menuItemExcel = new JMenuItem("Excel");
        menuItemHarmonicSeries = new JMenuItem("Суммы рядов");
        menuItemQuadEquations = new JMenuItem("Квадратные уравнения");
        menuItemLinearSystems = new JMenuItem("Линейные уравнения");
        menuItemInterpolation = new JMenuItem("Интерполяция");

        menuItemExcel.addActionListener(new MenuItemExcelListener(frameHomeworkExcel));
        menuItemHarmonicSeries.addActionListener(new MenuItemHarmonicSeriesListener((frameHarmonicSeries)));
        menuItemQuadEquations.addActionListener(new MenuItemQuadEquationsListener(frameQuadEquations));
        menuItemLinearSystems.addActionListener(new MenuItemLinearSystemsListener(frameLinearSystems));
        menuItemInterpolation.addActionListener((new MenuItemInterpolationListener(frameInterpolation)));

        menuOpenHomework.add(menuItemExcel);
        menuOpenHomework.add(menuItemHarmonicSeries);
        menuOpenHomework.add(menuItemQuadEquations);
        menuOpenHomework.add(menuItemLinearSystems);
        menuOpenHomework.add(menuItemInterpolation);

        menuBar.add(menuOpenHomework);

        setJMenuBar(menuBar);
    }
}
