import java.util.LinkedList;
import java.util.Scanner;

public class QuickResistor {

    // Private instance variables for color and tolerance codes
    private LinkedList<String> color_codes;
    private LinkedList<String> tolerance_codes;
    private LinkedList<Integer> value_codes;

    // Constructor to initialize the color and tolerance codes
    public QuickResistor() {
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

        value_codes = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            value_codes.add(i);
        }
    }

    // Public method to calculate resistance based on band colors
    public void calculateResistance(String[] band_colors, String tolerance_color) {
        // Get the color codes for each band
        String band1 = band_colors[0];
        String band2 = band_colors[1];
        String band3 = band_colors[2];

        // Get the index of the color in the linked list
        int index1 = color_codes.indexOf(band1);
        int index2 = color_codes.indexOf(band2);
        int index3 = color_codes.indexOf(band3);

        //Get the values in the second linkedlist for these indexes
        int value1 = value_codes.get(index1);
        int value2 = value_codes.get(index2);
        int value3 = value_codes.get(index3);
        //Update the values
        value1 = value1-1;
        value2 = value2-1;
        value3 = value3-1;

        // Calculate the register value and multiplier based on the color codes
        int register_value = Integer.parseInt(String.format("%d%d", value1, value2));
        int multiplier = (int) Math.pow(10, value3);
        // Calculate and return the resistance value
        double calculated = (double) register_value * multiplier;
       
        if (tolerance_color.equals("golden")) {
            System.out.println("Resistance: " + calculated + " ohms +5%");
        } else if (tolerance_color.equals("silver")) {
            System.out.println("Resistance: " + calculated + " ohms +10%");
        } else {
            System.out.println("Invalid tolerance color!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuickResistor finalObject = new QuickResistor();

        String[] band_colors = new String[3];
        String[] valid_colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "gray", "white"};


        //convert this into a function of polymorphism in which if the input has 5 inputs the function changes
        System.out.println("------------------------------ Welcome to QuickResistor ------------------------------");
        for (int i = 0; i < 3; i++) {
            while (true) {
                System.out.print("Enter color for band " + (i + 1) + ": ");
                String color = scanner.nextLine().toLowerCase();

                if (finalObject.isValidColor(color, valid_colors)) {
                    band_colors[i] = color;
                    break;
                } else {
                    System.out.println("Invalid color entered. Please enter one of the following: " + String.join(", ", valid_colors));
                }
            }
        }

        String tolerance_color;
        String[] valid_tolerance_colors = {"golden", "silver"};

        while (true) {
            System.out.print("Enter tolerance color (golden/silver): ");
            tolerance_color = scanner.nextLine().toLowerCase();
            if (finalObject.isValidColor(tolerance_color, valid_tolerance_colors)) {
            break;
        } else {
            System.out.println("Invalid tolerance color entered. Please enter 'golden' or 'silver'");
        }
    }

    finalObject.calculateResistance(band_colors, tolerance_color);
}
// Private method to check if a color is valid
private boolean isValidColor(String color, String[] valid_colors) {
    for (String valid_color : valid_colors) {
        if (color.equals(valid_color)) {
            return true;
        }
    }
    return false;
}
}
