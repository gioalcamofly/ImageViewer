package kata3;

public class Kata3 {

    public static void main(String[] args) {
        //Propuesta versión 4: Reducir el uso de increment para sólo usar 1 por dominio (usando dos parámetros de entrada)
        Histogram histogram = new Histogram();
        histogram.increment("gmail.com");
        histogram.increment("gmail.com");
        histogram.increment("gmail.com");
        histogram.increment("ulpgc.es");
        histogram.increment("ulpgc.es");
        histogram.increment("ulpgc.es");
        histogram.increment("ull.es");
        histogram.increment("ull.es");
        histogram.increment("ull.es");
        histogram.increment("ull.es");
        histogram.increment("hotmail.com");
        histogram.increment("hotmail.com");
        histogram.increment("hotmail.com");
        histogram.increment("hotmail.com");
        histogram.increment("hotmail.com");
        histogram.increment("hotmail.com");
        histogram.increment(1);
        histogram.increment(1);
        histogram.increment(1);
        histogram.increment(1);
        histogram.increment(1);
        new HistogramDisplay(histogram).execute();
        
    }
    
}
