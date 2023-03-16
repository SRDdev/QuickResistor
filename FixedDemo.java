public class FixedDemo extends Demo {

    // Private instance variable for tolerance value
    private int tolerance;

    // Constructor to initialize the tolerance value
    public FixedDemo(int tolerance) {
        this.tolerance = tolerance;
    }

    // Getter method for tolerance value
    public int getTolerance() {
        return tolerance;
    }

    // Setter method for tolerance value
    public void setTolerance(int tolerance) {
        this.tolerance = tolerance;
    }
}