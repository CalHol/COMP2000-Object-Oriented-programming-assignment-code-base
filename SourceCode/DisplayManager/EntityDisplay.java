import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class EntityDisplay extends JFrame {
    static final int ROWS = 32;
    static final int COLS = 32;
    static final int CELL_SIZE = 20;

    private final World world = new World(ROWS, COLS);
    private final GridPanel gridPanel = new GridPanel();

    public EntityDisplay() {
        setTitle("TestDisplay");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(gridPanel, BorderLayout.CENTER);

        Timer timer = new Timer(250, e -> {
            world.tick();
            gridPanel.repaint();
        });
        timer.start();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class GridPanel extends JPanel {
        GridPanel() {
            setPreferredSize(new Dimension(COLS * CELL_SIZE, ROWS * CELL_SIZE));
            setBackground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int row = 0; row < ROWS; row++) {
                for (int col = 0; col < COLS; col++) {
                    Entity entity = world.getEntityAt(col, row);
                    if (entity != null) {
                        g.setColor(entity.getColor());
                        g.fillRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                    }
                }
            }

            g.setColor(Color.BLACK);
            for (int row = 0; row <= ROWS; row++) {
                g.drawLine(0, row * CELL_SIZE, COLS * CELL_SIZE, row * CELL_SIZE);
            }
            for (int col = 0; col <= COLS; col++) {
                g.drawLine(col * CELL_SIZE, 0, col * CELL_SIZE, ROWS * CELL_SIZE);
            }
        }
    }
}
