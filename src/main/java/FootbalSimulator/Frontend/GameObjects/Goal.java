package FootbalSimulator.Frontend.GameObjects;

import FootbalSimulator.Dependecies.Position;

import java.awt.*;

public class Goal {
    private Position goalPosition;
    private final Position goalWidthHeight;

    public Goal() {
        // TODO: set proper Goal position
        goalPosition = new Position();
        goalWidthHeight = new Position(30, 300);
    }


    public void render(Graphics g) {
        g.setColor(Color.red);
        if(goalPosition.x != 0 && goalPosition.y != 0) {
            g.fillRect((int)goalPosition.x, (int)goalPosition.y - (int)goalWidthHeight.y/2,
                    (int)goalWidthHeight.x, (int)goalWidthHeight.y);
        }

        g.setColor(Color.WHITE);
    }

    public void setGoalPosition(Position linePosition) {
        this.goalPosition = linePosition;
    }
}
