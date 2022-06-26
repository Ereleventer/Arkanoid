/**
 * @author 315009449.
 * @version 1.0
 * @since 2020-05-26
 */
public class Counter {
    private int counter;

    /**
     * constructor - set the counter value to be zero.
     */
    public Counter() {
        this.counter = 0;
    }

    /**
     * @param count is the count value to start from.
     */
    public Counter(int count) {
        this.counter = count;
    }

    /**
     * @param counterSet is the new counter to set.
     */
    public void setCounter(int counterSet) {
        this.counter = counterSet;
    }

    /**
     * add number to current count.
     *
     * @param number is the number to add to the count.
     */
    void increase(int number) {
        this.counter = this.counter + number;
    }

    /**
     * subtract number from current count.
     *
     * @param number is the number to decrease from the counter.
     */
    void decrease(int number) {
        this.counter = this.counter - number;
    }


    /**
     * get current count.
     *
     * @return the counter value.
     */
    int getValue() {
        return this.counter;
    }
}