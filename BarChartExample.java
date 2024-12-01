import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class BarChartExample extends JPanel {

    private int[] data;
    JLabel jl;

    public BarChartExample(int[] data) {
        this.data = data;
        jl = new JLabel("bar 1");
        add(jl);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();
        int barWidth = (width / data.length)-10;

        int max = 0;
        for (int value : data) {
            if (value > max) {
                max = value;
            }
        }

        for (int i = 0; i < data.length; i++) {
            int barHeight = (int) (((double) data[i] / max) * height);
            int x = i * barWidth;
            int y = height - barHeight;

            g2d.setColor(Color.BLUE);
            g2d.fillRect(x, y, barWidth, barHeight);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(x, y, barWidth, barHeight);
        }
    }
}