package FootbalSimulator.Frontend.GameObjects;

import FootbalSimulator.Dependecies.Position;

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
        g.drawLine((int)from.x, (int)from.y, (int)to.x, (int)to.y);
    }
}
