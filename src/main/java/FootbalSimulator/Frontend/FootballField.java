package FootbalSimulator.Frontend;


import FootbalSimulator.Dependecies.LineIndex;
import FootbalSimulator.Frontend.GameObjects.Line;
import FootbalSimulator.Frontend.ui.listeners.KeyListener;
import FootbalSimulator.Player;
import FootbalSimulator.Dependecies.Position;
import FootbalSimulator.Frontend.GameObjects.Ball;
import FootbalSimulator.Frontend.GameObjects.Goal;

import FootbalSimulator.Frontend.Players.Team;
import FootbalSimulator.Frontend.states.GameState.GameState;

import static FootbalSimulator.Dependecies.Utils.camera;


import java.awt.*;

public class FootballField {
    private static final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    private static final int FOOTBALL_FIELD_HEIGHT = dimension.height;
    private static final int FOOTBALL_FIELD_WIDTH = dimension.width * FOOTBALL_FIELD_HEIGHT/1000;
    private Ball ball;
    private Goal[] goals;
    private final Goal leftGoal;
    private final Goal rightGoal;
    private Team[] teams;
    private final Team leftTeam;
    private final Team rightTeam;
    private final Line lines[];
    protected final GameState gameState;
    public boolean gameStarted;
    private int secondsForEachRotation;
    private final Player myPlayer;
    private String introCounter;
    private Long startTime;
    private static final String LEFT_TEAM_NAME = "FCB";
    private static final String RIGHT_TEAM_NAME = "MDB";
    public FootballField(GameState gameState) {
        lines = new Line[LineIndex.MAX_LINES.ordinal()];

        secondsForEachRotation = 3;
        gameStarted = false;
        this.gameState = gameState;



        rightGoal = new Goal();
        leftGoal = new Goal();

        leftTeam = new Team(LEFT_TEAM_NAME);
        rightTeam = new Team(RIGHT_TEAM_NAME);


        myPlayer = leftTeam.getRandomPlayer();
        myPlayer.setTshort_color(new Color(236, 6, 6));

        KeyListener.setPlayer(myPlayer);

        // TODO: The camera starts with the ball position



    }

    public void tick() {
        if(!gameStarted) {
            if (startTime == null) {
                startTime = System.currentTimeMillis();
            }
            long difference = System.currentTimeMillis() - startTime;
            int duration = 1000;
            if(difference >= duration) {
                startTime = System.currentTimeMillis();
            }

            if(secondsForEachRotation <= 0) {
                introCounter = "GO!";
            } else {
                introCounter = String.valueOf(secondsForEachRotation);
            }

            if(secondsForEachRotation == -1) {
                gameStarted = true;
            }
        }

        leftTeam.movePlayers();
        // TODO: rightTeam.movePlayers();
        camera.updateCameraPosition(myPlayer.getDirection());



        leftTeam.displayCommandInfo();

    }

    public void render(Graphics g) {
        // TODO: Position ball position
        drawFootballField(g, new Position(0, 0));



        if(leftGoal != null) {
            //leftGoal.render(g);
        }

        if(rightGoal != null) {
            rightGoal.render(g);
        }

        leftTeam.draw(g);


        // TODO: rightTeam.draw(g);

        // TODO: myPlayer.setPosition(Player.myPlayer);

        // Moves the whole canvas  with my player position
        //gameState.moveCanvas(myPlayer::getPosition);

/*
        if(ball != null ) {
            ball.render(g);
        }

        */


    }

