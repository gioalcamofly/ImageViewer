package kata6.main;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.view.HistogramDisplay;
import kata6.view.HistogramBuilder;
import kata6.view.FileMailListReader;

public class Kata6 {
    
    
    
    public static void main(String[] args) throws IOException {
        String filename = "/home/giovanni/Documentos/mail.txt";
        List<Mail> mailList = FileMailListReader.read(filename);
        HistogramBuilder<Mail> builder = new HistogramBuilder<>(mailList);
        Histogram<String> domains = builder.build(new Attribute<Mail, String>() {
            @Override
            public String get(Mail item) {
                return item.getMail().split("@")[1];
            }
        });
        
        new HistogramDisplay(domains, "Dominios").execute();
        
        Histogram<Character> characters = builder.build(new Attribute<Mail, Character>() {
            @Override
            public Character get(Mail item) {
                return item.getMail().charAt(0);
            }
        });
        
        new HistogramDisplay(characters, "Primer Caracter").execute();
    
    }
       
}