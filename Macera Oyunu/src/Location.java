import java.util.Scanner;

public abstract class Location {
    private Player player;
    String name;
    private boolean isCleared;
    public static Scanner input = new Scanner(System.in);

    public Location(Player player, String name) {
        this.player = player;
        this.name = name;

    }

    //bütün lokasyonlar yazılsın istiyoruz.
    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private boolean isCleared() {
        return isCleared;
    }

    public void setCleared(boolean cleared) {
        isCleared = cleared;
    }
}
