import java.util.HashMap;
import java.util.Map;

public class Desafio01 {

    private static final Map<Integer, String> colorMap = new HashMap<>();
    private static final String TOLERANCE_BAND = "dourado";

    static {
        colorMap.put(0, "preto");
        colorMap.put(1, "marrom");
        colorMap.put(2, "vermelho");
        colorMap.put(3, "laranja");
        colorMap.put(4, "amarelo");
        colorMap.put(5, "verde");
        colorMap.put(6, "azul");
        colorMap.put(7, "violeta");
        colorMap.put(8, "cinza");
        colorMap.put(9, "branco");
    }

    public static String resistorColorCode(String input) {
        input = input.replace(" ohms", "");

        double value;
        int multiplier = 0;

        if (input.endsWith("k")) {
            value = Double.parseDouble(input.replace("k", "")) * 1000;
        } else if (input.endsWith("M")) {
            value = Double.parseDouble(input.replace("M", "")) * 1000000;
        } else {
            value = Double.parseDouble(input);
        }

        int intValue = (int) value;
        String result = getBandColors(intValue);

        int zerosCount = (int) Math.log10(intValue) - 1;
        String thirdBand = colorMap.get(zerosCount);

        result += " " + thirdBand + " " + TOLERANCE_BAND;

        return result;
    }

    private static String getBandColors(int value) {
        String stringValue = Integer.toString(value);
        int firstDigit = Character.getNumericValue(stringValue.charAt(0));
        int secondDigit = Character.getNumericValue(stringValue.charAt(1));

        String firstBand = colorMap.get(firstDigit);
        String secondBand = colorMap.get(secondDigit);

        return firstBand + " " + secondBand;
    }

    public static void main(String[] args) {
        System.out.println(resistorColorCode("10 ohms"));
        System.out.println(resistorColorCode("100 ohms"));
        System.out.println(resistorColorCode("220 ohms"));
        System.out.println(resistorColorCode("330 ohms"));
        System.out.println(resistorColorCode("470 ohms"));
        System.out.println(resistorColorCode("680 ohms"));
        System.out.println(resistorColorCode("1k ohms"));
        System.out.println(resistorColorCode("2M ohms"));
    }
}
