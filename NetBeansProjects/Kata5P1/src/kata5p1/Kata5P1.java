package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Kata5P1 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:/media/giovanni/Maxtor/Universidad/is2/KATA5");
        
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM PEOPLE";
        ResultSet rs = statement.executeQuery(query);
        
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt(1) + " Name: " + rs.getString(2));
        }
    }
    
}
