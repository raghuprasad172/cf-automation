package cf.nbfc.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtil {



    public static int generateRandomInt() {
        return new Random().nextInt(5000);
    }

    public static String getCurrentDateAndTime() {
        return new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    }

    public static String generateRandomMobileNumber() {
        return  "9"+String.format("%03d%03d%03d",
                (int) Math.floor(999*Math.random()),
                (int) Math.floor(999*Math.random()),
                (int) Math.floor(9999*Math.random()));
    }





}
