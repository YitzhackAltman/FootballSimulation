package FootbalSimulator;

import FootbalSimulator.Dependecies.Position;
import FootbalSimulator.Dependecies.Dir;
import FootbalSimulator.Frontend.Players.PlayerType;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    private final String name;
    private Position position;
    private final Position widthHeight = new Position(40, 40);
    private static final float SPEED = 1.0f;
    private final PlayerType type;
    private Dir direction;
    // private double fov;
    private BufferedImage playerImg;
    private final Color tshort_color;
    // private Score score;
    public static Position myPlayer = new Position(25, 25);


    public Player(Position position, Dir direction, Color tshort_color, PlayerType type) {
       this.position = position;
       this.direction = direction;
       this.tshort_color = tshort_color;
       this.type = type;
       this.name = "hello java";
       this.direction = Dir.UP;


    }

    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawString(name, (int)position.x, (int)(position.y - widthHeight.y/4));
        g.setColor(tshort_color);
        g.fillRect((int)position.x, (int)position.y, (int)widthHeight.x, (int)widthHeight.y);
    }

    public Position getPosition() {
        return position;
    }

    public Position getDirection() {
        return direction.getDirection();
    }

    public static void setPosition(Dir direction) {
        myPlayer = myPlayer.add(direction.getDirection().scale(SPEED * 2));
    }

    public static void setPosition(float x, float y) {
        myPlayer = new Position(x, y);
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void move() {
        this.position = position.add(direction.getDirection().scale(SPEED));
        if(this.position.x <= 0) {
            this.direction = Dir.RIGHT;
        }else if(this.position.x >= 1280) {
            this.direction = Dir.LEFT;
        }else if (this.position.y <= 0) {
            this.direction = Dir.DOWN;
        } else if (this.position.y >= 720) {
            this.direction = Dir.UP;
        }
    }
}
