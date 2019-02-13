package task2;

public class Model {

    private int targetValue;
    private int rangeLow;
    private int rangeTop;
    private int tries;

    public void setTargetValue(int targetValue) {
        this.targetValue = targetValue;
    }

    public int getTargetValue() {
        return targetValue;
    }

    //Test passed
    public int generateValue() {
        return (int) Math.ceil(Math.random() * (rangeTop - rangeLow - 1) + rangeLow);
    }

    public void setRange(int rangeLow, int rangeTop) {
        this.rangeLow = rangeLow;
        this.rangeTop = rangeTop;
    }

    public int getRangeLow() {
        return rangeLow;
    }

    public int getRangeTop() {
        return rangeTop;
    }

    public void addTry() {
        tries++;
    }

    public int getTries() {
        return tries;
    }

    /**
     * Checks value.
     * If value is target returns true.
     * If value is less or more returns false.
     *
     * @param value
     * @return
     */
    public boolean checkForTarget(int value) {
        addTry();

        if ((value < targetValue)) {
            rangeLow = value;
        } else if (value > targetValue) {
            rangeTop = value;
        } else {
            return false;
        }

        return true;
    }

}
