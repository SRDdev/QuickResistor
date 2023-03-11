import java.util.HashMap;

// Parent class Demo
public class demo {

    // Private instance variables for color and tolerance codes
    private HashMap<String, Integer> color_codes;
    private HashMap<String, Integer> tolerance_codes;

    // Constructor to initialize the color and tolerance codes
    public Resistor() {
        color_codes = new HashMap<>() {{
            put("black", 0);
            put("brown", 1);
            put("red", 2);
            put("orange", 3);
            put("yellow", 4);
            put("green", 5);
            put("blue", 6);
            put("violet", 7);
            put("gray", 8);
            put("white", 9);
        }};

        tolerance_codes = new HashMap<>() {{
            put("golden", 5);
            put("silver", 10);
        }};
    }

    // Public method to calculate resistance based on band colors
    public double calculateResistance(String[] band_colors) {
        // Get the color codes for each band
        String band1 = band_colors[0];
        String band2 = band_colors[1];
        String band3 = band_colors[2];

        // Calculate the register value and multiplier based on the color codes
        int register_value = Integer.parseInt(String.format("%d%d", color_codes.get(band1), color_codes.get(band2)));
        int multiplier = (int) Math.pow(10, color_codes.get(band3));

        // Calculate and return the resistance value
        if(register_value > 10 && multiplier >= Math.pow(10, 2) && multiplier < Math.pow(10, 6)) {
            double calculated = (double) register_value * multiplier;
            return calculated / Math.pow(10, 2);
        } else if(register_value > 10 && multiplier >= Math.pow(10, 6) && multiplier < Math.pow(10, 9)) {
            double calculated = (double) register_value * multiplier;
            return calculated / Math.pow(10, 6);
        } else if(register_value > 10 && multiplier >= Math.pow(10, 9)) {
            double calculated = (double) register_value * multiplier;
            return calculated / Math.pow(10, 9);
        } else {
            return -1;
        }
    }

    // Public method to get tolerance value based on color
    public int getTolerance(String color) {
        return tolerance_codes.getOrDefault(color, -1);
    }

}

// Child class FixedDemo, inherits from parent class Demo
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
