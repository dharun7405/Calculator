import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Calculator {
    int boardWidth=360;
    int boardHeight=540;

    Color LightGrey =new Color(212,212,210);
    Color DarkGrey=new Color(80,80,80);
    Color Black=new Color(28,28,28);
    Color Orange=new Color(255,149,0);

    JFrame frame =new JFrame("Calculator");

    Calculator(){
        frame.setVisible(true);
        frame.setSize(boardWidth,boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    }
}
