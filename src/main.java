import java.io.File;
import java.util.*;

public class main {

    static List<Player> players;
    public static void readFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String playerName;
                String teamName;
                int score;

                if (scan.hasNext()) {
                    playerName = scan.next();
                } else {
                    throw new Exception("Line Does Not Contain 3 Elements...");
                }
                if (scan.hasNext()) {
                    teamName = scan.next();
                } else {
                    throw new Exception("Line Does Not Contain 3 Elements...");
                }
                if (scan.hasNextInt()) {
                    score = scan.nextInt();
                } else {
                    throw new Exception("Line Does Not Contain 3 Elements...");
                }

                players.add(new Player(playerName, teamName, score));
            }
            scan.close();
        }catch (Exception e) {
            System.out.println("File Couldn't Open.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        players = new ArrayList<>();
        readFile("src/Players.txt");
        // Unsorted
        for (Player player : players) {
            System.out.println(player.getPlayerName() + " " + player.getTeamName() + " " + player.getScore());
        }

        System.out.println("\n####################################\n");
        System.out.println("Sorted by Player Score\n");

        // Sorted by Score
        players.sort(Player::compareTo);
        for (Player player : players) {
            System.out.println(player.getPlayerName() + " " + player.getTeamName() + " " + player.getScore());
        }

        System.out.println("\n####################################\n");

        // Sorted by Player name
        System.out.println("Sorted by Player Name\n");
        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                String x1 = o1.getTeamName();
                String x2 = o2.getTeamName();
                int sComp = x1.compareTo(x2);

                if (sComp != 0) {return sComp;}

                String y1 = o1.getPlayerName();
                String y2 = o2.getPlayerName();
                return y1.compareTo(y2);
            }
        });
        for (Player player : players) {
            System.out.println(player.getPlayerName() + " " + player.getTeamName() + " " + player.getScore());
        }
    }
}
