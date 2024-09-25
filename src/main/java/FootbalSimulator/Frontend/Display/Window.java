package FootbalSimulator.Frontend.Display;

import FootbalSimulator.Frontend.ui.listeners.KeyListener;
import FootbalSimulator.Frontend.ui.listeners.MouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Window {
    private final String window_title;
    private final int WIDTH;
    private final int HEIGHT;
    private JFrame frame;
    private Canvas canvas;
    private BufferedImage image;

    public Window(String window_title) {
        this.window_title = window_title;
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        WIDTH = d.width;
        HEIGHT = d.height;
        createWindow();
    }

    private void createWindow() {
        frame = new JFrame();
        frame.setSize(WIDTH, HEIGHT);
        frame.setTitle(window_title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        // set the window to the max size
        // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // frame.setResizable(false);
        // frame.toFront();
        // frame.setUndecorated(true);
        /////////////////////////////////////////
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setFocusable(false);
        frame.add(canvas);
        frame.pack();
    }

    public void clear() {
        Graphics graphics = canvas.getBufferStrategy().getDrawGraphics();
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
    }

    public void setVisible() {
        frame.setVisible(true);
    }

    public void setBufferStrategy(int bufferStrategy) {
        if(canvas.getBufferStrategy() == null) {
            canvas.createBufferStrategy(bufferStrategy);
        }
    }

    public Graphics getGraphics() {
        image = getImage();
        return image.getGraphics();
    }

    public void show() {
        drawImage(image);
        canvas.getBufferStrategy().show();
        canvas.getBufferStrategy().getDrawGraphics().dispose();
    }

    private BufferedImage getImage() {
        return new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    }

    private void drawImage(BufferedImage image) {
        canvas.getBufferStrategy().getDrawGraphics().drawImage(image, 0, 0,  WIDTH, HEIGHT, null);
    }

    public void addKeyListener(KeyListener keyListener) {
        frame.addKeyListener(keyListener);
        canvas.addKeyListener(keyListener);

    }

    public void addMouseListener(MouseListener mouseListener) {
        frame.addMouseListener(mouseListener);
        frame.addMouseMotionListener(mouseListener);
        canvas.addMouseListener(mouseListener);
        canvas.addMouseMotionListener(mouseListener);
    }

}
