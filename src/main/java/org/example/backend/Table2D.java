package org.example.backend;

import java.lang.reflect.Array;

public class Table2D<K> {
    /** length is a size of first dimension of the table */
    private int length;

    /** width is a size of second dimension of the table */
    private int width;

    private K[][] table;
    Class<? extends K> cls;

    public Table2D(Class<? extends K> cls, int length, int width) {
        this.length = length;
        this.cls = cls;
        table = (K[][]) Array.newInstance(cls, length, width);
    }

    public Table2D(K[][] abstractTable) {
        length = abstractTable.length;
        width = getMinWidth(abstractTable);
        table = abstractTable;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public K[][] getTable() {
        return table;
    }

    public void setTable(K[][] table) {
        this.table = table;
        length = getMinWidth(table);
    }

    private <T> int getMinWidth(T[][] abstractTable) {
        if (abstractTable.length == 0) {
            return 0;
        }
        int minWidth = abstractTable[0].length;
        for (T[] s :
                abstractTable) {
            if (s.length < minWidth) {
                minWidth = s.length;
            }
        }
        return minWidth;
    }
}
