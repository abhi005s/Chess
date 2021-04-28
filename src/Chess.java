import game.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chess {
    public static void main(String[] args) throws IOException {
        /* this is base */
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        Game game=new Game();
        game.initGame(br);
    }
}
