package FootbalSimulator.Frontend.states;

public class StateManager {
    private static volatile StateManager stateManagerInstance;
    private State currentState;

    public StateManager() {
         currentState = null;
    }

    public static State getCurrentState() {
        handleInstance();
        return stateManagerInstance.currentState;
    }

    public static void setCurrentState(State state) {
        handleInstance();
        stateManagerInstance.currentState = state;
    }

    public static void handleInstance() {
        if(stateManagerInstance == null) {
            stateManagerInstance = new StateManager();
        }
    }
}
