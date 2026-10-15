import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Random;

public class main {
    
    private static final String DEFAULT_GRID = "mapGrid.txt"; 

    public static void main(String[] args) {
        
        String gridFile = null;
        long seed = null;
        for (String a : args) {
            if (a.startsWith("--grid=")) { 
                gridFile = a.substring("--grid=".length());
            } else if (a.startsWith("--seed=")) {
                seed = Long.parseLong(a.substring("--seed=".length()));
            }
        }
    }


}