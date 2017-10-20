package kata3;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame {
    
    public HistogramDisplay() {
        super("Histograma de e-mails");
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
        dataSet.addValue(15, "", "ulpgc.es");
        dataSet.addValue(1, "", "hotmail.com");
        dataSet.addValue(10, "", "ull.es");
        dataSet.addValue(7, "", "gmail.com");
        return dataSet;
    }
}
