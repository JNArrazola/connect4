package connect4;

public class App {
    public static void main(String[] args) {
        FileManagement.initialConfig();
        
        Game game = new Game();
        game.start();
    }
}
