package fishing.util;

import java.util.Random;

public class Utill {
    public static int randomValue() {
        int result;
        Random random = new Random();
        result = random.nextInt(100);
        return result;
    }
}
