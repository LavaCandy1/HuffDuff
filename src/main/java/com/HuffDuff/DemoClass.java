package com.HuffDuff;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;


public class DemoClass extends JPanel{
    //SCREEN SETTINGS
    final int maxRow = 13;
    final int maxCol = 33;
    final int nodeSize = 50;
    final int screenWidth = maxCol*nodeSize;
    final int screenHeight = maxRow*nodeSize;
    int steps = 0;

    //NODE
    Node[][] node = new Node[maxCol][maxRow];
    Node startNode,endNode,currentNode;
    ArrayList<Node> openList = new ArrayList<>();
    ArrayList<Node> checkList = new ArrayList<>();
    ArrayList<Integer> pathListX = new ArrayList<>();
    ArrayList<Integer> pathListY = new ArrayList<>();
    ArrayList<String> pathList = new ArrayList<>();
    

    boolean destination = false;

    public String DemoClass1(int xEndNode,int yEndNode){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setLayout(new GridLayout(maxRow,maxCol));
        this.addKeyListener(new KeyHandler(this));
        this.setFocusable(true);

        //PLACING NODES
        int colPainter = 0;
        int rowPainter = 0;
        while(colPainter<maxCol && rowPainter<maxRow){
            node[colPainter][rowPainter] = new Node(colPainter, rowPainter);
            this.add(node[colPainter][rowPainter]);
            colPainter++;
            if (colPainter == maxCol){
                colPainter = 0;
                rowPainter++;
            }
        }
        //SET START AND GOAL NODE   
        setStartNode(14, 3);
        //setStartNode(18,9);
        setEndNode(xEndNode, yEndNode);
        

        setWallNode(0,0);
        setWallNode(1,0);
        setWallNode(2,0);
        setWallNode(3,0);
        setWallNode(4,0);
        setWallNode(5,0);
        setWallNode(6,0);
        setWallNode(7,0);
        setWallNode(8,0);
        setWallNode(9,0);
        setWallNode(10,0);
        setWallNode(11,0);
        setWallNode(12,0);
        setWallNode(13,0);
        setWallNode(14,0);
        setWallNode(15,0);
        setWallNode(16,0);
        setWallNode(17,0);
        setWallNode(18,0);
        setWallNode(19,0);
        setWallNode(20,0);
        setWallNode(21,0);
        setWallNode(22,0);
        setWallNode(23,0);
        setWallNode(24,0);
        setWallNode(25,0);
        setWallNode(26,0);
        setWallNode(27,0);
        setWallNode(28,0);
        setWallNode(29,0);
        setWallNode(30,0);
        setWallNode(31,0);
        setWallNode(32,0);
        
        //B block 
        //------------------------------------------------------1st Floor Start------------------------------------------------------
        
        setWallNode(0,1);setWallNode(1,1);setWallNode(2,1);setWallNode(3,1);setWallNode(4,1);setWallNode(5,1);setWallNode(6,1);setWallNode(7,1);setWallNode(8,1);setWallNode(9,1);setWallNode(10,1);setWallNode(11,1);setWallNode(12,1);setWallNode(13,1);setWallNode(14,1);setWallNode(15,1);setWallNode(16,1);setWallNode(17,1);setWallNode(18,1);setWallNode(19,1);setWallNode(20,1);setWallNode(21,1);setWallNode(22,1);setWallNode(23,1);setWallNode(24,1);setWallNode(25,1);setWallNode(26,1);setWallNode(27,1);setWallNode(28,1);setWallNode(29,1);setWallNode(30,1);setWallNode(31,1);setWallNode(32,1);
        setWallNode(0,2);setWallNode(1,2);setWallNode(2,2);setWallNode(3,2);setWallNode(4,2);setWallNode(5,2);setWallNode(6,2);setWallNode(7,2);setWallNode(8,2);setWallNode(9,2);setWallNode(10,2);setWallNode(11,2);setWallNode(12,2);setWallNode(13,2);setWallNode(14,2);setWallNode(15,2);setWallNode(16,2);setWallNode(17,2);setWallNode(18,2);setWallNode(19,2);setWallNode(20,2);setWallNode(21,2);setWallNode(22,2);setWallNode(23,2);setWallNode(24,2);setWallNode(25,2);setWallNode(26,2);setWallNode(27,2);setWallNode(28,2);setWallNode(29,2);setWallNode(30,2);setWallNode(31,2);setWallNode(32,2);
        setWallNode(0,3);setWallNode(1,3);setWallNode(2,3);;setWallNode(5,3);setWallNode(7,3);setWallNode(8,3);setWallNode(9,3);setWallNode(10,3);setWallNode(11,3);setWallNode(13,3);setWallNode(15,3);setWallNode(16,3);setWallNode(18,3);setWallNode(19,3);setWallNode(21,3);setWallNode(22,3);setWallNode(24,3);setWallNode(25,3);setWallNode(27,3);setWallNode(30,3);setWallNode(31,3);setWallNode(32,3);
        setWallNode(0,5);setWallNode(1,5);setWallNode(2,5);setWallNode(3,5);setWallNode(5,5);setWallNode(6,5);setWallNode(7,5);setWallNode(9,5);setWallNode(10,5);setWallNode(11,5);setWallNode(12,5);setWallNode(13,5);setWallNode(15,5);setWallNode(16,5);setWallNode(17,5);setWallNode(18,5);setWallNode(19,5);setWallNode(20,5);setWallNode(22,5);setWallNode(23,5);setWallNode(24,5);setWallNode(25,5);setWallNode(26,5);setWallNode(27,5);setWallNode(29,5);setWallNode(30,5);setWallNode(31,5);setWallNode(32,5);
        setWallNode(0,6);setWallNode(1,6);setWallNode(2,6);setWallNode(3,6);setWallNode(5,6);setWallNode(6,6);setWallNode(7,6);setWallNode(8,6);setWallNode(9,6);setWallNode(10,6);setWallNode(11,6);setWallNode(12,6);setWallNode(13,6);setWallNode(14,6);setWallNode(15,6);setWallNode(16,6);setWallNode(17,6);setWallNode(18,6);setWallNode(19,6);setWallNode(20,6);setWallNode(21,6);setWallNode(22,6);setWallNode(23,6);setWallNode(24,6);setWallNode(25,6);setWallNode(26,6);setWallNode(27,6);setWallNode(29,6);setWallNode(30,6);setWallNode(31,6);setWallNode(32,6);
        setWallNode(0,7);setWallNode(1,7);setWallNode(2,7);setWallNode(3,7);setWallNode(5,7);setWallNode(6,7);setWallNode(7,7);setWallNode(8,7);setWallNode(9,7);setWallNode(10,7);setWallNode(12,7);setWallNode(13,7);setWallNode(14,7);setWallNode(15,7);setWallNode(16,7);setWallNode(17,7);setWallNode(19,7);setWallNode(20,7);setWallNode(21,7);setWallNode(22,7);setWallNode(23,7);setWallNode(24,7);setWallNode(25,7);setWallNode(27,7);setWallNode(29,7);setWallNode(30,7);setWallNode(31,7);setWallNode(32,7);
        setWallNode(0,9);setWallNode(1,9);setWallNode(2,9);setWallNode(5,9);setWallNode(7,9);setWallNode(9,9);setWallNode(10,9);setWallNode(12,9);setWallNode(14,9);setWallNode(15,9);setWallNode(16,9);setWallNode(17,9);setWallNode(19,9);setWallNode(21,9);setWallNode(22,9);setWallNode(24,9);setWallNode(25,9);setWallNode(27,9);setWallNode(30,9);setWallNode(31,9);setWallNode(32,9);
        setWallNode(0,10);setWallNode(1,10);setWallNode(2,10);setWallNode(3,10);setWallNode(4,10);setWallNode(5,10);setWallNode(6,10);setWallNode(7,10);setWallNode(8,10);setWallNode(9,10);setWallNode(10,10);setWallNode(11,10);setWallNode(12,10);setWallNode(13,10);setWallNode(14,10);setWallNode(15,10);setWallNode(16,10);setWallNode(17,10);setWallNode(18,10);setWallNode(19,10);setWallNode(20,10);setWallNode(21,10);setWallNode(22,10);setWallNode(23,10);setWallNode(24,10);setWallNode(25,10);setWallNode(26,10);setWallNode(27,10);setWallNode(28,10);setWallNode(29,10);setWallNode(30,10);setWallNode(31,10);setWallNode(32,10);
        setWallNode(0,11);setWallNode(1,11);setWallNode(2,11);setWallNode(3,11);setWallNode(4,11);setWallNode(5,11);setWallNode(6,11);setWallNode(7,11);setWallNode(8,11);setWallNode(9,11);setWallNode(10,11);setWallNode(11,11);setWallNode(12,11);setWallNode(13,11);setWallNode(14,11);setWallNode(15,11);setWallNode(16,11);setWallNode(17,11);setWallNode(18,11);setWallNode(19,11);setWallNode(20,11);setWallNode(21,11);setWallNode(22,11);setWallNode(23,11);setWallNode(24,11);setWallNode(25,11);setWallNode(26,11);setWallNode(27,11);setWallNode(28,11);setWallNode(29,11);setWallNode(30,11);setWallNode(31,11);setWallNode(32,11);
        setWallNode(0,12);setWallNode(1,12);setWallNode(2,12);setWallNode(3,12);setWallNode(4,12);setWallNode(5,12);setWallNode(6,12);setWallNode(7,12);setWallNode(8,12);setWallNode(9,12);setWallNode(10,12);setWallNode(11,12);setWallNode(12,12);setWallNode(13,12);setWallNode(14,12);setWallNode(15,12);setWallNode(16,12);setWallNode(17,12);setWallNode(18,12);setWallNode(19,12);setWallNode(20,12);setWallNode(21,12);setWallNode(22,12);setWallNode(23,12);setWallNode(24,12);setWallNode(25,12);setWallNode(26,12);setWallNode(27,12);setWallNode(28,12);setWallNode(29,12);setWallNode(30,12);setWallNode(31,12);setWallNode(32,12);
        
        setWallNode(0, 4);setWallNode(1, 4);setWallNode(2, 4);setWallNode(3, 4);setWallNode(29, 4);setWallNode(30, 4);setWallNode(31, 4);setWallNode(32, 4);
        setWallNode(0, 8);setWallNode(1, 8);setWallNode(2, 8);setWallNode(3, 8);setWallNode(29, 8);setWallNode(30, 8);setWallNode(31, 8);setWallNode(32, 8);
        
        //------------------------------------------------------1st Floor End------------------------------------------------------ 
        

        //CALCULATING DISTANCES
        setNodeDist();
        autoSearch();
        System.out.println(pathList);
        input obj1 = new input();
        obj1.pathListOut(pathList);
        String outputPath = "\"14-3\": [0,2],";
		for (int i=0;i<pathList.size();i++) {
			outputPath += "\""+pathList.get(i)+"\""+": [0,0],";
		}
		outputPath += "\""+xEndNode+"-"+yEndNode+"\""+": [0,4]";
		System.out.println(outputPath);
		return outputPath;

    }
    public void setStartNode(int col,int row){
        node[col][row].setAsStart();
        startNode = node[col][row];
        currentNode = startNode;
    }
    public void setEndNode(int col,int row){
        node[col][row].setAsEnd();
        endNode = node[col][row];
    }
    public void setWallNode(int col,int row){
        node[col][row].setAsWall();
    }
    public void setNodeDist(){
        int col = 0;
        int row = 0;
        while(col<maxCol && row<maxRow){
            getDist(node[col][row]);
            col++;
            if (col == maxCol){
                col = 0;
                row++;
            }
        }
    }


