package FootbalSimulator.Frontend.states.GameState;

import FootbalSimulator.Dependecies.Position;
@FunctionalInterface
public interface OnPlayerMove {
    Position player_move();
}
