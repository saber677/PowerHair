package com.powerhair.backgroundhair.utils.util;


import java.util.UUID;

public class UUIDUtil {

    public static Long getPrimaryKey() {
        return generatePositiveNumber(UUID.randomUUID().getMostSignificantBits());
    }

    private static Long generatePositiveNumber(Long uuid) {
        return uuid < 0 ? -uuid : uuid;
    }
}
