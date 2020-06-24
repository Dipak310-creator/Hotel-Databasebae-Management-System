package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener {

    JButton b1,b2;
    JTextField t1,t2,t3,t4,t5;
    JComboBox c1,c2;
    Choice ch;

    public AddCustomer(){

        JLabel j2=new JLabel("Add Customer");
        j2.setForeground(Color.blue);
        j2.setBounds(400,5,400,25);
        j2.setFont(new Font("serif",Font.PLAIN,25));
        add(j2);

        JLabel l1=new JLabel("ID");
        l1.setBounds(20,25,600,20);
        add(l1);

        c1=new JComboBox(new String[]{"Passport","Driving License","Aadhar Card","Voter-Id Card"});
        c1.setBounds(175,25,130,20);
        add(c1);
        c1.setBackground(Color.white);

        JLabel l2=new JLabel("Number");
        l2.setBounds(20,65,600,20);
        add(l2);

        t1=new JTextField("");
        t1.setBounds(175,65,130,20);
        add(t1);
        t1.setBackground(Color.white);


        JLabel l3=new JLabel("Name");
        l3.setBounds(20,105,600,20);
        add(l3);

        t2=new JTextField("");
        t2.setBounds(175,105,130,20);
        add(t2);
        t2.setBackground(Color.white);

        JLabel l4=new JLabel("Gender");
        l4.setBounds(20,145,600,20);
        add(l4);

        c2=new JComboBox(new String[]{"Male","Female"});
        c2.setBounds(175,145,130,20);
        add(c2);
        c2.setBackground(Color.white);

        JLabel l5=new JLabel("Country");
        l5.setBounds(20,185,600,20);
        add(l5);

        t3=new JTextField("");
        t3.setBounds(175,185,130,20);
        add(t3);
        t3.setBackground(Color.white);

        JLabel l6=new JLabel("Allocated Room Number");
        l6.setBounds(20,225,150,20);
        add(l6);

        ch=new Choice();
        try{
            Config c=new Config();
            String str="select * from room where available='Available'";
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                ch.add(rs.getString("roomNo"));
            }
         }catch(Exception e){ }
        ch.setBounds(175,225,130,20);
        add(ch);

        JLabel l7=new JLabel("Checked In");
        l7.setBounds(20,265,600,20);
        add(l7);

        t4=new JTextField("");
        t4.setBounds(175,265,130,20);
        add(t4);
        t4.setBackground(Color.white);

        JLabel l8=new JLabel("Deposit");
        l8.setBounds(20,305,600,20);
        add(l8);

        t5=new JTextField("");
        t5.setBounds(175,305,130,20);
        add(t5);
        t5.setBackground(Color.white);

        b1=new JButton("Add Details");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(40,370,100,20);
        b1.addActionListener(this);
        add(b1);


        b2=new JButton("Cancel");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(180,370,100,20);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hotel_Management_System/icons/NewCustomerRoom.jpg"));
        Image i2=i1.getImage().getScaledInstance(310,290, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel j1=new JLabel(i3);
        j1.setBounds(290,15,360,330);
        add(j1);
        getContentPane().setBackground(Color.white);

        setBounds(330,150,650,450);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);

    }



    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String id=(String)c1.getSelectedItem();
            String number = t1.getText();
            String name= t2.getText();
            String gender=(String)c2.getSelectedItem();
            String country = t3.getText();
            String allocateRoomNumber=ch.getSelectedItem();
            String checkedIn=t4.getText();
            String deposit=t5.getText();

            String str="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+allocateRoomNumber+"','"+checkedIn+"','"+deposit+"')";
            String str2="update room set available = 'occupied' where roomNo= '"+allocateRoomNumber+"'";

            try {
                Config c=new Config();
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null,"New Customer Added");
                this.setVisible(false);
                new Reception().setVisible(true);
            }catch(Exception e){
            System.out.println(e);
            }

        }else if(ae.getSource()==b2){
            this.setVisible(false);
            new Reception().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new AddCustomer().setVisible(true);
    }
}
