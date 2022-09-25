package com.powerhair.backgroundhair.tool.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class UUIDUtil {

    private static AtomicLong id;

//    public static Long getPrimaryKey() {
//        return generatePositiveNumber(UUID.randomUUID().getLeastSignificantBits());
//    }

    public static Long getPrimaryKey() {
        Long time = Long.valueOf(new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date()));
        if (id == null) {
            id = new AtomicLong(time);
            return id.get();
        }
        if (time <= id.get()) {
            id.addAndGet(1);
        } else {
            id = new AtomicLong(time);
        }
        return generatePositiveNumber(id.get());
    }

    private static Long generatePositiveNumber(Long uuid) {
        return uuid < 0 ? -uuid : uuid;
    }
}
