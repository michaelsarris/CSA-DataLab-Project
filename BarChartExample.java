import java.awt.*;
import javax.swing.*;

public class BarChartExample extends JPanel {

    private int[] data;
    private String[] labels;

    public BarChartExample(int[] data, String[] labels) {
        this.data = data;
        this.labels = labels;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();
        int barWidth = (width / data.length) - 10;

        int max = 0;
        for (int value : data) {
            if (value > max) {
                max = value;
            }
        }

        // Draw bars and labels
        for (int i = 0; i < data.length; i++) {
            int barHeight = (int) (((double) data[i] / max) * height);
            int x = i * (barWidth + 10);
            int y = height - barHeight;

            // Set color for the bar
            g2d.setColor(Color.BLUE);
            g2d.fillRect(x, y, barWidth, barHeight);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(x, y, barWidth, barHeight);

            // Draw labels under each bar
            g2d.setColor(Color.BLACK);
            String label = labels[i];
            FontMetrics fm = g2d.getFontMetrics();
            int labelWidth = fm.stringWidth(label);
            int labelX = x + (barWidth - labelWidth) / 2;
            g2d.drawString(label, labelX, height - 5);  // Adjusting y to position below the bar
        }
    }
}
