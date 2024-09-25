package FootbalSimulator.Frontend.states.GameState;

import FootbalSimulator.Application;
import FootbalSimulator.Dependecies.Position;
import FootbalSimulator.Frontend.FootballField;
import FootbalSimulator.Frontend.states.State;

import java.awt.*;

public class GameState extends State {
    protected volatile FootballField field;
    private Canvas canvas;

    public GameState(Application application) {
        super(application);
        field = new FootballField(this);
    }

   private boolean hasCanvas() {
        return canvas != null;
   }

   public void moveCanvas(OnPlayerMove move) {
       Position playerPos = move.player_move();
       canvas.setLocation((int)playerPos.x, (int)playerPos.y);
   }
    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void tick() {
        field.tick();
    }

    @Override
    public void render(Graphics g) {
        if(field == null) {
            return;
        }

        field.render(g);
    }
}
