package FootbalSimulator;

import FootbalSimulator.Frontend.Display.Window;
import FootbalSimulator.Frontend.states.GameState.GameState;
import FootbalSimulator.Frontend.states.StateManager;
import FootbalSimulator.Frontend.ui.listeners.KeyListener;
import FootbalSimulator.Frontend.ui.listeners.MouseListener;

import java.awt.*;

public class Application {
    private static boolean isRunning;
    private Window window;
    private MouseListener mouseListener;
    private KeyListener keyListener;
    private int fps;

    public Application() {
        isRunning = false;
    }
    public void application_start() {
        if(isRunning) {
            return;
        }

        initialize();
        run();

    }

    public static synchronized void application_stop() {
        if(!isRunning) {
            return;
        }

        isRunning = false;
        System.exit(0);
    }

    private void initialize() {
        window = new Window("Simulator");
        window.setBufferStrategy(3);

        mouseListener = new MouseListener();
        keyListener = new KeyListener();
        window.addMouseListener(mouseListener);
        window.addKeyListener(keyListener);

        StateManager.setCurrentState(new GameState(this));
    }


    private void run() {
        window.setVisible();
        isRunning = true;

        final double FPS = 60;
        double update = 1000000000 / FPS;
        double lastUpdate = 0;
        long now;
        long time = System.nanoTime();
        int timer = 0;
        int tick = 0;
        while(isRunning) {
            now = System.nanoTime();
            lastUpdate += (now - time) / update;
            timer += now - time;
            time = now;
            if(lastUpdate >= 1) {
                tick();
                render();
                lastUpdate--;
                tick++;
            }

            if(timer >= 1000000000) {
                fps = tick;
                tick = 0;
                timer = 0;
            }
        }
    }

    private void tick() {
        if(StateManager.getCurrentState() != null) {
            StateManager.getCurrentState().tick();
        }
    }

    private void render() {
        Graphics g = window.getGraphics();
        window.clear();
        if(StateManager.getCurrentState() != null) {
            StateManager.getCurrentState().render(g);
            g.setColor(Color.WHITE);
            g.drawString("FPS: " + fps,30, 60);
        }
        window.show();
    }
}
