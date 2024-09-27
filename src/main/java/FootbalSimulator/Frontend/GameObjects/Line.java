package FootbalSimulator.Frontend.GameObjects;

import FootbalSimulator.Dependecies.Position;
import FootbalSimulator.Dependecies.Utils;

import java.awt.*;

public class Line {
    private final Position from;
    private final Position to;

    public Line(Position from, Position to) {
        this.from = from;
        this.to = to;
    }

    public void isPassTheLine(Position p) {
        Position linePos = linePos();
        Position pDir = p.normalize();
    }
    private Position linePos() {
        return to.sub(from);
    }

    public void drawLine(Graphics g) {
        Position drawFrom = Utils.drawCharacterRelativeToCamera(Utils.camera.getCameraPosition(), from);
        Position drawTo = Utils.drawCharacterRelativeToCamera(Utils.camera.getCameraPosition(), to);

        g.drawLine((int)drawFrom.x, (int)drawFrom.y, (int)drawTo.x, (int)drawTo.y);
    }
}
