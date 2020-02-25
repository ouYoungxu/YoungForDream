package com.ouyang.practical.des;

import com.ouyang.practical.UrlUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * <p>
 *
 * @author:<a href="mailto:ouyangxu@ancun.com">ouyangxu</a><br>
 * create at:2018年05月17日 9:32
 **/
public class DESCoderTest {
    @Test
    public void testSignEncrypt() {
        String inputStr = "123456";
        String s1= DESCoder.signEncrypt(inputStr);
        System.out.println("加密后:" + s1);
    }

    @Test
    public void testSignUrlEncrypt() {
        String inputStr = "43";
        String s1= DESCoder.signUrlEncrypt(inputStr);
        System.out.println("加密后:" + s1);
    }

    @Test
    public void testSignDecrypt() {
        String inputStr = "43";
        System.out.println("解密后:" + DESCoder.signDecrypt(inputStr));
    }

    @Test
    public void testSignUrlDecrypt() throws UnsupportedEncodingException {
        String inputStr = "43";
        System.out.println("解密后:" + DESCoder.signDecrypt(URLDecoder.decode(inputStr, ENC)));
    }

    private static final String ENC ="UTF-8";

    @Test
    public void test1() {
        String[] inputStr = {
                "123456",
                "1234567",
                "abcdefg",
                "abcdef",
                "alskflas=/./",
                "12-=sfs=!@2$@!@$%"
        };
        for (String str: inputStr) {
            System.out.println("\"" + DESCoder.signEncrypt(str) + "\",");
        }
    }

    @Test
    public void test2() {
        String[] inputStr = {
                "SWBCY0SfBkE=",
                "rTroOQz/T4s=",
                "e8aNfREFwPA=",
                "vr2f2USw//Q=",
                "vQ5gdMka9/OwxU7frs+2Tg==",
                "al9YAg6c/aNTBAhhSnkrryr447oI0pP0"
        };
        for (String str: inputStr) {
            System.out.println("\"" + DESCoder.signDecrypt(str) + "\",");
        }
    }

    @Test
    public void test3() {
        String[] inputStr = {
                "SWBCY0SfBkE=",
                "rTroOQz/T4s=",
                "e8aNfREFwPA=",
                "vr2f2USw//Q=",
                "vQ5gdMka9/OwxU7frs+2Tg==",
                "al9YAg6c/aNTBAhhSnkrryr447oI0pP0"
        };
        for (String str: inputStr) {
            System.out.println("\"" + UrlUtils.encode(str) + "\",");
        }
    }

    @Test
    public void test4() {
        String[] inputStr = {
                "SWBCY0SfBkE=",
                "rTroOQz/T4s=",
                "e8aNfREFwPA=",
                "vr2f2USw//Q=",
                "vQ5gdMka9/OwxU7frs+2Tg==",
                "al9YAg6c/aNTBAhhSnkrryr447oI0pP0"
        };
        for (String str: inputStr) {
            System.out.println(UrlUtils.decode(str));
            System.out.println(UrlUtils.decode(str));
            System.out.println(UrlUtils.decode(str));
        }
    }
}