    // Ball position start in the center of the field
    private void drawFootballField(Graphics g, Position ballPosition) {
        g.setColor(Color.WHITE);

        // line
        final Position upperLineFrom = new Position(-FOOTBALL_FIELD_WIDTH, -FOOTBALL_FIELD_HEIGHT);
        final Position upperLienTo = new Position(FOOTBALL_FIELD_WIDTH, -FOOTBALL_FIELD_HEIGHT);
        g.drawLine((int)upperLineFrom.x, (int)upperLineFrom.y, FOOTBALL_FIELD_WIDTH, (int)upperLineFrom.y);

        lines[LineIndex.LINE_UPPER.ordinal()] = new Line(upperLineFrom, upperLienTo);

        final Position middleLineFrom = new Position((double)FOOTBALL_FIELD_WIDTH/2 - (double) FOOTBALL_FIELD_WIDTH/4, -FOOTBALL_FIELD_HEIGHT);
        final Position middleLineTo = new Position((double)FOOTBALL_FIELD_WIDTH/2 - (double) FOOTBALL_FIELD_WIDTH/4, FOOTBALL_FIELD_HEIGHT);

        lines[LineIndex.LINE_MIDDLE.ordinal()] = new Line(middleLineFrom, middleLineTo);

        // Circle Position
        final Position bigCircleRadius = new Position(80, 80);
        // Draw Line
       // g.drawLine((int)middleLineFrom.x , (int)middleLineFrom.y, (int)middleLineFrom.x, FOOTBALL_FIELD_HEIGHT);

        // Draw Circle
        g.drawOval((int)(middleLineFrom.x - bigCircleRadius.x/2), (int)(middleLineFrom.y/2 - (int)bigCircleRadius.y/2), (int)bigCircleRadius.x, (int)bigCircleRadius.y);

        g.setColor(Color.RED);
        // Circle Position
        final Position smallCircleRadius = new Position(bigCircleRadius.x/10, bigCircleRadius.y/10);
        g.fillOval((int)(middleLineFrom.x - smallCircleRadius.x/2), (int)(middleLineFrom.y/2  - smallCircleRadius.y/2),(int)smallCircleRadius.x, (int)smallCircleRadius.y);
        // Line Position
        g.setColor(Color.WHITE);

        final Position bottomLineFrom = new Position(-FOOTBALL_FIELD_WIDTH, FOOTBALL_FIELD_HEIGHT);
        final Position bottomLineTo = new Position(FOOTBALL_FIELD_WIDTH, FOOTBALL_FIELD_HEIGHT);
        // g.drawLine((int)bottomLineFrom.x, (int)bottomLineFrom.y, FOOTBALL_FIELD_WIDTH, (int)bottomLineFrom.y);

        lines[LineIndex.LINE_BOTTOM.ordinal()] = new Line(bottomLineFrom, bottomLineTo);


        final Position leftLineFrom = new Position(-FOOTBALL_FIELD_WIDTH, -FOOTBALL_FIELD_HEIGHT);
        final Position leftLineTo =  new Position(-FOOTBALL_FIELD_WIDTH, FOOTBALL_FIELD_HEIGHT);
        // g.drawLine((int)leftLineFrom.x, (int)leftLineFrom.y, (int)leftLineFrom.x, FOOTBALL_FIELD_HEIGHT);
        leftGoal.setGoalPosition(leftLineFrom);

        lines[LineIndex.LINE_LEFT.ordinal()] = new Line(leftLineFrom, leftLineTo);


        final Position rightLineFrom = new Position(FOOTBALL_FIELD_WIDTH , FOOTBALL_FIELD_HEIGHT);
        final Position rightLineTo = new Position(FOOTBALL_FIELD_WIDTH, -FOOTBALL_FIELD_HEIGHT);
        // g.drawLine((int)rightLineFrom.x, (int)rightLineFrom.y, (int) rightLineFrom.x, -FOOTBALL_FIELD_HEIGHT);

        lines[LineIndex.LINE_RIGHT.ordinal()] = new Line(rightLineFrom, rightLineTo);

        rightGoal.setGoalPosition(new Position(rightLineFrom.x, rightLineFrom.y/2));

        for (Line line : lines) {
            line.drawLine(g);
        }
    }

    // HANDLE TEAM NOT MANUALLY
    private void createTeams() {
        teams = new Team[2];
        for(int i =0; i < teams.length; ++i) {
            teams[i] = new Team(getTeamName(i));
        }
    }

    private static String getTeamName(int i) {
        return (i == 0) ? LEFT_TEAM_NAME : RIGHT_TEAM_NAME;
    }
}


/*
*
* canvas setPosition(OnPlayerMove move);
* player position(x, y);
* lambda OnPlayerMove(player_pos.x, player_pos.y);
*
*
* */