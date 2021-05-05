package utils;

import java.util.Date;

public class DateTimeUtil {

    public static long currentEpochTime() {

        Date currentDate = new Date();
        return currentDate.getTime() / 1000;
    }
}
