package FootbalSimulator.Frontend.states;


import FootbalSimulator.Application;

import java.awt.*;

public abstract class State {

    protected Application application;

    public State(Application application) {
        this.application = application;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
}
