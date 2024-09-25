package FootbalSimulator.Frontend.ui.buttons;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class Button {
    protected final float x;
    protected final float y;
    protected final int width;
    protected final int height;
    protected final String text_field;
    protected final int fontSize;
    protected boolean clicked;
    private final Rectangle bounds;

    public Button(float x, float y, int width, int height, String text_field, int fontSize) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text_field = text_field;
        this.fontSize = fontSize;
        clicked = false;

        bounds = new Rectangle();
    }

    public abstract void render(Graphics g);

    public abstract void onClick();

    public void mouseMove(MouseEvent e) {
        clicked = bounds.contains(e.getX(), e.getY());
    }

}
