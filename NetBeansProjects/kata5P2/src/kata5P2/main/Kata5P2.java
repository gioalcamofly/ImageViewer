package kata5P2.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import kata5P2.model.Histogram;
import kata5P2.model.Mail;
import kata5P2.view.HistogramDisplay;
import kata5P2.view.MailHistogramBuilder;
import kata5P2.view.MailListReaderDDBB;

public class Kata5P2 {
    
    private String filename;
    private List<Mail> mailList;
    private Histogram<String> histogram;

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Kata5P2 kata5P2 = new Kata5P2();
        kata5P2.execute();
    }
    public void execute() throws IOException, ClassNotFoundException, SQLException {
        input();
        process();
        output();
    }
    
    public void input() {
        filename = "/home/giovanni/Documentos/mail.txt";
    }
    
    public void process() throws IOException, ClassNotFoundException, SQLException {
        mailList = MailListReaderDDBB.read();
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    public void output() {
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
    
}