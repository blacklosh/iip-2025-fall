import impl.GameService;
import impl.logic.GameLogic;
import impl.logic.RandomPixelColorLogic;
import impl.logic.SnakeGameLogic;
import impl.logic.TetrisGameLogic;

public class Main {
    public static void main(String[] args) {
        GameLogic gameLogic = new TetrisGameLogic();
        GameService gameService = new GameService(gameLogic);
        gameService.showFrame();
    }
}