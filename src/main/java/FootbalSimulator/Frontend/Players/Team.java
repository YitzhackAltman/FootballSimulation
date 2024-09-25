package FootbalSimulator.Frontend.Players;


import FootbalSimulator.Player;

import java.awt.*;
import java.util.Random;

public class Team {
    private static final int MAX_PLAYERS_ON_FILED = 22;
    private final Player[] players;
    private final String teamName;

    public Team(String name) {
        this.teamName = name;
        // First drawing left team then right
        players = TeamBuilder.getTeam();
    }

    // drawing each player
    public void draw(Graphics g) {
        for(int i = 0; i < players.length; ++i) {
            players[i].render(g);
        }
    }

    public Player getRandomPlayer() {
        return players[new Random().nextInt(players.length)];
    }

    public void movePlayers() { for (Player player : players) player.move(); }

    public Player[] getPlayers() {
        return players;
    }
}
