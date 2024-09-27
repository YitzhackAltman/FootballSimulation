package FootbalSimulator.Frontend.GameObjects;

import FootbalSimulator.Dependecies.Dir;
import FootbalSimulator.Dependecies.Position;
import FootbalSimulator.Frontend.Display.Window;

import java.awt.*;

public class Camera {
    private final Position cameraPosition;
    private final int DEFAULT_SCREEN_WIDTH = 1280;
    private final int DEFAULT_SCREEN_HEIGHT = 720;
    private final Position DEFAULT_CAMERA_PROJECTION;
    private static final int CAMERA_OFFSET = 10 * 2;

    public Camera(Position cameraPosition) {
        // DEFAULT_CAMERA_PROJECTION: TODO: insert
        DEFAULT_CAMERA_PROJECTION = new Position(DEFAULT_SCREEN_WIDTH + cameraPosition.x, DEFAULT_SCREEN_WIDTH + cameraPosition.y);
        this.cameraPosition = cameraPosition;
    }

    public void updateCameraPosition(Dir direction) {
        Position dir = direction.getDirection();
        cameraPosition.x += dir.x * 2;
        cameraPosition.y += dir.y * 2;
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillOval((int)cameraPosition.x - 50/4 - CAMERA_OFFSET, (int)cameraPosition.y, 50/2, 50/2);
        g.setColor(Color.WHITE);
    }

    public Position getCameraPosition() {
        return cameraPosition;
    }
    @Override
    public String toString() {
        return "Pos: " + cameraPosition;
    }
}
