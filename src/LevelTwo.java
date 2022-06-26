import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-05-26
 */
public class LevelTwo implements LevelInformation {
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
    public LevelTwo() {
        this.blockToRemove = 0;
        Color[] blocks = {BRIGHT_RED, BRIGHT_ORANGE, BRIGHT_YELLOW, BRIGHT_GREEN,
                BRIGHT_BLUE, BRIGHT_PURPLE, BRIGHT_RED, BRIGHT_BLUE, BRIGHT_GREEN};
        blocksColor = Arrays.asList(blocks);

    }

    /**
     * @return the number of balls in the level.
     */
    public int numberOfBalls() {
        return 10;
    }

    /**
     * @return the velocitied of the balls.
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        velocityList.add(Velocity.fromAngleAndSpeed(210, Const.BALL_SPEED));
        velocityList.add(Velocity.fromAngleAndSpeed(230, Const.BALL_SPEED));
        velocityList.add(Velocity.fromAngleAndSpeed(250, Const.BALL_SPEED));
        velocityList.add(Velocity.fromAngleAndSpeed(270, Const.BALL_SPEED));
        velocityList.add(Velocity.fromAngleAndSpeed(290, Const.BALL_SPEED));
        velocityList.add(Velocity.fromAngleAndSpeed(310, Const.BALL_SPEED));
        velocityList.add(Velocity.fromAngleAndSpeed(330, Const.BALL_SPEED));
        velocityList.add(Velocity.fromAngleAndSpeed(350, Const.BALL_SPEED));
        velocityList.add(Velocity.fromAngleAndSpeed(200, Const.BALL_SPEED));
        velocityList.add(Velocity.fromAngleAndSpeed(355, Const.BALL_SPEED));
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
        return 600;
    }

    /**
     * @return the level name.
     */
    public String levelName() {
        return "Wide Easy";
    }

    /**
     * @return the background sprite.
     */
    public Sprite getBackground() {
        LevelTwoBackground screen = new LevelTwoBackground();
        return screen;
    }

    /**
     * @return the background color sprite.
     */
    public Sprite getBackgroundColor() {
        Block screen = new Block(new Rectangle(new Point(0, 0), Const.GUI_WIDTH, Const.GUI_HEIGHT), Color.white);
        return screen;
    }

    /**
     * @return list of the blocks to add to the level.
     */
    public List<Block> blocks() {
        //define new list of blocks.
        List<Block> blockList = new ArrayList<>();
        //creating the blocks
        int blockAmount = 17, h = 0;
        for (int j = 0; j < blockAmount; j++) {
            Block b = new Block(new Rectangle(new Point((Const.GUI_WIDTH - Const.BLOCK_WIDTH * j) - 1
                    , 250 + Const.BLOCK_HEIGHT)
                    , Const.BLOCK_WIDTH
                    , Const.BLOCK_HEIGHT));
            if (j != 0 && j % 2 == 0) {
                h++;
            }
            b.setColor(blocksColor.get(h));
            this.blockToRemove++;
            blockList.add(b);
        }
        this.blockToRemove--;
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
        pointList.add(new Point(Const.GUI_WIDTH / 2, Const.GUI_HEIGHT - 50));
        pointList.add(new Point(Const.GUI_WIDTH / 2 + 1, Const.GUI_HEIGHT - 50));
        pointList.add(new Point(Const.GUI_WIDTH / 2, Const.GUI_HEIGHT - 50));
        pointList.add(new Point(Const.GUI_WIDTH / 2, Const.GUI_HEIGHT - 50));
        pointList.add(new Point(Const.GUI_WIDTH / 2, Const.GUI_HEIGHT - 50));
        pointList.add(new Point(Const.GUI_WIDTH / 2, Const.GUI_HEIGHT - 50));
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
