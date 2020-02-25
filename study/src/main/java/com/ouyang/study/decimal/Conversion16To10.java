package com.ouyang.study.decimal;

import org.junit.Test;

import java.math.BigInteger;
import java.nio.ByteOrder;

/**
 * @author: ouyangxu
 * @Date: 2019年05月30日 18:41
 */
public class Conversion16To10 {
    @Test
    public void test1 () {
        System.out.println(decode(new byte[] {(byte) 0x9c, (byte) 0xff}, ByteOrder.BIG_ENDIAN));
    }

    @Test
    public void test2 () {
        short svar = 127;
        System.out.println(Short.toUnsignedInt(svar));
        System.out.println(Short.toUnsignedLong(svar));
        int var = 127;
        System.out.println(Integer.toHexString(var));
        var = -127;
        System.out.println(Integer.toHexString(var));
        long lvar = 127L;
        System.out.println(Long.toHexString(lvar));
        lvar = -127L;
        System.out.println(Long.toHexString(lvar));

        int fvar = -23243;
        String hex = Integer.toHexString(fvar);
        System.out.println(hex);

        BigInteger bi = new BigInteger(hex, 16);
        int a=bi.intValue();
        System.out.println(a);
    }

    @Test
    public void test3 () {
        String str = "ff8d";
        System.out.println(Integer.valueOf(str,16));
        System.out.println(Integer.valueOf(str,16).shortValue());
    }

    @Test
    public void test4 () {
        String str = "ff8d";
        if (str.length() != 4) {
            throw new NumberFormatException("Wrong length: " + str.length() + ", must be 4.");
        }
        int ret = Integer.parseInt(str, 16);
        ret = ((ret & 0x8000) > 0) ? (ret - 0x10000) : (ret);
        System.out.println(ret);
    }

    @Test
    public void test5 () {
        String str = "ff8d";
        short s = (short)(Integer.valueOf(str, 16) & 0xffff);
        System.out.println(s);
    }

    @Test
    public void test6 () {
        String str = "ff8d";
    }

    private static int decode(byte[] src, ByteOrder endian) {
        int result;

        if (src.length < 1 || src.length > 4) {
            throw new IllegalArgumentException("src.length == " + src.length);
        }

        result = 0;

        if (endian == ByteOrder.BIG_ENDIAN) {
            for (int i = 0; i < src.length; i++) {
                //((ret & 0x8000) > 0) ? (ret - 0x10000) : (ret);
                result |= decode(src[i]) << (i * 8);
            }
        }
        else if (endian == ByteOrder.LITTLE_ENDIAN) {
            for (int i = 0, j = src.length - 1; i < src.length; i++, j--) {
                result |= decode(src[i]) << (j * 8);
            }
        }
        else {
            throw new NullPointerException("endian == null");
        }

        return result;
    }

    private static int decode(byte src) {
        int i;

        i = src;
        i &= 0xFF;

        return i;
    }
}
