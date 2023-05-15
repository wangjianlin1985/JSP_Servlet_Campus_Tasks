// 
// 
// 

package pers.hdh.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Utils
{
    public static String md5(final String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes());
        }
        catch (Exception ex) {}
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); md5code = "0" + md5code, ++i) {}
        return md5code;
    }
    
    public static void main(final String[] args) {
        System.out.println(md5("123456"));
    }
}
