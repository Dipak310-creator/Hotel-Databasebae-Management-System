package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hotel_management_System extends JFrame implements ActionListener {
    Hotel_management_System(){
        setBounds(350,150,700,420);
        //setSize(400,400);
       // setLocation(500,200);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel_management_System/icons/Hotels-and-Resorts.jpg"));
        JLabel l1=new JLabel(i1);
        l1.setBounds(0,0,700,420);
        add(l1);
        setLayout(null);
        setVisible(true);

        JButton b1=new JButton("Next");
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setBounds(550,335,75,30);
        b1.addActionListener(this);
        l1.add(b1);

        JLabel l2=new JLabel("Hotel Management System");
        l2.setBounds(50,310,600,70);
        l2.setForeground(Color.black);
        l1.add(l2);
        l2.setFont(new Font("serif",Font.PLAIN,40));

        while(true){
            l2.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                System.out.println(e);
            }
            l2.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                System.out.println(e);
            }
        }

    }
    public void actionPerformed(ActionEvent ae){
        new Login().setVisible(true);
        this.setVisible(false);

    }
    public static void main(String[] args){
        System.out.println("Running... ");
        Hotel_management_System hms=new Hotel_management_System ();
    }
}
