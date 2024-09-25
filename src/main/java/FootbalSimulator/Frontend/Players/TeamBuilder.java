package FootbalSimulator.Frontend.Players;

import FootbalSimulator.Dependecies.Dir;
import FootbalSimulator.Dependecies.Position;
import FootbalSimulator.Player;

import java.awt.*;
import java.util.Random;

public abstract class TeamBuilder {
    // GK_LEFT_Pos (LEFT_Goal )
    // GK_RIGHT_Pos (RIGHT_Goal )
    private static final String [] TEAM_NAMES = {"KBR", "KHR", "KZR", "FCB", "MOB", "BRZ", "ANF"};
    private static final String [] LEFT_TEAM_PLAYERS_NAMES = {"11L", "10L", "9L", "8L", "7L", "6L", "5L", "4L", "3L", "2L", "1L"};
    private static final String [] RIGHT_TEAM_PLAYERS_NAMES = {"1R", "2R", "3R", "4R", "5R", "6R", "7R", "8R", "9R", "10R", "11R"};
    private static final int TOTAL_PLAYERS = 22;
    private static final int COUNT_PLAYER_FOR_TEAM = TOTAL_PLAYERS / 2;
    private static int current_team = 0;
    private static final Color LEFT_TEAM_COLOR = new Color(3, 186, 239);
    private static final Color RIGHT_TEAM_COLOR = new Color(232, 67, 67);

    private static float generateRandPosition() {
        return new Random().nextFloat(500);
    }


    public static Player[] getTeam() {
        Player[] players = new Player[COUNT_PLAYER_FOR_TEAM];
        for (int i = 0; i < players.length; ++i) {
            Player p;
            if(current_team == 0) {
                if(i == players.length - 1) {  current_team++; }
                // TODO: Twix the data
                p = new Player(getPlayerPosition(i), Dir.RIGHT, LEFT_TEAM_COLOR, PlayerType.ATTACKER);
            }else {
                p = new Player(getPlayerPosition(i), Dir.LEFT, RIGHT_TEAM_COLOR, PlayerType.DEFENDER);
            }
            players[i] = p;
        }
        return players;
    }

    public static Position getPlayerPosition(int i) {
        if(i == 0) return new Position((double) 1280/2, generateRandPosition());
        return new Position(generateRandPosition(), generateRandPosition());
    }


}
