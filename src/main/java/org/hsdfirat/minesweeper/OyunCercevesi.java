package org.hsdfirat.minesweeper;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class OyunCercevesi extends JFrame {

    public static final int GENISLIK = 10;
    public static final int YUKSEKLIK = 10;
    public static final int MAYIN_SAYISI = 10;
    HSDButton[][] hsdButtons = new HSDButton[YUKSEKLIK][GENISLIK];

    public OyunCercevesi() {
        setSize(800, 800);
        setTitle("HSD Mayın");
        setLayout(new GridLayout(10, 10));

        for (int i = 0; i < YUKSEKLIK; i++) {
            for (int j = 0; j < GENISLIK; j++) {
                hsdButtons[i][j] = new HSDButton(i, j);
                add(hsdButtons[i][j]);
            }
        }

        mayinYerlestir();
        puanlariEkle();
        herSeyiGoster();
    }

    void mayinYerlestir() {
        for (int i = 0; i < MAYIN_SAYISI; i++) {
            Random rastgele = new Random();
            int x = rastgele.nextInt(10);
            int y = rastgele.nextInt(10);
            hsdButtons[x][y].mine = true;
        }
    }

    void puanlariEkle() {
        for (int i = 0; i < YUKSEKLIK; i++) {
            for (int j = 0; j < GENISLIK; j++) {
                int puan = cevreKontrol(i, j);
                hsdButtons[i][j].point = puan;
            }
        }
    }

    int cevreKontrol(int x, int y) {
        int baslangic_x = Math.max(x - 1, 0);
        int baslangic_y = Math.max(y - 1, 0);
        int bitis_x = Math.min(x+1, GENISLIK-1);
        int bitis_y = Math.min(y+1, YUKSEKLIK-1);

        int puan = 0;
        for (int i = baslangic_x; i<=bitis_x; i++) {
            for (int j = baslangic_y; j<=bitis_y; j++) {
                if (i == x && j == y) continue;
                if (hsdButtons[i][j].mine) {
                    puan++;
                }
            }
        }
        return puan;

    }

    void herSeyiGoster() {
        for (int i = 0; i < YUKSEKLIK; i++) {
            for (int j = 0; j < GENISLIK; j++) {
                if (hsdButtons[i][j].mine) {
                    hsdButtons[i][j].setText("mayin");
                } else {
                    hsdButtons[i][j].setText(hsdButtons[i][j].point + "");
                }
            }
        }
    }

}

