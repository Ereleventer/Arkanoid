import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-04-24
 * The CountdownAnimation will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private int count;
    private SpriteCollection gameScreen;
    private boolean stop;

    /**
     * Constructor.
     *
     * @param gameScreen is the SpriteCollection to run.
     */
    public CountdownAnimation(SpriteCollection gameScreen) {
        numOfSeconds = 2;
        countFrom = 4;
        count = 4;
        this.gameScreen = gameScreen;
        this.stop = false;

    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        long milliSecondLeftToSleep = (long) (1000 * (numOfSeconds / countFrom));
        sleeper.sleepFor(milliSecondLeftToSleep);
        String drawing = String.valueOf(count - 1);
        d.setColor(new Color(217, 146, 148));
        d.fillCircle(380, 270, 80);
        d.setColor(new Color(245, 183, 183));
        d.fillCircle(380, 270, 75);
        d.setColor(Color.WHITE);
        d.drawText(350, d.getHeight() / 2, drawing, 100);
        count = count - 1;
        if (this.count == 0) {
            this.stop = true;
        }

    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
