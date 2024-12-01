import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;

public class Driver {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Load data from the CSV file (you may modify this logic depending on the structure of your CSV)
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("colours_rgb_shades.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        }

        // For demonstration, using hardcoded data
        int[] data = {20, 15, 30, 10, 25};
        String[] labels = {"Bar 1", "Bar 2", "Bar 3", "Bar 4", "Bar 5"};

        JFrame frame = new JFrame("Bar Chart Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Pass both data and labels to the chart
        BarChartExample chart = new BarChartExample(data, labels);
        chart.setPreferredSize(new Dimension(600, 300));

        frame.getContentPane().add(chart);
        frame.pack();
        frame.setVisible(true);
    }
}
