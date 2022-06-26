import biuoop.GUI;
import java.util.List;

/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-05-26
 */
public class GameFlow {
    private ScoreTrackingListener scoreSprite;
    private ScoreIndicator scoreView;
    private GUI gui;
    private boolean isStartLevel;
    private boolean isLastLevel;

    /**
     * Constructor.
     */
    public GameFlow() {
        this.scoreSprite = new ScoreTrackingListener();
        this.scoreView = new ScoreIndicator(this.scoreSprite.getCurrentScore());
        gui = new GUI("Arkanoid", Const.GUI_WIDTH, Const.GUI_HEIGHT);
        this.isLastLevel = false;
        this.isStartLevel = false;
    }

    /**
     * @param levels is the list of levels to run.
     */
    public void runLevels(List<LevelInformation> levels) {
        int size = levels.size(), i = 0;
        for (LevelInformation levelInfo : levels) {
            if (i == size - 1) {
                isLastLevel = true;
            } else {
                isLastLevel = false;
            }
            GameLevel level = new GameLevel(levelInfo, gui, scoreSprite, scoreView, isLastLevel);
            level.initialize();
            level.run();

            if ((level.getDeathRegion().getBallCounter().getValue()) == 0) {
                level.setRunner(new AnimationRunner(gui));
                level.getRunner().run(new KeyPressStoppableAnimation(gui.getKeyboardSensor(), "space",
                        new DeathScreen(scoreView)), levelInfo);
                gui.close();
            }

            i++;

        }


    }
}