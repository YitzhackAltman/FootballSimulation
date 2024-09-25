package FootbalSimulator.Frontend.ui.listeners;

import FootbalSimulator.Player;
import FootbalSimulator.Dependecies.Dir;

import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> Player.setPosition(Dir.UP);
            case KeyEvent.VK_D -> Player.setPosition(Dir.RIGHT);
            case KeyEvent.VK_A -> Player.setPosition(Dir.LEFT);
            case KeyEvent.VK_S -> Player.setPosition(Dir.DOWN);
            default -> {
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
