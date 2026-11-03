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
    static final int PREFERRED_CELL_SIZE = 30;
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

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    class GridPanel extends JPanel {
        GridPanel() {
            setPreferredSize(new Dimension(COLS * PREFERRED_CELL_SIZE, ROWS * PREFERRED_CELL_SIZE));
            setBackground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int cellSize = Math.max(1, Math.min(getWidth() / COLS, getHeight() / ROWS));
            int gridWidth = COLS * cellSize;
            int gridHeight = ROWS * cellSize;
            int gridX = (getWidth() - gridWidth) / 2;
            int gridY = (getHeight() - gridHeight) / 2;

            for (int row = 0; row < ROWS; row++) {
                for (int col = 0; col < COLS; col++) {
                    Entity entity = world.getEntityAt(col, row);
                    if (entity != null) {
                        g.setColor(entity.getColor());
                        g.fillRect(gridX + col * cellSize, gridY + row * cellSize, cellSize, cellSize);
                    }
                }
            }

            g.setColor(Color.BLACK);
            for (int row = 0; row <= ROWS; row++) {
                g.drawLine(gridX, gridY + row * cellSize, gridX + gridWidth, gridY + row * cellSize);
            }
            for (int col = 0; col <= COLS; col++) {
                g.drawLine(gridX + col * cellSize, gridY, gridX + col * cellSize, gridY + gridHeight);
            }
        }
    }
}
