package fishing.util;

import java.util.Random;

public class Utill {
    public static int randomValue() {
        int result;
        Random random = new Random();
        result = random.nextInt(100);
        return result;
    }

    public static boolean randomBoolean(int value){
        boolean result;
        Random random = new Random();
        int x = random.nextInt(100);
        int y = x - value;
        if(y <= 0){
            result = true;
        } else {
            result = false;
        }

        return result;
    }
}
