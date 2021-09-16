package org.example.frontend;

import org.example.frontend.hwexcel.FrameHomeworkExcel;
import org.example.frontend.hwharmonicseries.FrameHarmonicSeries;
import org.example.frontend.hwquadequations.FrameQuadEquations;

import javax.swing.*;
import java.awt.*;

public class Mainframe extends JFrame {
    private JMenuBar menuBar;
    private JMenu menuOpenHomework;
    private JMenuItem menuItemExcel;
    private JMenuItem menuItemHarmonicSeries;
    private JMenuItem menuItemQuadEquations;
    private FrameHomeworkExcel frameHomeworkExcel;
    private FrameHarmonicSeries frameHarmonicSeries;
    private FrameQuadEquations frameQuadEquations;

    public Mainframe() throws HeadlessException {
        super("Вычислительная физика");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, (int) dim.width / 3, (int) dim.height / 3);
        setVisible(true);
        setLocationRelativeTo(null);
        menuBar = new JMenuBar();
        menuOpenHomework = new JMenu("Выбор задания");
        menuItemExcel = new JMenuItem("Excel");
        menuItemHarmonicSeries = new JMenuItem("Суммы рядов");
        menuItemQuadEquations = new JMenuItem("Квадратные уравнения");
        menuOpenHomework.add(menuItemExcel);
        menuOpenHomework.add(menuItemHarmonicSeries);
        menuOpenHomework.add(menuItemQuadEquations);
        menuBar.add(menuOpenHomework);
        setJMenuBar(menuBar);
        menuItemExcel.addActionListener(new MenuItemExcelListener(frameHomeworkExcel));
        menuItemHarmonicSeries.addActionListener(new MenuItemHarmonicSeriesListener((frameHarmonicSeries)));
        menuItemQuadEquations.addActionListener(new MenuItemQuadEquationsListener(frameQuadEquations));
    }
}
