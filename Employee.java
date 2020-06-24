package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Employee extends JFrame implements ActionListener {

    JRadioButton r1,r2;
    JComboBox c1;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1;

    public Employee(){
        JLabel l1=new JLabel("NAME :");
        l1.setBounds(20,10,600,100);
        add(l1);

        t1=new JTextField("");
        t1.setBounds(130,50,130,20);
        add(t1);


        JLabel l2=new JLabel("AGE :");
        l2.setBounds(20,50,600,100);
        add(l2);

        t2=new JTextField("");
        t2.setBounds(130,90,130,20);
        add(t2);

        JLabel l3=new JLabel("GENDER :");
        l3.setBounds(20,90,600,100);
        add(l3);

        r1=new JRadioButton(" MALE");
        r1.setBounds(130,115,100,50);
        add(r1);
        r1.setBackground(Color.white);

        r2=new JRadioButton(" FEMALE");
        r2.setBounds(230,115,100,50);
        add(r2);
        r2.setBackground(Color.white);

        JLabel l4=new JLabel("JOB :");
        l4.setBounds(20,130,600,100);
        add(l4);

        String str[]={"Front Desk Clerk","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
        c1=new JComboBox(str);
        c1.setBounds(130,170,130,20);
        add(c1);
        c1.setBackground(Color.white);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hotel_Management_System/icons/fourth.jpg"));
        Image i2=i1.getImage().getScaledInstance(350,300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel j1=new JLabel(i3);
        j1.setBounds(290,0,360,330);
        add(j1);
        getContentPane().setBackground(Color.white);

        JLabel j2=new JLabel("Add Employee Details");
        j2.setForeground(Color.blue);
        j2.setBounds(40,20,400,30);
        j2.setFont(new Font("serif",Font.PLAIN,30));
        j1.add(j2);


        JLabel l5=new JLabel("SALARY :");
        l5.setBounds(20,170,600,100);
        add(l5);

        t3=new JTextField("");
        t3.setBounds(130,210,130,20);
        add(t3);

        JLabel l6=new JLabel("PHONE NO :");
        l6.setBounds(20,210,600,100);
        add(l6);

        t4=new JTextField("");
        t4.setBounds(130,250,130,20);
        add(t4);

        JLabel l7=new JLabel("AADHAR NO :");
        l7.setBounds(20,250,600,100);
        add(l7);

        t5=new JTextField("");
        t5.setBounds(130,290,130,20);
        add(t5);

        JLabel l8=new JLabel("EMAIL :");
        l8.setBounds(20,290,600,100);
        add(l8);

        t6=new JTextField("");
        t6.setBounds(130,330,130,20);
        add(t6);

        b1=new JButton("SUBMIT");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(130,360,130,20);
        b1.addActionListener(this);
        add(b1);

        setBounds(330,150,650,430);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String name=t1.getText();
        String age=t2.getText();
        String salary=t3.getText();
        String phone=t4.getText();
        String aadhar=t5.getText();
        String email=t6.getText();

        String gender=null;
        if(r1.isSelected()){
            gender="Male";
        }else if(r2.isSelected()){
            gender="Female";
        }

        String job=(String)c1.getSelectedItem();

        Config c2=new Config();

        String str1="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";

        try{
            c2.s.executeUpdate(str1);
            JOptionPane.showMessageDialog(null,"New Employee Added");
            this.setVisible(false);

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Employee().setVisible(true);
    }
}