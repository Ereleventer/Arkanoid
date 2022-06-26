import java.util.ArrayList;
import java.util.List;

/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-04-24
 */

public class Ass6Game {

    /**
     * the main function runs the entire game.
     *
     * @param args is the input from the user.
     */
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<>();
        if (args.length >= 1) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("1")) {
                    levels.add(new LevelOne());
                }
                if (args[i].equals("2")) {
                    levels.add(new LevelTwo());
                }
                if (args[i].equals("3")) {
                    levels.add(new LevelThree());
                }
                if (args[i].equals("4")) {
                    levels.add(new LevelFour());
                }
            }
        }
        if (!levels.isEmpty()) {
            GameFlow game = new GameFlow();
            game.runLevels(levels);
        } else {
            levels.add(new LevelOne());
            levels.add(new LevelTwo());
            levels.add(new LevelThree());
            levels.add(new LevelFour());
            GameFlow game = new GameFlow();
            game.runLevels(levels);
        }
    }
}

