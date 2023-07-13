package me.adarsh.godspunkycore;

import java.util.Arrays;
import java.util.List;

public final class SkyBlockCalendar {
    public static final List<String> MONTH_NAMES = Arrays.asList(new String[] {
            "Early Spring", "Spring", "Late Spring", "Early Summer", "Summer", "Late Summer", "Early Autumn", "Autumn", "Late Autumn", "Early Winter",
            "Winter", "Late Winter" });

    public static long ELAPSED = 0L;

    public static final int YEAR = 8928000;

    public static final int MONTH = 744000;

    public static final int DAY = 24000;

    public static int getYear() {
        return (int)(ELAPSED / 8928000L);
    }

    public static int getMonth() {
        return (int)(ELAPSED / 744000L) % 12 + 1;
    }

    public static int getDay() {
        return (int)(ELAPSED / 24000L) % 31 + 1;
    }

    public static String getMonthName(int month) {
        if (month < 1 || month > 12)
            return "Unknown Month";
        return MONTH_NAMES.get(month - 1);
    }

    public static String getMonthName() {
        return getMonthName(getMonth());
    }

    public static void saveElapsed() {
        Skyblock plugin = Skyblock.getPlugin();
        plugin.config.set("timeElapsed", Long.valueOf(ELAPSED));
        plugin.config.save();
    }
}
