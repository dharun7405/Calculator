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
    JLabel displayLabel=new JLabel();
    JPanel displayPanel=new JPanel();
    JPanel buttonsPanel=new JPanel();

    String[] buttonValues = {
            "AC", "+/-", "%", "÷",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "√", "="
    };
    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};

    String A="0";
    String operator=null;
    String B=null;

    Calculator(){
        frame.setVisible(true);
        frame.setSize(boardWidth,boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        displayLabel.setBackground(Black);
        displayLabel.setForeground(Color.white);
        displayLabel.setFont(new Font("Arial",Font.PLAIN,80));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);
        frame.add(displayPanel,BorderLayout.NORTH);

        buttonsPanel.setLayout(new GridLayout(5,4));
        buttonsPanel.setBackground(Black);
        frame.add(buttonsPanel);

        for(String Value:buttonValues){
            JButton button = new JButton();
            String buttonValue;
            buttonValue = Value;
            button.setFont(new Font("Arial",Font.PLAIN,30));
            button.setText(buttonValue);
            button.setFocusable(false);
            button.setBorder(new LineBorder(Black));

            if(Arrays.asList(topSymbols).contains(buttonValue)){
                button.setBackground(LightGrey);
                button.setForeground(Black);
            }
            else if(Arrays.asList(rightSymbols).contains(buttonValue)){
                button.setBackground(Orange);
                button.setForeground(Color.white);
            }
            else{
                button.setBackground(DarkGrey);
                button.setForeground(Color.white);
            }

            buttonsPanel.add(button);
            button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    JButton button = (JButton)e.getSource();
                    String buttonValue=button.getText();
                    if(Arrays.asList(rightSymbols).contains(buttonValue)){

                    }
                    else if(Arrays.asList(topSymbols).contains(buttonValue)){
                        switch (buttonValue) {
                            case "AC" -> {
                                clearAll();
                                displayLabel.setText("0");
                            }
                            case "+/-" -> {
                                double numDisplay = Double.parseDouble(displayLabel.getText());
                                numDisplay *= -1;
                                displayLabel.setText(removeZeroDecimal(numDisplay));
                            }
                            case "%" -> {
                                double numDisplay = Double.parseDouble(displayLabel.getText());
                                numDisplay /= 100;
                                displayLabel.setText(removeZeroDecimal(numDisplay));
                            }
                        }
                    }
                    else{
                        if(buttonValue.equals(".")){
                            if(!displayLabel.getText().contains(buttonValue)){
                                displayLabel.setText(displayLabel.getText() + buttonValue);
                            }
                        }
                        else if("0123456789".contains(buttonValue)){
                            if(displayLabel.getText().equals("0")){
                                displayLabel.setText(buttonValue);
                            }
                            else{
                                displayLabel.setText(displayLabel.getText() + buttonValue);
                            }
                        }
                    }
                }
            });
        }
    }

    void clearAll(){
        A="0";
        operator=null;
        B=null;
    }

    String removeZeroDecimal(double numDisplay){
        if(numDisplay%1==0){
            return Integer.toString((int) numDisplay);
        }
        return Double.toString(numDisplay);
    }
}
