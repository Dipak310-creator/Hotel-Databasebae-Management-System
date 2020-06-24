package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {

    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2,b3;
    Choice ch;

    public UpdateCheck(){

        JLabel j2=new JLabel("Update Check Status");
        j2.setForeground(Color.blue);
        j2.setBounds(370,5,400,25);
        j2.setFont(new Font("serif",Font.PLAIN,25));
        add(j2);

        JLabel l1= new JLabel("Customer-Id");
        l1.setBounds(20,40,150,20);
        add(l1);

        ch=new Choice();
        try{
            Config c= new Config();
            String str="select * from customer";
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                ch.add(rs.getString("number"));
            }

        }catch(Exception e){}
        ch.setBounds(175,40,130,20);
        add(ch);

        JLabel l2= new JLabel("Room Number");
        l2.setBounds(20,80,150,20);
        add(l2);

        t1=new JTextField("");
        t1.setBounds(175,80,130,20);
        add(t1);

        JLabel l3= new JLabel("Name");
        l3.setBounds(20,120,150,20);
        add(l3);

        t2=new JTextField("");
        t2.setBounds(175,120,130,20);
        add(t2);

        JLabel l4= new JLabel("Check-In");
        l4.setBounds(20,160,150,20);
        add(l4);

        t3=new JTextField("");
        t3.setBounds(175,160,130,20);
        add(t3);

        JLabel l5= new JLabel("Amount-Paid");
        l5.setBounds(20,200,150,20);
        add(l5);

        t4=new JTextField("");
        t4.setBounds(175,200,130,20);
        add(t4);

        JLabel l6= new JLabel("Pending-Amount");
        l6.setBounds(20,240,150,20);
        add(l6);

        t5=new JTextField("");
        t5.setBounds(175,240,130,20);
        add(t5);

        b1=new JButton("Check");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(100,290,100,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Update");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(20,340,100,30);
        b2.addActionListener(this);
        add(b2);

        b3=new JButton("Back");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(175,340,100,30);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hotel_Management_System/icons/UpdateCheck.jpeg"));
        Image i2=i1.getImage().getScaledInstance(290,220, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel j1=new JLabel(i3);
        j1.setBounds(310,10,320,310);
        getContentPane().setBackground(Color.white);
        add(j1);

        setBounds(330,150,650,450);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1){
            try{
                Config c= new Config();
                String id=ch.getSelectedItem();
                String deposit;
                String price;
                int amountPaid;
                String str="select * from customer where number = '"+id+"'";
                ResultSet rs=c.s.executeQuery(str);
                while(rs.next()){
                    t1.setText(rs.getString("allocatedRoomNumber"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("checkedIn"));
                    t4.setText(rs.getString("deposit"));
                }

                deposit=t4.getText();
                String roomNumber=t1.getText();
                ResultSet rs1 =c.s.executeQuery("select * from room where roomNo = '"+roomNumber+"'");
                while(rs1.next()){
                    price=rs1.getString("price");
                    amountPaid=Integer.parseInt(price)-Integer.parseInt(deposit);
                    t5.setText(Integer.toString(amountPaid));
                }

            }catch(Exception e){
                System.out.println(e);
            }

        }else if(ae.getSource()==b2){
            String name = t2.getText();
            String checkIn = t3.getText();
            String pendingAmount=t4.getText();
            try{
                String id=ch.getSelectedItem();
                Config c= new Config();
                String str1="update customer set name='"+name+"' where number = '"+id+"'";
                String str="update customer set deposit = '"+pendingAmount+"' where number = '"+id+"'";
                c.s.executeUpdate(str);
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null,"Status Updated");
            }catch(Exception e){
                System.out.println(e);
            }

        }else if(ae.getSource()==b3){
            this.setVisible(false);
            new Reception().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new UpdateCheck().setVisible(true);
    }
}
