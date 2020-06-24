package Hotel_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {

    JComboBox c1;
    JCheckBox c2;
    JButton b1,b2;
    JTable t1;

    public SearchRoom(){

        JLabel j2=new JLabel("Search Room");
        j2.setForeground(Color.blue);
        j2.setBounds(250,0,400,25);
        j2.setFont(new Font("serif",Font.PLAIN,30));
        add(j2);

        JLabel l1=new JLabel("Bed Type");
        l1.setBounds(20,60,120,20);
        add(l1);

        c1=new JComboBox(new String []{"Single Bed","Double Bed"});
        c1.setBounds(145,60,130,20);
        c1.setBackground(Color.white);
        add(c1);

        c2=new JCheckBox("Only Display Available");
        c2.setBounds(450,60,150,25);
        c2.setBackground(Color.white);
        add(c2);

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

        JLabel l2=new JLabel("Room No");
        l2.setBounds(45,125,70,20);
        add(l2);

        JLabel l3=new JLabel("Available");
        l3.setBounds(180,125,70,20);
        add(l3);

        JLabel l4=new JLabel("Status");
        l4.setBounds(330,125,70,20);
        add(l4);

        JLabel l5=new JLabel("Price");
        l5.setBounds(470,125,70,20);
        add(l5);

        JLabel l6=new JLabel("Bed Type");
        l6.setBounds(600,125,70,20);
        add(l6);





        setBounds(320,150,700,500);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                String str="select * from room where type ='"+c1.getSelectedItem()+"'";
                String str1="select * from room where available= 'Available' and type ='"+c1.getSelectedItem()+"'";
                Config c= new Config();
                ResultSet rs;
                if(c2.isSelected()){
                    rs=c.s.executeQuery(str1);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }else{
                    rs=c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }

            }catch(Exception e){
                System.out.println(e);
            }

        }else if(ae.getSource()==b2){
            this.setVisible(false);
            new Reception().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SearchRoom().setVisible(true);
    }
}
