package FootbalSimulator;

import FootbalSimulator.Dependecies.Position;
import FootbalSimulator.Dependecies.Dir;
import FootbalSimulator.Frontend.Players.PlayerType;

import java.awt.*;
import java.awt.image.BufferedImage;

import static FootbalSimulator.Dependecies.Utils.camera;
import static FootbalSimulator.Dependecies.Utils.drawCharacterRelativeToCamera;

public class Player {
    private final String name;
    private Position position;
    private final Position widthHeight = new Position(40, 40);
    private static final float SPEED = 2f;
    private final PlayerType type;
    private Dir direction;
    // private double fov;
    private BufferedImage playerImg;
    private Color tshort_color;
    // private Score score;


    public Player(Position position, Dir direction, Color tshort_color, PlayerType type) {
       this.position = position;
       this.direction = direction;
       this.tshort_color = tshort_color;
       this.type = type;
       this.name = "hello java";
       this.direction = Dir.DOWN;


    }

    public void render(Graphics g) {
        Position drawPosition = drawCharacterRelativeToCamera(camera.getCameraPosition(), position);

        g.setColor(Color.GREEN);
        g.drawString(name, (int)drawPosition.x, (int)(drawPosition.y - widthHeight.y/4));
        g.setColor(tshort_color);
        g.fillRect((int)drawPosition.x, (int)drawPosition.y, (int)widthHeight.x, (int)widthHeight.y);
    }

    public Position getPosition() {
        return position;
    }

    public Dir getDirection() {
        return direction;
    }


    public void setPosition(Position position) {
        this.position = position;
    }

    public void setDirection(Dir direction) {
        this.direction = direction;
    }

    public void move() {
        this.position = position.add(direction.getDirection().scale(SPEED));
        // this.position = drawCharacterRelativeToCamera(camera.getCameraPosition(), position);
//        if(this.position.x <= 0) {
//            this.direction = Dir.RIGHT;
//        }else if(this.position.x - widthHeight.x + widthHeight.x/4 >= 1280) {
//            this.direction = Dir.LEFT;
//        }else if (this.position.y <= 0) {
//            this.direction = Dir.DOWN;
//        } else if (this.position.y - widthHeight.y + widthHeight.y/4 >= 720) {
//            this.direction = Dir.UP;
//        }
    }

    public void setTshort_color(Color c) {
        this.tshort_color = c;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Player p)) return false;

        if(p == this) return true;

        return p.position.equals(this.position) && p.name.equals(this.name);
    }

    @Override
    public String toString() {
        return "Player Position: "  + position + ", Camera Position: " + camera.getCameraPosition();
    }
}
