import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-05-26
 */
public class LevelFourBackground implements Sprite {

    @Override
    public void drawOn(DrawSurface d) {

        //cloud one
        d.setColor(new Color(235, 236, 240));
        d.drawLine(100, 430, 80, 600);
        d.drawLine(110, 430, 90, 600);
        d.drawLine(120, 430, 100, 600);
        d.drawLine(130, 430, 110, 600);
        d.drawLine(140, 430, 120, 600);
        d.drawLine(150, 430, 130, 600);
        d.drawLine(160, 430, 140, 600);
        d.drawLine(170, 430, 150, 600);
        d.drawLine(180, 430, 160, 600);
        d.drawLine(190, 430, 170, 600);
        d.fillCircle(100, 400, 25);
        d.fillCircle(120, 430, 25);
        d.setColor(new Color(210, 210, 210));
        d.fillCircle(140, 400, 30);
        d.setColor(new Color(190, 190, 190));
        d.fillCircle(160, 430, 25);
        d.setColor(new Color(190, 190, 190));
        d.fillCircle(180, 410, 28);
        //cloud two
        d.setColor(new Color(235, 236, 240));
        d.drawLine(600, 500, 580, 600);
        d.drawLine(610, 500, 590, 600);
        d.drawLine(620, 500, 600, 600);
        d.drawLine(630, 500, 610, 600);
        d.drawLine(640, 500, 620, 600);
        d.drawLine(650, 500, 630, 600);
        d.drawLine(660, 500, 640, 600);
        d.drawLine(670, 500, 650, 600);
        d.drawLine(680, 500, 660, 600);
        d.drawLine(690, 500, 670, 600);
        d.fillCircle(600, 500, 25);
        d.fillCircle(620, 530, 25);
        d.setColor(new Color(210, 210, 210));
        d.fillCircle(640, 500, 30);
        d.setColor(new Color(190, 190, 190));
        d.fillCircle(660, 530, 25);
        d.setColor(new Color(190, 190, 190));
        d.fillCircle(680, 510, 28);
    }

    @Override
    public void timePassed() {

    }
}
