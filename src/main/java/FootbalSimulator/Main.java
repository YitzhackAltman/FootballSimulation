package FootbalSimulator;


public class Main {
    public static void main(String[] args) {
         Application application = new Application();
         application.application_start();




        //Camera camera = new Camera(new Position(1, 1));
    }
}

/**
 * я предлагаю рендерить только плитки внутри границ экрана.
 *
 * public void render(Graphics g) {
 *     for (int y = 0; y < mapHeight(); y++) {
 *         for (int x = 0; x < mapWidth(); x++) {
 *
 *             Tile tile = getTile(x, y); // Custom method that gets the tile at xy coordinate
 *
 *             tile.render((x * tile.getWidth()) - camera.getX(), (y * tile.getHeight()) - camera.getY(), g); // renders tile at designated position
 *         }
 *     }
 * }
 * */