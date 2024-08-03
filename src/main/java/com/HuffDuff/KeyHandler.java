package com.HuffDuff;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener{

    DemoClass dc;

    public KeyHandler(DemoClass dc){
        this.dc = dc;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_ENTER){
            dc.search();
        }
        else if (true){
            dc.autoSearch();
        }
    }
    

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
