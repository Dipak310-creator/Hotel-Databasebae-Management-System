package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CheckOut extends JFrame implements ActionListener {

    JButton b1,b2,b3;
    Choice ch;
    JTextField t1;

    public CheckOut(){

        JLabel j2=new JLabel("Check Out");
        j2.setForeground(Color.blue);
        j2.setBounds(100,5,400,25);
        j2.setFont(new Font("serif",Font.PLAIN,25));
        add(j2);


        JLabel l1=new JLabel("Customer Id");
        l1.setBounds(20,60,120,20);
        add(l1);

        ch=new Choice();
        try{
            Config c = new Config();
            String str="select * from customer";
            ResultSet rs= c.s.executeQuery(str);
            while(rs.next()){
                ch.add(rs.getString("number"));
            }

        }catch(Exception e){}
        ch.setBounds(145,60,130,20);
        add(ch);

        JLabel l2=new JLabel("Room No");
        l2.setBounds(20,100,120,20);
        add(l2);

        t1=new JTextField("");
        t1.setBounds(145,100,130,20);
        add(t1);

        b1=new JButton("Check Out");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(30,170,100,30);
        b1.addActionListener(this);
        add(b1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hotel_Management_System/icons/check.png"));
        Image i2=i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        b2=new JButton(i3);
        b2.setBounds(280,60,20,20);
        b2.addActionListener(this);
        add(b2);

        ImageIcon im=new ImageIcon(ClassLoader.getSystemResource("Hotel_Management_System/icons/heckout.jpg"));
        Image i4=im.getImage().getScaledInstance(260,220,Image.SCALE_DEFAULT);
        ImageIcon i5=new ImageIcon(i4);
        JLabel l4=new JLabel(i5);
        l4.setBounds(240,10,400,240);
        add(l4);

        b3=new JButton("Cancel");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(170,170,100,30);
        b3.addActionListener(this);
        add(b3);




        setBounds(380,150,600,300);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String CustomerId=ch.getSelectedItem();
            String room=t1.getText();
            String str="delete from customer where number ='"+CustomerId+"'";
            String str1="update room set available = 'Available' where roomNo ='"+room+"'";
            Config c= new Config();
            try{
                c.s.executeUpdate(str);
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null,"CheckOut Done");
                this.setVisible(false);
                new Reception().setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }

        }else if(ae.getSource()==b2){
            try {
                String CustomerId=ch.getSelectedItem();
                Config c = new Config();
                String str = "select * from customer where  number='"+CustomerId+"'";
                ResultSet rs=c.s.executeQuery(str);
                while(rs.next()){
                    t1.setText(rs.getString("allocatedRoomNumber"));
                }
            }catch(Exception e){}

        }else if(ae.getSource()==b3){
            this.setVisible(false);
            new Reception().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new CheckOut().setVisible(true);
    }
}
