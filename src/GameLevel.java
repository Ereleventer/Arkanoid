import biuoop.DrawSurface;
import biuoop.GUI;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-04-24
 */

/**
 * this class implements the game gui and define the objects
 * and the run of the whole game.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Paddle paddle;
    private GUI gui;
    private Counter ballCounter;
    private BlockRemover blockRemover;
    private BallRemover deathRegion;
    private ScoreTrackingListener scoreSprite;
    private ScoreIndicator scoreView;
    public static final Color BRIGHT_GREY = new Color(214, 214, 214);
    private AnimationRunner runner;
    private boolean running;
    private LevelInformation level;
    private LevelIndicator levelName;
    private boolean isLastLevel;

    /**
     * @param level        is the level Information
     * @param gui          is the GUI to run
     * @param scoreSprite  is the scoreSprite
     * @param scoreView    is the score to view
     * @param istLastLevel is true if it's the last level, false if not.
     */
    public GameLevel(LevelInformation level, GUI gui, ScoreTrackingListener scoreSprite, ScoreIndicator scoreView,
                     boolean istLastLevel) {
        this.level = level;
        this.gui = gui;
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        paddle = new Paddle(gui.getKeyboardSensor(),
                new Rectangle(new Point(400 - (level.paddleWidth() / 2), Const.GUI_HEIGHT - Const.PADDLE_HEIGHT - 20),
                        this.level.paddleWidth(), Const.PADDLE_HEIGHT));
        this.blockRemover = new BlockRemover(this, new Counter());
        this.scoreSprite = scoreSprite;
        this.ballCounter = new Counter(level.numberOfBalls());
        this.deathRegion = new BallRemover(this, ballCounter);
        this.scoreView = scoreView;
        this.runner = new AnimationRunner(gui, sprites);
        this.levelName = new LevelIndicator(this.level.levelName());
        this.isLastLevel = istLastLevel;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        // the logic from the previous run method goes here.
        // the `return` or `break` statements should be replaced with
        // if there is no blocks to remove - end the game.
        if (gui.getKeyboardSensor().isPressed("p")) {
            this.runner = new AnimationRunner(gui);
            this.runner.run(new KeyPressStoppableAnimation(gui.getKeyboardSensor(), "space", new PauseScreen()), level);
            this.runner = new AnimationRunner(gui, sprites);
        }
        if (this.blockRemover.getRemainingBlocks().getValue() == 0) {
            this.scoreView.getScoreCounter().increase(100);
            // this.gui.close();
            this.running = false;
            if (isLastLevel && (getBlockRemover().getRemainingBlocks().getValue()) == 0) {
                this.runner = new AnimationRunner(gui);
                this.runner.run(new KeyPressStoppableAnimation(gui.getKeyboardSensor(), "space",
                        new WinScreen(scoreView)), level);
                gui.close();
            }
        }
        // if there is no balls to remove - end the game.
        if ((this.deathRegion.getBallCounter().getValue()) == 0) {
            this.running = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * @param c is the collidable to add.
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * @param s is the Sprite to add.
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * this function create blocks for the game.
     *
     * @return list of blocks.
     */
    private java.util.List<Ball> createBalls() {
        //define new list of blocks.
        List<Ball> ballList = new ArrayList<>();
        //creating the blocks
        for (int i = 0; i < level.numberOfBalls(); i++) {
            Ball ball = new Ball(level.ballsStartPoint().get(i), 5, level.ballColor());
            Velocity v = level.initialBallVelocities().get(i);
            ball.setVelocity(v);
            ball.setGameEnvironment(environment);
            ballList.add(ball);
        }
        return ballList;
    }

    /**
     * this function creates the limits (the game walls).
     *
     * @param width  is the Screen width,
     * @param height is the Screen hight.
     * @return list of blocks contain the walls.
     */
    private java.util.List<Block> createGameWalls(double width, double height) {
        Block top = new Block(new Rectangle(new Point(0, 0), width, 20), BRIGHT_GREY);
        Block bottom = new Block(new Rectangle(new Point(0, height - 2), width, 1));
        Block left = new Block(new Rectangle(new Point(0, 0), 1, height));
        Block right = new Block(new Rectangle(new Point(width - 2, 0), 1, height));
        Block[] blocks = {top, bottom, left, right};
        List<Block> blockList = Arrays.asList(blocks);
        bottom.addHitListener(this.deathRegion);
        return blockList;
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle)
     * and add them to the game.
     */
    public void initialize() {
        sprites.addSprite(this.level.getBackgroundColor());

        List<Block> walls = createGameWalls(Const.GUI_WIDTH, Const.GUI_HEIGHT);
        for (Block block : walls) {
            block.addToGame(this);
        }
        List<Block> blocks = this.level.blocks();
        this.blockRemover.getRemainingBlocks().setCounter(this.level.numberOfBlocksToRemove());
        for (Block block : blocks) {
            block.addHitListener(this.blockRemover);
            block.addToGame(this);
            block.addHitListener(scoreSprite);
        }
        //add the score to the game.
        scoreView.addToGame(this);
        levelName.addToGame(this);
        sprites.addSprite(this.level.getBackground());
        //define the balls.
        List<Ball> balls = createBalls();
        for (Ball ball : balls) {
            ball.addToGame(this);
        }

        //add the paddle to the game.
        paddle.addToGame(this);


    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        // countdown before turn starts.
        this.runner.run(new CountdownAnimation(sprites), level);
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this, level);
    }

    /**
     * @param c is the collidable to remove.
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * @param s is the sprite to remove.
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    /**
     * @return the deathRegion.
     */
    public BallRemover getDeathRegion() {
        return this.deathRegion;
    }

    /**
     * @return the BlockRemover
     */
    public BlockRemover getBlockRemover() {
        return blockRemover;
    }

    /**
     * @return the Runner
     */
    public AnimationRunner getRunner() {
        return runner;
    }

    /**
     * @param runnerSet is the runner to set.
     */
    public void setRunner(AnimationRunner runnerSet) {
        this.runner = runnerSet;
    }
}