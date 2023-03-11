import java.util.HashMap;

public class register {

    static HashMap<String, Integer> color_codes = new HashMap<>() {{
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
    
    static HashMap<String, Integer> Tolerance_codes = new HashMap<>() {{
        put("golden", 5);
        put("silver", 10);
    }};
    
    public static void detect(String[] band_colors) {
        String band1 = band_colors[0];
        String band2 = band_colors[1];
        String band3 = band_colors[2];
        
        int register_value = Integer.parseInt(String.format("%d%d", color_codes.get(band1), color_codes.get(band2)));
        int multiplier = (int) Math.pow(10, color_codes.get(band3));
        
        if(register_value > 10 && multiplier >= Math.pow(10, 2) && multiplier < Math.pow(10, 6)) {
            double calculated = (double) register_value * multiplier;
            double answer = calculated / Math.pow(10, 2);
            System.out.printf("The value of Register is : %.2f Kohms\n", answer);
        } else if(register_value > 10 && multiplier >= Math.pow(10, 6) && multiplier < Math.pow(10, 9)) {
            double calculated = (double) register_value * multiplier;
            double answer = calculated / Math.pow(10, 6);
            System.out.printf("The value of Register is : %.2f Mohms\n", answer);
        } else if(register_value > 10 && multiplier >= Math.pow(10, 9)) {
            double calculated = (double) register_value * multiplier;
            double answer = calculated / Math.pow(10, 9);
            System.out.printf("The value of Register is : %.2f Gohms\n", answer);
        }
    }

    public static void main(String[] args) {
        String[] band_colors = {"blue", "green", "red", "silver"};
        detect(band_colors);
    }
}
