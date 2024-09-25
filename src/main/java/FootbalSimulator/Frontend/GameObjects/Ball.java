package FootbalSimulator.Frontend.GameObjects;

import FootbalSimulator.Dependecies.Position;

import java.awt.image.BufferedImage;

public class Ball {
    private BufferedImage ballImage;
    private Position ballPosition;
    //private Dir direction;

    public Ball(Position ballPosition) {
        this.ballPosition = ballPosition;
    }


}
