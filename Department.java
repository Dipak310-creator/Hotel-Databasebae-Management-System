package Hotel_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame implements ActionListener {

    JButton b1,b2;
    JTable t1;

    public Department(){
        JLabel l1=new JLabel("Department");
        l1.setBounds(90,10,120,20);
        add(l1);


        JLabel l2=new JLabel("Budget");
        l2.setBounds(350,10,70,20);
        add(l2);

        t1=new JTable();
        t1.setBounds(0,40,500,300);
        add(t1);

        b1=new JButton("Submit");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(100,370,100,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(310,370,100,30);
        b2.addActionListener(this);
        add(b2);



        setBounds(320,150,500,500);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                Config c = new Config();
                String str="select * from department";
                ResultSet rs =c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                System.out.println(e);
            }

        }else if(ae.getSource()==b2){
            this.setVisible(false);
            new Reception().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new Department().setVisible(true);
    }
}
