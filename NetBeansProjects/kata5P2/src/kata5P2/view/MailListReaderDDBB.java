package kata5P2.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kata5P2.model.Mail;

public class MailListReaderDDBB {
    
    public static List<Mail> read() throws ClassNotFoundException, SQLException {
        List<Mail> mailList = new ArrayList();
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:/media/giovanni/Maxtor/Universidad/is2/KATA5");
        
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM MAIL";
        ResultSet rs = statement.executeQuery(query);
        
        while (rs.next()) {
            mailList.add(new Mail(rs.getString(2)));
        }
        
        
        return mailList;
    }
}