    public void getDist(Node node){

        //DIST. B/W START AND CURRENT NODE
        int xdis = Math.abs(node.col - startNode.col);
        int ydis = Math.abs(node.row - startNode.row);
        node.stCurDis = xdis + ydis;
        

        //DIST. B/W START AND CURRENT NODE
        xdis = Math.abs(node.col - endNode.col);
        ydis = Math.abs(node.row - endNode.row);
        node.enCurDis = xdis + ydis;
        

        //SETTING TOTAL DISTANCE
        node.totDis = node.stCurDis + node.enCurDis;

        if (node != startNode && node != endNode){
            node.setText("<HTML>E : "+node.enCurDis+"<br>T : "+node.totDis);
        }
    }
    public void search(){
        if (destination == false){
            int col = currentNode.col;
            int row = currentNode.row;

            currentNode.setAsChecked();
            checkList.add(currentNode);
            openList.remove(currentNode);

            if (row-1 >=0)
            openNode(node[col][row-1]);
            if (col-1 >=0)
            openNode(node[col-1][row]);
            if (row+1 < maxRow)
            openNode(node[col][row+1]);
            if (col+1 < maxCol)
            openNode(node[col+1][row]);

            //FINDING BEST NODE 
            int bestNodeIndex = 0;
            int bestNodeTotDis = 999999;


            for (int i=0;i<openList.size();i++){
                if (openList.get(i).totDis < bestNodeTotDis){
                    bestNodeIndex = i;
                    bestNodeTotDis = openList.get(i).totDis;
                }
                else if(openList.get(i).totDis == bestNodeTotDis){
                    if (openList.get(i).enCurDis < openList.get(bestNodeIndex).enCurDis){
                        bestNodeIndex = i;
                    }
                }
            }
            currentNode = openList.get(bestNodeIndex);
            if (currentNode==endNode){
                destination = true;
                trackThePath();
            }
        }
    }
    public void autoSearch(){
        while(destination == false && steps<10000){
            int col = currentNode.col;
            int row = currentNode.row;
            

            currentNode.setAsChecked();
            checkList.add(currentNode);
            openList.remove(currentNode);

            if (row-1 >=0)
            openNode(node[col][row-1]);
            if (col-1 >=0)
            openNode(node[col-1][row]);
            if (row+1 < maxRow)
            openNode(node[col][row+1]);
            if (col+1 < maxCol)
            openNode(node[col+1][row]);


            //FINDING BEST NODE 
            int bestNodeIndex = 0;
            int bestNodeTotDis = 999999;


            for (int i=0;i<openList.size();i++){
                if (openList.get(i).totDis < bestNodeTotDis){
                    bestNodeIndex = i;
                    bestNodeTotDis = openList.get(i).totDis;
                }
                else if(openList.get(i).totDis == bestNodeTotDis){
                    if (openList.get(i).enCurDis < openList.get(bestNodeIndex).enCurDis){
                        bestNodeIndex = i;
                    }
                }
            }
            
            currentNode = openList.get(bestNodeIndex);
            if (currentNode==endNode){
                destination = true;
                trackThePath();
                
                
            }
            
            steps++;
        }
    }

    private void openNode(Node node){
        if (node.air == false && node.checked == false && node.wall == false){
            node.setAsOpen();
            node.parent = currentNode;
            openList.add(node);
        }
    }
    private void trackThePath(){
        Node current  = endNode;
        while(current != startNode){
            current = current.parent;
            if (current != startNode){
                current.setAsPath();
                String path = String.valueOf(current.col)+"-"+String.valueOf(current.row);
                pathListX.add(current.col);
                pathListY.add(current.row);
                pathList.add(path);
                
            }
        }

    }
}
