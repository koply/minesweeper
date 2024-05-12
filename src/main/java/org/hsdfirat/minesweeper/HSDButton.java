package org.hsdfirat.minesweeper;

import javax.swing.*;

public class HSDButton extends JButton {

    int row, column, point;
    boolean mine, flag;

    // row - x - satir
    // column - y - sutun
    public HSDButton(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public HSDButton() {
    }

    public boolean isMine(){
        return mine;
    }
}
