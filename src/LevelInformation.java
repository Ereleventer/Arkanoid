
import java.awt.Color;
import java.util.List;

/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-05-26
 */
public interface LevelInformation {
    /**
     * @return the number of balls.
     */
    int numberOfBalls();

    /**
     * @return list of velocities.
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return the paddle speed.
     */
    int paddleSpeed();

    /**
     * @return the paddle width.
     */
    int paddleWidth();

    /**
     * @return the level name - it will be displayed at the top of the screen.
     */
    String levelName();

    /**
     * @return a sprite with the background of the level
     */
    Sprite getBackground();

    /**
     * @return a sprite with the background color of the level
     */
    Sprite getBackgroundColor();

    /**
     * @return list of blocks to be added to the level.
     */
    List<Block> blocks();

    /**
     * @return Number of blocks that should be removed
     */
    int numberOfBlocksToRemove();

    /**
     * @return list of the balls start points.
     */
    List<Point> ballsStartPoint();

    /**
     * @return the ball color.
     */
    Color ballColor();


}