import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class EntityDisplay extends JFrame {
    static final int ROWS = 32;
    static final int COLS = 32;
    static final int PREFERRED_CELL_SIZE = 30;
    static final int MIN_SPAWN_INTERVAL_TICKS = 17;
    static final int MAX_SPAWN_INTERVAL_TICKS = 24;
    private final World world = new World(ROWS, COLS);
    private final GridPanel gridPanel = new GridPanel();
    private final JLabel countLabel = new JLabel();
    private final JTextArea entityList = new JTextArea();

    public EntityDisplay() {
        setTitle("TestDisplay");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        world.addSpawner(new Spawner((x, y) -> new Sheep(x, y, 10), MIN_SPAWN_INTERVAL_TICKS, MAX_SPAWN_INTERVAL_TICKS));
        world.addSpawner(new Spawner((x, y) -> new Shrub(x, y, 1), MIN_SPAWN_INTERVAL_TICKS, MAX_SPAWN_INTERVAL_TICKS));
        world.addSpawner(new Spawner((x, y) -> new Wolf(x, y, 10), MIN_SPAWN_INTERVAL_TICKS, MAX_SPAWN_INTERVAL_TICKS));
        add(gridPanel, BorderLayout.CENTER);
        add(createCounterPanel(), BorderLayout.EAST);
        updateEntityCounter();

        Timer timer = new Timer(250, e -> {
            world.tick();
            gridPanel.repaint();
            updateEntityCounter();
        });
        timer.start();

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    private JPanel createCounterPanel() {
        JPanel counterPanel = new JPanel(new BorderLayout(8, 8));
        counterPanel.setBorder(new EmptyBorder(12, 12, 12, 12));
        counterPanel.setPreferredSize(new Dimension(260, 100));
        counterPanel.add(countLabel, BorderLayout.NORTH);

        entityList.setEditable(false);
        entityList.setFont(new java.awt.Font(java.awt.Font.MONOSPACED, java.awt.Font.PLAIN, 13));
        counterPanel.add(new JScrollPane(entityList), BorderLayout.CENTER);
        return counterPanel;
    }

    private void updateEntityCounter() {
        Map<String, Integer> counts = new LinkedHashMap<>();
        counts.put("Tree", 0);
        counts.put("Shrub", 0);
        counts.put("Sheep", 0);
        counts.put("Wolf", 0);

        List<Entity> sortedEntities = new ArrayList<>(world.getEntities());
        sortedEntities.sort((first, second) -> {
            int nameOrder = first.getName().compareTo(second.getName());
            return nameOrder != 0 ? nameOrder : Integer.compare(first.getAge(), second.getAge());
        });

        StringBuilder rows = new StringBuilder("Name      Age\n----------------\n");
        for (Entity entity : sortedEntities) {
            counts.merge(entity.getName(), 1, Integer::sum);
            rows.append(String.format("%-9s %d%n", entity.getName(), entity.getAge()));
        }

        countLabel.setText(String.format(
                "<html><b>Entity Counter</b><br>Tree: %d &nbsp; Shrub: %d<br>Sheep: %d &nbsp; Wolf: %d</html>",
                counts.get("Tree"), counts.get("Shrub"), counts.get("Sheep"), counts.get("Wolf")));
        entityList.setText(rows.toString());
        entityList.setCaretPosition(0);
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
