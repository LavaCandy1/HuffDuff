package com.HuffDuff;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Node extends JButton implements ActionListener{

    Node parent;
    int row;
    int col;
    int stCurDis;
    int enCurDis;
    int totDis;
    boolean start;
    boolean end;
    boolean wall;
    boolean air;
    boolean checked;
    
    public Node(int col,int row){
        this.col = col;
        this.row = row;
        setBackground(Color.white);
        setForeground(Color.black);
        addActionListener(this);
    }
    public void setAsStart(){
        setBackground(Color.blue);
        setForeground(Color.white);
        setText("Start");
        start = true;
    }
    public void setAsEnd(){
        setBackground(Color.green);
        setForeground(Color.white);
        setText("End");
        end = true;
    }
    public void setAsWall(){
        setBackground(Color.black);
        setForeground(Color.black);
        wall = true;
    }
    public void setAsOpen(){
        air = true;
    }
    public void setAsChecked(){
        if (start == false && end == false){
            setBackground(Color.orange);
            setForeground(Color.black);
        }
        checked = true;
    }
    public void setAsPath(){
        setBackground(Color.green);
        setForeground(Color.black);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setBackground(Color.orange);
        
        
    }
    
}
