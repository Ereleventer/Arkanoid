import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-05-26
 */
public class KeyPressStoppableAnimation implements Animation {
    private boolean isAlreadyPressed;
    private KeyboardSensor sensor;
    private String key;
    private boolean stop;
    private Animation animation;

    /**
     * constructor.
     *
     * @param sensor    is the keyboard sensor
     * @param key       is the string of the key that should be clicked
     * @param animation is the animation to define.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.isAlreadyPressed = true;
        this.sensor = sensor;
        this.key = key;
        this.stop = false;
        this.animation = animation;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
        if (this.sensor.isPressed(key) && !isAlreadyPressed) {
            this.stop = true;
        }
        if (!this.sensor.isPressed(key)) {
            isAlreadyPressed = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }

}