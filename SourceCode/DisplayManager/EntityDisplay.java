import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import SpawnersAndGameState.World;
import SpawnersAndGameState.EntitySpawner;

public class EntityDisplay extends JFrame {

    //define display variables 
    static final int ROWS = 32;
    static final int COLS = 32;
    static final int CELL_SIZE = 20;

    //define world and grid panel
    private final World world = new World(ROWS, COLS);
    private final GridPanel gridPanel = new GridPanel();

    //define grid panel class that extends JPanel
    public EntityDisplay() {
        setTitle("TestDisplay");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(gridPanel, BorderLayout.CENTER);

        //adds sepreate display timer for repainting that repaints 4 times every second
        Timer timer = new Timer(250, e -> {
            world.tick();
            gridPanel.repaint();
        });

        timer.start();

        //set the size of the display and make it visible
        pack();
        setLocationRelativeTo(null);
        setVisible(false);
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
                    if (entity != null){
                        g.setColor(entity.getColor());
                        g.fillRect(
                            col * CELL_SIZE, 
                            row * CELL_SIZE, 
                            CELL_SIZE, CELL_SIZE
                        );
                    }
                }
            }
        }
    }
}
