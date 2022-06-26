import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-05-26
 */
public class LevelThree implements LevelInformation {
    // private BlockRemover blockRemover;
    private int blockToRemove;
    private List<Color> blocksColor;
    public static final Color BRIGHT_PURPLE = new Color(191, 178, 243);
    public static final Color BRIGHT_YELLOW = new Color(229, 225, 171);
    public static final Color BRIGHT_GREEN = new Color(156, 220, 170);
    public static final Color BRIGHT_BLUE = new Color(150, 202, 247);
    public static final Color BRIGHT_ORANGE = new Color(243, 198, 165);
    public static final Color BRIGHT_RED = new Color(248, 163, 168);

    /**
     * Constructor.
     */
    public LevelThree() {
        this.blockToRemove = 0;
        Color[] blocks = {BRIGHT_RED, BRIGHT_ORANGE, BRIGHT_YELLOW, BRIGHT_GREEN,
                BRIGHT_BLUE, BRIGHT_PURPLE, BRIGHT_RED};
        blocksColor = Arrays.asList(blocks);

    }

    /**
     * @return the number of balls in the level.
     */
    public int numberOfBalls() {
        return 2;
    }

    /**
     * @return the velocitied of the balls.
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        velocityList.add(Velocity.fromAngleAndSpeed(220, Const.BALL_SPEED));
        velocityList.add(Velocity.fromAngleAndSpeed(310, Const.BALL_SPEED));
        return velocityList;
    }

    /**
     * @return the paddle speed.
     */
    public int paddleSpeed() {
        return 5;
    }

    /**
     * @return the width of the paddle.
     */
    public int paddleWidth() {
        return Const.PADDLE_WIDTH;
    }

    /**
     * @return the level name.
     */
    public String levelName() {
        return "Green 3";
    }

    /**
     * @return the background sprite.
     */
    public Sprite getBackgroundColor() {
        Block screen = new Block(new Rectangle(new Point(0, 0),
                Const.GUI_WIDTH, Const.GUI_HEIGHT), new Color(144, 201, 120));
        return screen;
    }

    /**
     * @return the background color sprite.
     */
    public Sprite getBackground() {
        LevelThreeBackground screen = new LevelThreeBackground();
        return screen;
    }

    /**
     * @return list of the blocks to add to the level.
     */
    public List<Block> blocks() {
        //define new list of blocks.
        List<Block> blockList = new ArrayList<>();
        //creating the blocks
        int linesAmount = 5, blockAmount = 10;
        for (int i = 0; i < linesAmount; i++) {
            for (int j = 0; j < blockAmount - i; j++) {
                Block b = new Block(new Rectangle(new Point((Const.GUI_WIDTH - Const.BLOCK_WIDTH * j) - 1
                        , Const.BLOCK_STARTING_Y + Const.BLOCK_HEIGHT * i)
                        , Const.BLOCK_WIDTH
                        , Const.BLOCK_HEIGHT));
                b.setColor(blocksColor.get(i));
                this.blockToRemove++;
                blockList.add(b);
            }
            this.blockToRemove--;
        }
        return blockList;
    }

    /**
     * @return the start point of the balls.
     */
    public List<Point> ballsStartPoint() {
        //define new list of blocks.
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(Const.GUI_WIDTH / 2, Const.GUI_HEIGHT - 50));
        pointList.add(new Point(Const.GUI_WIDTH / 2, Const.GUI_HEIGHT - 50));
        return pointList;
    }

    /**
     * @return the number of blocks left to remove.
     */
    public int numberOfBlocksToRemove() {
        return blockToRemove;
    }

    /**
     * @return the ball color.
     */
    public Color ballColor() {
        return Color.white;
    }


}
