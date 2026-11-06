public class Game {
    public static void main(String[] args) {
        Simulation simulation = new Simulation(32, 32, new DefaultEntityFactory());

        for (int tick = 1; tick <= 100; tick++) {
            simulation.tick();
        }
    }
}