package Hotel_Management_System;
import java.sql.*;
public class Config {

    Connection c;
    Statement s;
    public Config(){
        try{
           Class.forName("com.mysql.jdbc.Driver");
           c=DriverManager.getConnection("jdbc:mysql:///projecthms","root","12345");
           s=c.createStatement();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
