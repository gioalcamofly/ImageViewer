package kata5p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Kata5P1 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:/media/giovanni/Maxtor/Universidad/is2/KATA5");
        
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM PEOPLE";
        ResultSet rs = statement.executeQuery(query);
        
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt(1) + " Name: " + rs.getString(2));
        }
        
        query = "CREATE TABLE IF NOT EXISTS MAIL ('Id' INTEGER"
                + " PRIMARY KEY AUTOINCREMENT, 'Mail' TEXT NOT NULL);";
        
        statement.execute(query);
        
        String fileString = "/home/giovanni/Descargas/emails.txt";
        
        BufferedReader reader = new BufferedReader(new FileReader(new File (fileString)));
        String mail;
        
        while ((mail = reader.readLine()) != null) {
            if (!mail.contains("@")) continue;
            query = "INSERT INTO MAIL (mail) VALUES ('" + mail + "')";
            statement.executeUpdate(query);
        }
        
        rs.close();
        statement.close();
        connection.close();
               
    }
    
}
