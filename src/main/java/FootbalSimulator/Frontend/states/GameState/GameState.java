package FootbalSimulator.Frontend.states.GameState;

import FootbalSimulator.Application;
import FootbalSimulator.Frontend.FootballField;
import FootbalSimulator.Frontend.states.State;

import java.awt.*;

public class GameState extends State {
    protected volatile FootballField field;

    public GameState(Application application) {
        super(application);
        field = new FootballField(this);
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
