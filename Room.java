package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener {
    JTable t1;
    JButton b1,b2;

    public Room(){

        t1= new JTable();
        t1.setBounds(5,40,674,450);
        add(t1);

        JLabel l1=new JLabel("Room No");
        l1.setBounds(50,10,70,20);
        add(l1);

        JLabel l2=new JLabel("Available");
        l2.setBounds(186,10,70,20);
        add(l2);

        JLabel l3=new JLabel("Status");
        l3.setBounds(320,10,70,20);
        add(l3);

        JLabel l4=new JLabel("Price");
        l4.setBounds(460,10,70,20);
        add(l4);

        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(585,10,70,20);
        add(l5);




        b1= new JButton("Load Data");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(185,505,100,30);
        b1.addActionListener(this);
        add(b1);

        b2= new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(400,505,100,30);
        b2.addActionListener(this);
        add(b2);




        setLayout(null);
        setBounds(300,140,700,585);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                Config c=new Config();
                String str="select * from room";
                ResultSet rs=c.s.executeQuery(str);
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
        new Room().setVisible(true);
    }
}


