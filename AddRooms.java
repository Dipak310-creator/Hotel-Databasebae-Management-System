package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6;
    JComboBox c1,c2,c3;
    JButton b1,b2;
    JTextField t1,t2,t3,t4;

    public AddRooms(){

        JLabel j2=new JLabel("Add Room Details");
        j2.setForeground(Color.blue);
        j2.setBounds(40,0,400,25);
        j2.setFont(new Font("serif",Font.PLAIN,30));
        add(j2);

        l1=new JLabel("Room Number ");
        l1.setBounds(20,10,600,100);
        add(l1);

        t1=new JTextField("");
        t1.setBounds(150,50,130,20);
        add(t1);

        l2=new JLabel("Available ");
        l2.setBounds(20,50,600,100);
        add(l2);

        c1=new JComboBox(new String[] {"Available","occupied"});
        c1.setBounds(150,90,130,20);
        add(c1);
        c1.setBackground(Color.white);

        l3=new JLabel("Cleaning Status ");
        l3.setBounds(20,90,600,100);
        add(l3);

        c2=new JComboBox(new String[] {"Clean","Dirty"});
        c2.setBounds(150,130,130,20);
        add(c2);
        c2.setBackground(Color.white);

        l4=new JLabel("Price ");
        l4.setBounds(20,130,600,100);
        add(l4);

        t2=new JTextField("");
        t2.setBounds(150,170,130,20);
        add(t2);

        l5=new JLabel("Bed Type ");
        l5.setBounds(20,170,600,100);
        add(l5);

        c3=new JComboBox(new String[] {"Single Bed","Double Bed"});
        c3.setBounds(150,210,130,20);
        add(c3);
        c3.setBackground(Color.white);

        b1=new JButton("Add Details");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(40,260,100,20);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(180,260,100,20);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hotel_Management_System/icons/fifth.jpg"));
        Image i2=i1.getImage().getScaledInstance(350,250, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel j1=new JLabel(i3);
        j1.setBounds(295,0,320,310);
        add(j1);


        setBounds(330,150,650,350);
        setLayout(null);
        setVisible(true);
        //setBackground(Color.white);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String room=t1.getText();
            String available=(String)c1.getSelectedItem();
            String status=(String)c2.getSelectedItem();
            String price=t2.getText();
            String type=(String)c3.getSelectedItem();

            Config c=new Config();
            try{
                String str="Insert into room values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
                c.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null,"New Room Added");
                this.setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }

        }else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddRooms().setVisible(true);
    }
}
