
package kata2;

import java.util.HashMap;
import java.util.Map;

public class Kata2 {

  
    public static void main(String[] args) {
        // TODO code application logic here
        String [] data = {"Rosa", "Pepe", "Juan", "Rosa", "Rosa", "Juan"};
        histogram histo = new histogram(data);
        Map<String, Integer> histogr = histo.getHistogram();
        
        
        
        for (String key : histogr.keySet()) {
            System.out.println(key + " ===> " + histogr.get(key));
        }
        
    }
    
}
