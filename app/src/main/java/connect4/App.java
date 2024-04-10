package connect4;

public class App {
    public static void main(String[] args) {
        FileManagement.initialConfig();
        TimeManagement.deserializeItems();

        Game game = new Game();
        game.start();
    }
}
