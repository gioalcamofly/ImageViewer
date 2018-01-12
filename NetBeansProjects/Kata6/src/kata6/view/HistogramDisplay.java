package kata6.view;

import java.awt.Dimension;
import javax.swing.JPanel;
import kata6.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;


public class HistogramDisplay<T> extends ApplicationFrame {
    
    private final Histogram<T> histogram;
    private final String nameEdgeX;
    
    
    public HistogramDisplay(Histogram<T> histogram, String nameEdgeX) {
        super("Histograma");
        this.histogram = histogram;
        this.nameEdgeX = nameEdgeX;
        setContentPane(CreatePanel());
        pack();
    }
    
    public void execute() {
        setVisible(true);
    }
    
    private JPanel CreatePanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension (500, 400));
        return chartPanel;
        
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Histograma JFreeChar", 
                "Dominios email", 
                "Número de emails", 
                dataSet, 
                PlotOrientation.VERTICAL, 
                false, 
                true,
                rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (T key : histogram.keySet()) {
            dataSet.addValue(histogram.get(key), "", (Comparable)key);
        }
        return dataSet;
    }
}