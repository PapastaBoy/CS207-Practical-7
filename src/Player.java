public class Player implements Comparable<Player> {
    private String playerName;
    private String teamName;
    private int score;

    public Player(String playerName, String teamName, int score) {
        this.playerName = playerName;
        this.teamName = teamName;
        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) throws Exception {
        if (score < 1 || score > 30) throw new Exception("Score outwith range. Must lie between 1 and 30 inclusive");
        this.score = score;
    }

    @Override
    public int compareTo(Player player) {
        return -Integer.compare(this.score, player.score);
    }
}
