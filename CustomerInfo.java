package Hotel_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame implements ActionListener {

    JTable t1;
    JButton b1,b2;

    public CustomerInfo(){
        t1= new JTable();
        t1.setBounds(5,40,1000,450);
        add(t1);

        JLabel l1=new JLabel("Id");
        l1.setBounds(40,10,70,20);
        add(l1);

        JLabel l2=new JLabel("Id Number");
        l2.setBounds(170,10,70,20);
        add(l2);

        JLabel l3=new JLabel("Name");
        l3.setBounds(290,10,70,20);
        add(l3);

        JLabel l4=new JLabel("Gender");
        l4.setBounds(420,10,70,20);
        add(l4);

        JLabel l5=new JLabel("Country");
        l5.setBounds(540,10,70,20);
        add(l5);

        JLabel l6=new JLabel("Allocated Room");
        l6.setBounds(665,10,70,20);
        add(l6);

        JLabel l7=new JLabel("Checked In");
        l7.setBounds(795,10,70,20);
        add(l7);

        JLabel l8=new JLabel("Deposit");
        l8.setBounds(925,10,70,20);
        add(l8);



        b1= new JButton("Load Data");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(310,505,100,30);
        b1.addActionListener(this);
        add(b1);

        b2= new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(530,505,100,30);
        b2.addActionListener(this);
        add(b2);




        setLayout(null);
        setBounds(160,140,1025,585);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                Config c=new Config();
                String str="select * from customer";
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
        new CustomerInfo().setVisible(true);
    }
}

