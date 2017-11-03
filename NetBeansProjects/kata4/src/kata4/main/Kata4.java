package kata4.main;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;

public class Kata4 {
    
    private String filename;
    private List<Mail> mailList;
    private Histogram<String> histogram;

    public static void main(String[] args) throws IOException {
        Kata4 kata4 = new Kata4();
        kata4.execute();
    }
    public void execute() throws IOException {
        input();
        process();
        output();
    }
    
    public void input() {
        filename = "/home/giovanni/Documentos/mail.txt";
    }
    
    public void process() throws IOException {
        mailList = MailListReader.read(filename);
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    public void output() {
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
    
}