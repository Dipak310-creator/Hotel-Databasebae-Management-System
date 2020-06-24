package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5;
    JComboBox c1,c2;
    JButton b1,b2;

    public AddDriver(){

        JLabel j2=new JLabel("Add Driver's Details");
        j2.setForeground(Color.blue);
        j2.setBounds(40,0,400,30);
        j2.setFont(new Font("serif",Font.PLAIN,25));
        add(j2);

        l1=new JLabel("Name ");
        l1.setBounds(20,10,600,100);
        add(l1);

        t1=new JTextField("");
        t1.setBounds(150,50,130,20);
        add(t1);

        l2=new JLabel("Age ");
        l2.setBounds(20,50,600,100);
        add(l2);

        t2=new JTextField("");
        t2.setBounds(150,90,130,20);
        add(t2);

        l3=new JLabel("Gender ");
        l3.setBounds(20,90,600,100);
        add(l3);

        c1=new JComboBox(new String[] {"Male","Female"});
        c1.setBounds(150,130,130,20);
        add(c1);
        c1.setBackground(Color.white);

        l4=new JLabel("Car Category ");
        l4.setBounds(20,130,600,100);
        add(l4);

        t3=new JTextField("");
        t3.setBounds(150,170,130,20);
        add(t3);

        l5=new JLabel("Car Model ");
        l5.setBounds(20,170,600,100);
        add(l5);

        t4=new JTextField("");
        t4.setBounds(150,210,130,20);
        add(t4);

        l6=new JLabel("Status ");
        l6.setBounds(20,210,600,100);
        add(l6);

        c2=new JComboBox(new String[] {"Available","Unavailable"});
        c2.setBounds(150,250,130,20);
        add(c2);
        c2.setBackground(Color.white);

        l7=new JLabel("Location ");
        l7.setBounds(20,250,600,100);
        add(l7);

        t5=new JTextField("");
        t5.setBounds(150,290,130,20);
        add(t5);

        b1=new JButton("Add Details");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(40,330,100,20);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(180,330,100,20);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Hotel_Management_System/icons/sixth.jpg"));
        Image i2=i1.getImage().getScaledInstance(350,250, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        l8=new JLabel(i3);
        l8.setBounds(295,10,320,340);
        add(l8);

        setBounds(330,150,650,410);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String name=t1.getText();
            String age=t2.getText();
            String gender=(String)c1.getSelectedItem();
            String category=t3.getText();
            String model=t4.getText();
            String available=(String)c2.getSelectedItem();
            String location=t5.getText();

            Config c=new Config();
            try{
                String str="insert into driver values('"+name+"','"+age+"','"+gender+"','"+category+"','"+model+"','"+available+"','"+location+"')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Driver Added");
                this.setVisible(false);
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDriver().setVisible(true);
    }
}
