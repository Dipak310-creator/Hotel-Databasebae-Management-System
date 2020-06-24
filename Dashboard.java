package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;

    public Dashboard(){
        mb=new JMenuBar();
        add(mb);

        m1=new JMenu("Management");
        m1.setForeground(Color.red);
        mb.add(m1);

        m2=new JMenu("Admin");
        m2.setForeground(Color.blue);
        mb.add(m2);

        i1=new JMenuItem("Reception");
        i1.addActionListener(this);
        m1.add(i1);
        i2=new JMenuItem("Add Employee");
        i2.addActionListener(this);
        m2.add(i2);
        i3=new JMenuItem("Add Rooms");
        i3.addActionListener(this);
        m2.add(i3);
        i4=new JMenuItem("Add Driver");
        i4.addActionListener(this);
        m2.add(i4);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel_management_System/icons/dashboard.jpg"));
        Image i2=i1.getImage().getScaledInstance(2000,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(0,0,1500,700);
        add(l1);


        JLabel l2=new JLabel("Welcome To Paradise");
        l2.setBounds(450,65,1000,50);
        l2.setFont(new Font("serif",Font.PLAIN,46));
        l2.setForeground(Color.white);
        l1.add(l2);


        mb.setBounds(0,0,1400,30);
        setLayout(null);
        setBounds(0,0,2000,1020);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Reception")){
            new Reception().setVisible(true);
        }else if(ae.getActionCommand().equals("Add Employee")){
            new Employee().setVisible(true);
        }else if(ae.getActionCommand().equals("Add Rooms")){
            new AddRooms().setVisible(true);
        }else if(ae.getActionCommand().equals("Add Driver")) {
            new AddDriver().setVisible(true);
        }
    }

    public static void main(String[] args){
        new Dashboard().setVisible(true);
    }
 }
