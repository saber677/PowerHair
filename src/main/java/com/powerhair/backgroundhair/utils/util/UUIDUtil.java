package com.powerhair.backgroundhair.utils.util;


import java.util.UUID;

public class UUIDUtil {


    public static Long getPrimaryKey() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }
}
