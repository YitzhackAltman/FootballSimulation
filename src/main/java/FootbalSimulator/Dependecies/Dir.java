package FootbalSimulator.Dependecies;

// TODO: Camera switch the values from negative to positive and backwards

//  x   y
// (0, -1) - UP
// (0, 1) - DOWN
// (-1, 0) - LEFT
// (1, 0) - RIGHT
public enum Dir {
    NONE(0, 0),
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);
    private final Position pos;
    Dir(float x, float y) {
        this.pos = new Position(x, y);
    }

    public Position getDirection() {
        return pos;
    }
}
