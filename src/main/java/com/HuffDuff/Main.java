package com.HuffDuff;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {
        JFrame win = new JFrame();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setResizable(false);
        win.add(new DemoClass(x,y));

        win.pack();
        win.setLocationRelativeTo(null);
        win.setVisible(true);
    }
}
