package kata3;

public class Kata3 {

    public static void main(String[] args) {
        //Propuesta versión 4: Reducir el uso de increment para sólo usar 1 por dominio (usando dos parámetros de entrada)
        Histogram histogram = new Histogram();
        histogram.increment("hotmail.com", 10);
        histogram.increment("ulpgc.es", 7);
        histogram.increment("ull.es", 5);
        histogram.increment("gmail.com", 12);
        new HistogramDisplay(histogram).execute();
        
    }
    
}
