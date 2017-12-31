package Collections;

/**
 * Created by AiYeSus on 12/14/2017.
 */

public class SeparateDigitAndNonD {

    public static void main(String[] args) {
 //       String input = "1a2b3c4defgh567jkl";
 //       separateDigitsAndAlphabets(input);

        String reserved = "23A 3D 1A 20E 14G";
        for(String seat : reserved.split(" "))
            separateDigitsAndAlphabets(seat);
    }

    public static void separateDigitsAndAlphabets(String str) {
        String number = "";
        String letter = "";
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if (Character.isDigit(a)) {
                number = number + a;

            } else {
                letter = letter + a;

            }
        }
        System.out.print("row :"+number);
        System.out.println(" seat :"+letter);

    }
}
