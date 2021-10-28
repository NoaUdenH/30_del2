package dasuki;
import java.util.Random;

public class Dice {

    public final static int numberOfSides = 6;

   public int rollDice() {

        int result;
        Random randomNumberGenerator = new Random();
        result = randomNumberGenerator.nextInt(numberOfSides) + 1;
        return result;
    }
}