package ru.daedal.data;

import java.util.HashMap;
import java.util.Map;

public class PlayerDatabase {
    public static Map<Long, Long> playerXp = new HashMap<>();

    static {
        playerXp.put(0L, 1350L);
        playerXp.put(1L, 23415L);
        playerXp.put(2L, 212L);
        playerXp.put(3L, 1L);
    }
}
