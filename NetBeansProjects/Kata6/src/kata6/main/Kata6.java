package kata6.main;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.model.Person;
import kata6.view.HistogramDisplay;
import kata6.view.HistogramBuilder;
import kata6.view.DatabaseList;
import kata6.view.FileMailListReader;

public class Kata6 {
    
    
    
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        String filename = "/home/giovanni/Documentos/emails.txt";
        List<Mail> mailList = FileMailListReader.read(filename);
        HistogramBuilder<Mail> builder = new HistogramBuilder<>(mailList);
        Histogram<String> domains = builder.build(new Attribute<Mail, String>() {
            @Override
            public String get(Mail item) {
                return item.getMail().split("@")[1];
            }
        });
        
        new HistogramDisplay(domains, "Dominios", "Nº Emails").execute();
        
        Histogram<Character> characters = builder.build(new Attribute<Mail, Character>() {
            @Override
            public Character get(Mail item) {
                return item.getMail().charAt(0);
            }
        });
        
        new HistogramDisplay(characters, "Primer Caracter", "Nº Emails").execute();
    
        
        List <Person> people = DatabaseList.read("/home/giovanni/Documentos/KATA.sDB");
        HistogramBuilder<Person> builderPerson = new HistogramBuilder<>(people);
        
        Histogram<Character> gender = builderPerson.build(new Attribute<Person, Character>() {
            @Override
            public Character get (Person item) {
                return item.getGender();
                
            }
        });
        
        new HistogramDisplay(gender, "Géneros", "Nº de personas").execute();
        
        Histogram<Float> weights = builderPerson.build(new Attribute<Person, Float>() {
            @Override
            public Float get(Person item) {
                return item.getWeight();
                
            }
        });
        
        new HistogramDisplay(weights, "Pesos", "Nº de personas").execute();
        
    }
       
}