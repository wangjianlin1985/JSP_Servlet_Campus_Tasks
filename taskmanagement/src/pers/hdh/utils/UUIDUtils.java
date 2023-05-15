// 
// 
// 

package pers.hdh.utils;

import java.util.UUID;

public class UUIDUtils
{
    public static String setId() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }
}
