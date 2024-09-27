package FootbalSimulator.Dependecies;

import FootbalSimulator.Frontend.GameObjects.Camera;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class Utils {

    private static final int CAMERA_PADDING = 100 * 2;
    public static BufferedImage loadImageFromFile(String imageName, String imageType) {
        try {
            return ImageIO.read(Utils.class.getResource("/" + imageName + imageType));
        }catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    public static BufferedImage resizeImage(BufferedImage originalImage, int newWidth, int newHeight) {
        BufferedImage image = new BufferedImage(newWidth, newHeight, originalImage.getType());
        Graphics graphics = image.getGraphics();
        graphics.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
        return image;
    }

    public static Position drawCharacterRelativeToCamera(Position cameraPosition, Position characterPosition) {
        return new Position((characterPosition.x - (cameraPosition.x - CAMERA_PADDING)), (characterPosition.y - (cameraPosition.y - CAMERA_PADDING)));
    }

    public static Camera camera =  new Camera(new Position(0,0));
}
