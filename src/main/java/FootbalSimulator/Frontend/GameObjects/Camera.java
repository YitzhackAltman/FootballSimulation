package FootbalSimulator.Frontend.GameObjects;

import FootbalSimulator.Dependecies.Position;
import FootbalSimulator.Frontend.Display.Window;

import java.awt.*;

public class Camera {
    private Position cameraPosition;
    private final int DEFAULT_SCREEN_WIDTH = 1280;
    private final int DEFAULT_SCREEN_HEIGHT = 720;
    private final Position DEFAULT_CAMERA_PROJECTION;
    private Position direction;
    private static final int CAMERA_OFFSET = 10 * 2;
    public static Position linePosition;

    public Camera(Position cameraPosition, Position direction ) {
        DEFAULT_CAMERA_PROJECTION = new Position(DEFAULT_SCREEN_WIDTH + cameraPosition.x, DEFAULT_SCREEN_WIDTH + cameraPosition.y);
        this.direction = direction;
        this.cameraPosition = cameraPosition;
        linePosition = new Position(500, 500);
    }

    public void updateCameraPosition(Position direction) {
        cameraPosition = cameraPosition.add(direction);
        this.direction = direction;
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillOval((int)cameraPosition.x - 50/4 - CAMERA_OFFSET, (int)cameraPosition.y, 50/2, 50/2);
        // g.drawLine((int) cameraPosition.x, (int) cameraPosition.y, (int)(direction.x), (int)direction.y);
        // g.drawLine((int)linePosition.x, (int)linePosition.y, 100, 100);
        g.setColor(Color.WHITE);
    }
}
