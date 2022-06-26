import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-05-26
 */
public class LevelThreeBackground implements Sprite {

    @Override
    public void drawOn(DrawSurface d) {
        //(int x, int y, int width, int height)
        d.setColor(new Color(87, 87, 87));
        d.fillRectangle(95, 215, 10, 180);
        d.setColor(new Color(65, 65, 65));
        d.fillRectangle(85, 375, 30, 50);
        d.setColor(new Color(50, 50, 50));
        d.fillRectangle(50, 425, 100, 173);
        d.setColor(Color.white);
        d.fillRectangle(55, 430, 10, 20);
        d.fillRectangle(75, 430, 10, 20);
        d.fillRectangle(95, 430, 10, 20);
        d.fillRectangle(115, 430, 10, 20);
        d.fillRectangle(135, 430, 10, 20);
        d.fillRectangle(55, 460, 10, 20);
        d.fillRectangle(75, 460, 10, 20);
        d.fillRectangle(95, 460, 10, 20);
        d.fillRectangle(115, 460, 10, 20);
        d.fillRectangle(135, 460, 10, 20);
        d.fillRectangle(55, 490, 10, 20);
        d.fillRectangle(75, 490, 10, 20);
        d.fillRectangle(95, 490, 10, 20);
        d.fillRectangle(115, 490, 10, 20);
        d.fillRectangle(135, 490, 10, 20);
        d.fillRectangle(55, 520, 10, 20);
        d.fillRectangle(75, 520, 10, 20);
        d.fillRectangle(95, 520, 10, 20);
        d.fillRectangle(115, 520, 10, 20);
        d.fillRectangle(135, 520, 10, 20);
        d.fillRectangle(55, 550, 10, 20);
        d.fillRectangle(75, 550, 10, 20);
        d.fillRectangle(95, 550, 10, 20);
        d.fillRectangle(115, 550, 10, 20);
        d.fillRectangle(135, 550, 10, 20);
        d.fillRectangle(55, 580, 10, 20);
        d.fillRectangle(75, 580, 10, 20);
        d.fillRectangle(95, 580, 10, 20);
        d.fillRectangle(115, 580, 10, 20);
        d.fillRectangle(135, 580, 10, 20);
        d.setColor(new Color(255, 244, 156));
        d.fillCircle(100, 200, 15);
        d.setColor(new Color(255, 117, 109));
        d.fillCircle(100, 200, 10);
        d.setColor(Color.WHITE);
        d.fillCircle(100, 200, 3);

    }

    @Override
    public void timePassed() {

    }
}
