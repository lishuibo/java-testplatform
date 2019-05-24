package com.litl.www.util;

import java.util.UUID;

public class UUIDUtil {
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String UUIDstr = str.replace("-","");
        return UUIDstr;
    }

    public static void main(String[] args) {
        String uuid = UUIDUtil.getUUID();
        System.out.println(uuid);
    }
}
