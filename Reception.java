package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {

JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    public Reception(){

        b1=new JButton("New Customer Room");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(15,30,200,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Room");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(15,70,200,30);
        b2.addActionListener(this);
        add(b2);

        b3=new JButton("Department");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(15,110,200,30);
        b3.addActionListener(this);
        add(b3);

        b4=new JButton("All Employee Info ");
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        b4.setBounds(15,150,200,30);
        b4.addActionListener(this);
        add(b4);

        b5=new JButton("Customer info");
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        b5.setBounds(15,190,200,30);
        b5.addActionListener(this);
        add(b5);

        b6=new JButton("Manager Info");
        b6.setBackground(Color.black);
        b6.setForeground(Color.white);
        b6.setBounds(15,230,200,30);
        b6.addActionListener(this);
        add(b6);

        b7=new JButton("Check out");
        b7.setBackground(Color.black);
        b7.setForeground(Color.white);
        b7.setBounds(15,270,200,30);
        b7.addActionListener(this);
        add(b7);

        b8=new JButton("Update Check status");
        b8.setBackground(Color.black);
        b8.setForeground(Color.white);
        b8.setBounds(15,310,200,30);
        b8.addActionListener(this);
        add(b8);

        b9=new JButton("Update Room Status");
        b9.setBackground(Color.black);
        b9.setForeground(Color.white);
        b9.setBounds(15,350,200,30);
        b9.addActionListener(this);
        add(b9);

        b10=new JButton("Search Room");
        b10.setBackground(Color.black);
        b10.setForeground(Color.white);
        b10.setBounds(15,390,200,30);
        b10.addActionListener(this);
        add(b10);

        b11=new JButton("Pickup service");
        b11.setBackground(Color.black);
        b11.setForeground(Color.white);
        b11.setBounds(15,430,200,30);
        b11.addActionListener(this);
        add(b11);
        getContentPane().setBackground(Color.white);

        b12=new JButton("Logout");
        b12.setBackground(Color.black);
        b12.setForeground(Color.white);
        b12.setBounds(15,470,200,30);
        b12.addActionListener(this);
        add(b12);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hotel_Management_System/icons/seventh.jpg"));
        Image i2=i1.getImage().getScaledInstance(550,490,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel j1=new JLabel(i3);
        j1.setBounds(200,0,600,550);
        add(j1);



        setBounds(280,150,800,550);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            new AddCustomer().setVisible(true);
            this.setVisible(false);

        }else if(ae.getSource()==b2){
            new Room().setVisible(true);
            this.setVisible(false);

        }else if(ae.getSource()==b3){
            this.setVisible(false);
            new Department().setVisible(true);

        }else if(ae.getSource()==b4){
            new EmployeeInfo().setVisible(true);
            this.setVisible(false);

        }else if(ae.getSource()==b5){
            new CustomerInfo().setVisible(true);
            this.setVisible(false);

        }else if(ae.getSource()==b6){
            new ManagerInfo().setVisible(true);
            this.setVisible(false);

        }else if(ae.getSource()==b7){
            new CheckOut().setVisible(true);
            this.setVisible(false);

        }else if(ae.getSource()==b8) {
            new UpdateCheck().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource()==b9){
            new UpdateRoomStatus().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource()==b10){
            new SearchRoom().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource()==b11){
            new PickUp().setVisible(true);
            this.setVisible(false);

        }else if(ae.getSource()==b12){
            this.setVisible(false);
        }

    }


    public static void main(String[] args) {
        new Reception().setVisible(true);
    }
}
