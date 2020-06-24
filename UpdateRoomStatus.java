package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoomStatus extends JFrame implements ActionListener {

    Choice ch;
    JTextField t1,t2,t3,t4;
    JButton b1,b2,b3;

    public UpdateRoomStatus(){

        JLabel j2=new JLabel("Update Room Status");
        j2.setForeground(Color.blue);
        j2.setBounds(200,0,400,25);
        j2.setFont(new Font("serif",Font.PLAIN,25));
        add(j2);

        JLabel l1=new JLabel("Guest Id");
        l1.setBounds(20,40,150,20);
        add(l1);

        ch=new Choice();
        try{
            Config c=new Config();
            ResultSet rs= c.s.executeQuery("select * from customer");
            while(rs.next()){
                ch.add(rs.getString("number"));
            }

        }catch(Exception e){}
        ch.setBounds(175,40,130,20);
        add(ch);

        JLabel l2=new JLabel("Name");
        l2.setBounds(20,80,150,20);
        add(l2);

        t1=new JTextField("");
        t1.setBounds(175,80,130,20);
        add(t1);

        JLabel l3=new JLabel("Room No");
        l3.setBounds(20,120,150,20);
        add(l3);

        t2=new JTextField("");
        t2.setBounds(175,120,130,20);
        add(t2);


        JLabel l4=new JLabel("Availability");
        l4.setBounds(20,160,150,20);
        add(l4);

        t3=new JTextField("");
        t3.setBounds(175,160,130,20);
        add(t3);

        JLabel l5=new JLabel("Cleaning Status");
        l5.setBounds(20,200,150,20);
        add(l5);

        t4=new JTextField("");
        t4.setBounds(175,200,130,20);
        add(t4);



        b1=new JButton("Check");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(100,250,100,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Update");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(20,310,100,30);
        b2.addActionListener(this);
        add(b2);

        b3=new JButton("Back");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(175,310,100,30);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hotel_Management_System/icons/UpdateRoomStatus.jpg"));
        Image i2=i1.getImage().getScaledInstance(310,270, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel j1=new JLabel(i3);
        j1.setBounds(290,10,360,330);
        add(j1);
        getContentPane().setBackground(Color.white);

        setBounds(330,150,650,450);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String guestId=ch.getSelectedItem();
            Config c= new Config();
            String str="select * from customer where number = '"+guestId+"'";
            try{
                ResultSet rs=c.s.executeQuery(str);
                while(rs.next()){
                    t2.setText(rs.getString("allocatedRoomNumber"));
                    t1.setText(rs.getString("name"));
                }
                String room=t2.getText();
                ResultSet rs2=c.s.executeQuery("select * from room where roomNo ='"+room+"'");
                while(rs2.next()){
                    t3.setText(rs2.getString("available"));
                    t4.setText(rs2.getString("status"));
                }
            }catch(Exception e){
                System.out.println(e);
            }

        }else if(ae.getSource()==b2){
            try{
                Config c = new Config();
                String guestId=ch.getSelectedItem();
                String name=t1.getText();
                String room=t2.getText();
                String available=t3.getText();
                String status=t4.getText();

                String str="update room set available='"+available+"', status='"+status+"'  where roomNo ='"+room+"' ";
                String str1="update customer set name='"+name+"' where number = '"+guestId+"' ";
                c.s.executeUpdate(str);
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null,"Updated");
                this.setVisible(false);
                new Reception().setVisible(true);
            }catch(Exception e){}

        }else if(ae.getSource()==b3){
            this.setVisible(false);
            new Reception().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new UpdateRoomStatus().setVisible(true);
    }
}
