/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.form;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import math.Math;

/**
 *
 * @author Win10
 */
public class FCalculator extends JFrame{
    
    JLabel jLblA;
    JLabel jLblB;
    JLabel jLblC; //rezultat
    
    JTextField jTxtA;
    JTextField jTxtB;
    JTextField jTxtC; //rezultat
    
    JButton jBtnAdd;
    JButton jBtnSub;

    public FCalculator() {
        initComponents();
        prepareForm();
    }
   
    public void initComponents() {
        jLblA = new JLabel("a:");
        jLblB = new JLabel("b:");
        jLblC = new JLabel("c:");
        
        jTxtA = new JTextField();
        jTxtB = new JTextField();
        jTxtC = new JTextField();
        jTxtC.setEditable(false);
        
        jBtnAdd = new JButton("+");
        jBtnSub = new JButton("-");
        
        jLblA.setBounds(40, 10, 50, 30);
        jLblB.setBounds(40, 55, 50, 30);
        jLblC.setBounds(40, 100, 50, 30);
        
        jTxtA.setBounds(120, 10, 100, 30);
        jTxtB.setBounds(120, 55, 100, 30);
        jTxtC.setBounds(120, 100, 100, 30);
        
        jBtnAdd.setBounds(50, 200, 50, 30);
        jBtnSub.setBounds(150, 200, 50, 30);
        
        Container container = getContentPane();
        container.setLayout(null);
        
        container.add(jLblA);
        container.add(jLblB);
        container.add(jLblC);
        container.add(jTxtA);
        container.add(jTxtB);
        container.add(jTxtC);
        container.add(jBtnAdd);
        container.add(jBtnSub);
        
        /*jBtnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jBtnAddActionPerformed(e);
            }
        });*/
        
        jBtnAdd.addActionListener((ActionEvent e) -> {
            jBtnAddActionPerformed(e);
        });
        
        
        jBtnSub.addActionListener((ActionEvent e) -> {
            jBtnSubActionPerformed(e);
        });
    }
    
    public void prepareForm() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(500, 500, 270, 350);
        setResizable(false);
        setTitle("Add/Sub");
        setLocationRelativeTo(null);
    }
    
    private void jBtnAddActionPerformed(ActionEvent e) {
        double a, b, c;
        
        a = Double.parseDouble(jTxtA.getText());
        b = Double.parseDouble(jTxtB.getText());
        
        c = Math.addition(a, b);
        jTxtC.setText(c+"");
    }
    
    private void jBtnSubActionPerformed(ActionEvent e) {
        double a, b, c;
        
        a = Double.parseDouble(jTxtA.getText());
        b = Double.parseDouble(jTxtB.getText());
        
        c = Math.subtraction(a, b);
        System.out.println("c: "+c);
        jTxtC.setText(c+"");
    }
    
}
