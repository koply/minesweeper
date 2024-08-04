package org.hsdfirat.minesweeper;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        OyunCercevesi game = new OyunCercevesi();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
    }

}
