package FootbalSimulator.Frontend.ui.buttons;

import FootbalSimulator.Frontend.ui.listeners.ClickListener;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ActualButton extends Button{
    protected final ClickListener clickListener;
    public ActualButton(float x, float y, int width, int height, String text_field, int fontSize, ClickListener clickListener) {
        super(x, y, width, height, text_field, fontSize);
        this.clickListener = clickListener;
    }

    @Override
    public void render(Graphics g) {
        // BufferedImage image =
        // g.drawImage(image, this.)
    }

    @Override
    public void onClick() {
        clickListener.onClick();
    }
}
