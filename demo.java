import java.util.LinkedList;
// Parent class Demo
public class Demo {

    // Private instance variables for color and tolerance codes
    private LinkedList<String> color_codes;
    private LinkedList<String> tolerance_codes;

    // Constructor to initialize the color and tolerance codes
    public Demo() {
        color_codes = new LinkedList<>();
        color_codes.add("black");
        color_codes.add("brown");
        color_codes.add("red");
        color_codes.add("orange");
        color_codes.add("yellow");
        color_codes.add("green");
        color_codes.add("blue");
        color_codes.add("violet");
        color_codes.add("gray");
        color_codes.add("white");

        tolerance_codes = new LinkedList<>();
        tolerance_codes.add("golden");
        tolerance_codes.add("silver");
    }

    // Public method to calculate resistance based on band colors
    public double calculateResistance(String[] band_colors) {
        // Get the color codes for each band
        String band1 = band_colors[0];
        String band2 = band_colors[1];
        String band3 = band_colors[2];

        // Get the index of the color in the linked list
        int index1 = color_codes.indexOf(band1);
        int index2 = color_codes.indexOf(band2);
        int index3 = color_codes.indexOf(band3);

        // Calculate the register value and multiplier based on the color codes
        int register_value = Integer.parseInt(String.format("%d%d", index1, index2));
        int multiplier = (int) Math.pow(10, index3);

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

    public static void main(String[] args) {
        String[] colors = {"brown", "black", "orange"};
        FixedDemo resistor = new FixedDemo(5);
        double resistance = resistor.calculateResistance(colors);
        int tolerance = resistor.getToleranceCodes().getOrDefault("golden", -1);
    
        System.out.printf("Resistance: %.2f ohms +/- %d%%\n", resistance, tolerance);
    }
    
}