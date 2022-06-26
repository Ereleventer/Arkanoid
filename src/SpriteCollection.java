/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-04-24
 */

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * defines the SpriteCollection class.
 */
public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * constructor.
     */
    public SpriteCollection() {
        sprites = new ArrayList<>();
    }

    /**
     * @param s is the new sprite to add.
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /**
     * @param s is the sprite to remove.
     */
    public void removeSprite(Sprite s) {
        sprites.remove(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spritesCopy = new ArrayList<Sprite>(this.sprites);

        for (Sprite spriteObj : spritesCopy) {
            spriteObj.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d is the DrawSurface
     */
    public void drawAllOn(DrawSurface d) {
        List<Sprite> spritesCopy = new ArrayList<Sprite>(this.sprites);

        for (Sprite spriteObj : spritesCopy) {
            spriteObj.drawOn(d);
        }
    }
}