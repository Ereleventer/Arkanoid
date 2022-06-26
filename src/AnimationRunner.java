import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-04-24
 * The AnimationRunner takes an Animation object and runs it
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;
    private SpriteCollection sprites;

    /**
     * Constructor.
     *
     * @param gui     is the gui to run.
     * @param sprites in the spriteCollection.
     */
    public AnimationRunner(GUI gui, SpriteCollection sprites) {
        this.gui = gui;
        this.sprites = sprites;
        this.framesPerSecond = 60;
        this.sleeper = new biuoop.Sleeper();
    }

    /**
     * Constructor.
     *
     * @param gui is the gui to run.
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
        this.framesPerSecond = 60;
        this.sleeper = new biuoop.Sleeper();
        this.sprites = null;
    }


    /**
     * @param animation is the animation to run.
     * @param level     is the level information.
     */
    public void run(Animation animation, LevelInformation level) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            // if the animation is the countdown - dont draw the sprites.
            // in the countdown nothing should move.
            if (sprites != null && animation.getClass().getName() != "CountdownAnimation") {
                this.sprites.drawAllOn(d);
                this.sprites.notifyAllTimePassed();
            }
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}