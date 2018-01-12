package kata6.view;

import kata6.model.Mail;
import kata6.model.Person;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseList {
    
    public static List<Person> read(String fileName) throws ClassNotFoundException, SQLException {
        ArrayList<Person> list = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:"+fileName);
        Statement s = c.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM people");
        
        while (rs.next()) {
            Integer id = rs.getInt(1);
            String name = rs.getString(2);
            Character gender = rs.getString(3).charAt(0);
            String birthDate = rs.getString(4);
            Float weight = rs.getFloat(5);
            String mail = rs.getString(6);
            list.add(new Person(id, name, gender, birthDate, weight, mail));
        }
        
        return list;
    }
}
