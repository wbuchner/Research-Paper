/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorincode;

/**
 *
 * @author wayne
 */

import java.awt.*;
import javax.swing.*;


public class CalculatorInCode {
    private static double operandOne;
    private static double operandTwo; 
    private static boolean operationPressed;
    private static String operator;
    private static javax.swing.JTextField jTextField1;
    private String[] keys = {"1","2","3","4","5","6","7","8","9","10"};
    private String[] exp = {"+","-","="};
    private JButton[] btnKeyPad = new JButton[keys.length];
    private JButton[] btnExp = new JButton[exp.length];
    
    public static void main(String[] args) {
        
        CalculatorInCode app = new CalculatorInCode();
        app.initComponents();
        
    
    }
    
   public void initComponents(){
       System.out.print("Hello World");
       Container cn;
        JFrame frame = new JFrame("Simple Calculator In Code");
        frame.setSize(300,450);
        frame.setVisible(true);
        frame.setLayout(null);
        jTextField1 = new javax.swing.JTextField();
        jTextField1.setText("0"); 
        jTextField1.setName("display"); 
        jTextField1.setLocation(50,50);
        jTextField1.setSize(200, 50);
        
        cn = frame.getContentPane();
        cn.add(jTextField1);
        
        layOutButtons(frame);

   }
  
   public static double performOperation(){
    double result;
    
    if ("+".equals(operator)){
        result = operandOne + operandTwo;
    } else {
        result = operandOne - operandTwo;
    }
   
    
    return result;
}
   
   public JButton addButton(int xPos, int yPos, int count, int i)
   {
        btnKeyPad[i] = new JButton(""+count);
        btnKeyPad[i].setSize(47, 38);
        btnKeyPad[i].setLocation(xPos,yPos);
        btnKeyPad[i].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                digitPressed(evt);
            }
        });              
        return btnKeyPad[i];
   }
 
   public JButton addExpression(int xPos, int yPos, String name,int i)
   {
        
        btnExp[i] = new JButton(name);
        btnExp[i].setSize(47, 38);
        btnExp[i].setLocation(xPos,yPos);
        
        if(!"AC".equals(name)){
        btnExp[i].addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operationPressed(evt);
            }
        });
        }else{
         btnExp[i].addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clean(evt);
            }
        });           
        }
        
        return btnExp[i];
   }
      
   public  void layOutButtons(JFrame cn)
   {
       int xSpace = 50;
       for (int i = 1; i < 4; i ++){
           cn.add(addButton(xSpace,250,i,i));
           cn.add(addButton(xSpace,200,i+3,i+3));
           cn.add(addButton(xSpace,150,i+6,i+6));
        xSpace = xSpace+50;
       }
       
       cn.add(addButton(50,300,0,0));
       cn.add(addExpression(200, 150, exp[0], 0));
       cn.add(addExpression(200, 200, exp[1], 0));
       cn.add(addExpression(200, 250, exp[2], 0));
       cn.add(addExpression(200, 300, "AC", 0));
   }
   
   private static void digitPressed(java.awt.event.MouseEvent evt) {                              
    JButton btn = (JButton)evt.getSource();
    
    if (!operationPressed) {
        operandOne = Double.parseDouble(btn.getText());
        jTextField1.setText(Double.toString(operandOne));
    }else{
        operandTwo = Double.parseDouble(btn.getText());
       // System.out.print(operandOne);
        jTextField1.setText(Double.toString(operandTwo));
    }
}
   
   private static void operationPressed(java.awt.event.ActionEvent evt) {                                  
    operationPressed = true;
    JButton btn = (JButton)evt.getSource();
    if ("=".equals(btn.getText())){
        jTextField1.setText(Double.toString(performOperation()));
    }else{
        operator = btn.getText();
         System.out.print(btn.getText());
    }
} 
   
    private void clean(java.awt.event.ActionEvent evt) {                       
    operationPressed = false;
    operandOne = 0;
    operandTwo = 0;
    operator = "";
    
    jTextField1.setText("0");
    }  
}
