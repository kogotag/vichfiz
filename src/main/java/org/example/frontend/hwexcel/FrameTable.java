package org.example.frontend.hwexcel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FrameTable extends JFrame {
    private String[][] table;
    private JTable jTable;
    private JLabel labelError;

    public FrameTable(String title, String[][] table) throws HeadlessException {
        super(title);
        this.table = table;
        if (table != null && table.length > 0) {
            String[] header = createEmptyColumnNames(table[0].length);
            jTable = new JTable(table, header);
            getContentPane().add(jTable);
        } else {
            labelError = new JLabel("Ошибка: таблица не имеет строк или null");
            getContentPane().add(labelError);
        }
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }

    private String[] createEmptyColumnNames(int size) {
        String[] names = new String[size];
        java.util.List<String> s = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            s.add("");
        }
        s.toArray(names);
        return names;
    }
}
