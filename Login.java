package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel l1,l2;
    JTextField t1;
    JPasswordField p1;
    JButton b1,b2;

    Login(){
        l1=new JLabel("Username :");
        l1.setBounds(20,40,600,100);
        add(l1);

        t1=new JTextField("");
        t1.setBounds(100,81,130,20);
        add(t1);

        l2=new JLabel("Password :");
        l2.setBounds(20,100,600,100);
        add(l2);

        p1=new JPasswordField("");
        p1.setBounds(100,141,130,20);
        add(p1);

        b1=new JButton("Login");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(20,190,90,20);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBackground(Color.white);
        b2.setForeground(Color.black);
        b2.setBounds(140,190,90,20);
        b2.addActionListener(this);
        add(b2);

        try {
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel_management_System/icons/second.jpg"));
            Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel la = new JLabel(i3);
            la.setBounds(300, 100, 0, 0);
            add(la);
        }catch(Exception e){
            System.out.println(e);
        }

        setBounds(475,150,400,300);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        setLayout(null);

    }
    public void actionPerformed(ActionEvent ae){
          if(ae.getSource()==b1){
              String username=t1.getText();
              String password=p1.getText();
              Config c=new Config();
              String str="select * from Login where username= '"+username+"' and password= '"+password+"'";
              try {
                  ResultSet rs=c.s.executeQuery(str);
                  if(rs.next()){
                      new Dashboard().setVisible(true);
                      this.setVisible(false);
                  }else{
                      JOptionPane.showMessageDialog(null,"Invalid username or password");
                      this.setVisible(false);
                  }
              }catch(Exception e){
                  System.out.println(e);

              }
          }else if(ae.getSource()==b2){
            System.exit(0);
          }
    }

    public static void main(String[] args) {
        Login l=new Login();
    }
}
