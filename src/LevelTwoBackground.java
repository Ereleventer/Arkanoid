import biuoop.DrawSurface;

import java.awt.Color;
/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-05-26
 */
public class LevelTwoBackground implements Sprite {

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(250, 218, 94));
        //  d.drawLine(80, 210, 5, 250 + Const.BLOCK_HEIGHT);
        Point p = new Point(0, 0);
        for (int i = 0; i <= 700; i += 9) {
            d.drawLine(110, 180, i, 270);
        }
        d.setColor(new Color(250, 218, 94));
        d.fillCircle(120, 150, 80);
        d.setColor(new Color(255, 233, 123));
        d.fillCircle(120, 150, 70);
        d.setColor(new Color(255, 255, 159));
        d.fillCircle(120, 150, 60);
    }

    @Override
    public void timePassed() {

    }
}
