package FootbalSimulator.Frontend.ui.listeners;

import FootbalSimulator.Frontend.states.GameState.GameState;
import FootbalSimulator.Player;
import FootbalSimulator.Dependecies.Dir;

import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener {
    private static Player player;

    public static void setPlayer(Player p) {
        player = p;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> player.setDirection(Dir.UP);
            case KeyEvent.VK_D -> player.setDirection(Dir.RIGHT);
            case KeyEvent.VK_A -> player.setDirection(Dir.LEFT);
            case KeyEvent.VK_S -> player.setDirection(Dir.DOWN);
            default -> {
                assert true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.setDirection(Dir.NONE);
    }
}
