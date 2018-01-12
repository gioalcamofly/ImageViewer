package kata6.main;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.view.HistogramDisplay;
import kata6.view.MailHistogramBuilder;
import kata6.view.MailListReader;

public class Kata6 {
    
    private String filename;
    private List<Mail> mailList;
    private Histogram<String> histogram;

    public static void main(String[] args) throws IOException {
        Kata6 kata6 = new Kata6();
        kata6.execute();
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