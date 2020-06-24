package Hotel_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class PickUp extends JFrame implements ActionListener {

    Choice c1;
    JButton b1,b2;
    JTable t1;

    public PickUp (){

        JLabel j2=new JLabel("Pick Up");
        j2.setForeground(Color.blue);
        j2.setBounds(300,0,400,25);
        j2.setFont(new Font("serif",Font.PLAIN,25));
        add(j2);

        JLabel l1=new JLabel("Car Type");
        l1.setBounds(20,60,120,20);
        add(l1);
        c1=new Choice();
        try {
            Config c = new Config();
            ResultSet rs=c.s.executeQuery("select * from driver");
            while(rs.next()) {
                c1.add(rs.getString("category"));
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        c1.setBounds(145,60,130,20);
        c1.setBackground(Color.white);
        add(c1);

        t1=new JTable();
        t1.setBounds(0,150,700,200);
        add(t1);

        b1=new JButton("Submit");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(180,370,100,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(400,370,100,30);
        b2.addActionListener(this);
        add(b2);

        JLabel l2=new JLabel("Name");
        l2.setBounds(30,125,70,20);
        add(l2);

        JLabel l3=new JLabel("Age");
        l3.setBounds(140,125,70,20);
        add(l3);

        JLabel l4=new JLabel("Gender");
        l4.setBounds(230,125,70,20);
        add(l4);

        JLabel l5=new JLabel("Category");
        l5.setBounds(330,125,70,20);
        add(l5);

        JLabel l6=new JLabel("Model");
        l6.setBounds(430,125,70,20);
        add(l6);

        JLabel l7=new JLabel("Available");
        l7.setBounds(530,125,70,20);
        add(l7);

        JLabel l8=new JLabel("Location");
        l8.setBounds(620,125,70,20);
        add(l8);





        setBounds(320,150,700,500);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                Config c= new Config();
                String str="select * from driver where category ='"+c1.getSelectedItem()+"'";
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
        new PickUp ().setVisible(true);
    }
}

