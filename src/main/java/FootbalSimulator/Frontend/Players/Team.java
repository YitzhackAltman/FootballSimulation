package FootbalSimulator.Frontend.Players;


import FootbalSimulator.Player;

import java.awt.*;
import java.util.Random;

import static FootbalSimulator.Dependecies.Utils.camera;
import static FootbalSimulator.Dependecies.Utils.drawCharacterRelativeToCamera;

public class Team {
    private static final int MAX_PLAYERS_ON_FILED = 22;
    private final Player[] players;
    // TODO: Draw team name
    private final String teamName;
    private final int index;

    public Team(String name) {
        this.teamName = name;
        // First drawing left team then right
        players = TeamBuilder.getTeam();
        index = getRandomIndexPlayer();
    }

    // drawing each player
    public void draw(Graphics g) {
        for(int i = 0; i < players.length; ++i) {
            players[i].render(g);
        }
    }

    private int getRandomIndexPlayer() {
        return new Random().nextInt(players.length);
    }

    public Player getRandomPlayer() {
        assert index >= 0 && index < players.length;
        return players[index];
    }

    public void movePlayers() {
        for (int i = 0; i < players.length; i++) {
            if(i != index) players[i].move();
        }
    }

    public void displayCommandInfo() {
        for(int i = 0; i < players.length; ++i) {
            System.out.println((i + 1) + " "+ players[i]);
        }

        System.out.println(index + " MY " + players[index]);
    }

    public Player[] getPlayers() {
        return players;
    }
}
