/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworlda;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class HelloWorldA extends JFrame{
    
  private javax.swing.JButton jButton1;  
  
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Plain Window");
        frame.setSize(280,400);
        frame.setVisible(true);
        
        jButton1 = new javax.swing.JButton();
        jButton1.setText("jButton1.text");
        jButton1.setName("jButton1"); 
        frame.add(jButton1);
        
    }

}
