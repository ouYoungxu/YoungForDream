package com.ouyang.practical;

import sun.security.action.GetPropertyAction;

import java.io.CharArrayWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.security.AccessController;
import java.util.BitSet;

/**
 * @author: ganjiang-ouyangxu
 * @Date: 2019年03月13日 17:49
 */
public class UrlUtils {
    private static BitSet dontNeedEncoding;
    private static final int caseDiff = ('a' - 'A');
    private static String dfltEncName = null;

    static {
        dontNeedEncoding = new BitSet(256);
        int i;
        for (i = 'a'; i <= 'z'; i++) {
            dontNeedEncoding.set(i);
        }
        for (i = 'A'; i <= 'Z'; i++) {
            dontNeedEncoding.set(i);
        }
        for (i = '0'; i <= '9'; i++) {
            dontNeedEncoding.set(i);
        }
        dontNeedEncoding.set(' ');
        dontNeedEncoding.set('-');
        dontNeedEncoding.set('_');
        dontNeedEncoding.set('.');
        dontNeedEncoding.set('*');

        dfltEncName = AccessController.doPrivileged(
                new GetPropertyAction("file.encoding")
        );
    }

    public static String urlSafeEncode(String s) {
        String str = null;
        try {
            str = encode(s, dfltEncName);
            str = str.replace('+', '-');
            str = str.replace('/', '_');
            str = str.replaceAll("=", "");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("urlEncodeException");
        }
        return str;
    }

    public static String urlSafeDecode(String s) {
        String str = null;
        try {
            s = s.replace('-', '+');
            s = s.replace('_', '/');
            int mod4 = s.length()%4;
            if(mod4 > 0){
                s = s + "====".substring(mod4);
            }
            str = decode(s, dfltEncName);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("urlDecodeException");
        }
        return str;
    }

    public static String encode(String s) {
        String str = null;
        try {
            str = encode(s, dfltEncName);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("urlEncodeException");
        }
        return str;
    }

    public static String encode(String s, String enc) throws UnsupportedEncodingException {

        boolean needToChange = false;
        StringBuffer out = new StringBuffer(s.length());
        Charset charset;
        CharArrayWriter charArrayWriter = new CharArrayWriter();

        if (enc == null) {
            throw new NullPointerException("charsetName");
        }

        try {
            charset = Charset.forName(enc);
        } catch (IllegalCharsetNameException e) {
            throw new UnsupportedEncodingException(enc);
        }

        for (int i = 0; i < s.length();) {
            int c = (int) s.charAt(i);
            if (dontNeedEncoding.get(c)) {
                if (c == ' ') {
                    c = '+';
                    needToChange = true;
                }
                out.append((char)c);
                i++;
            } else {
                do {
                    charArrayWriter.write(c);

                    if (c >= 0xD800 && c <= 0xDBFF) {
                        if ( (i+1) < s.length()) {
                            int d = (int) s.charAt(i+1);
                            if (d >= 0xDC00 && d <= 0xDFFF) {
                                charArrayWriter.write(d);
                                i++;
                            }
                        }
                    }
                    i++;
                } while (i < s.length() && !dontNeedEncoding.get((c = (int) s.charAt(i))));

                charArrayWriter.flush();
                String str = new String(charArrayWriter.toCharArray());
                byte[] ba = str.getBytes(charset);
                for (int j = 0; j < ba.length; j++) {
                    out.append('%');
                    char ch = Character.forDigit((ba[j] >> 4) & 0xF, 16);
                    if (Character.isLetter(ch)) {
                        ch -= caseDiff;
                    }
                    out.append(ch);
                    ch = Character.forDigit(ba[j] & 0xF, 16);
                    if (Character.isLetter(ch)) {
                        ch -= caseDiff;
                    }
                    out.append(ch);
                }
                charArrayWriter.reset();
                needToChange = true;
            }
        }

        return (needToChange? out.toString() : s);
    }

    public static String decode(String s) {
        String str = null;
        try {
            str = decode(s, dfltEncName);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("urlDecodeException");
        }
        return str;
    }

    public static String decode(String s, String enc) throws UnsupportedEncodingException {

        boolean needToChange = false;
        int numChars = s.length();
        StringBuffer sb = new StringBuffer(numChars > 500 ? numChars / 2 : numChars);
        int i = 0;

        if (enc.length() == 0) {
            throw new NullPointerException("charsetName");
        }

        char c;
        byte[] bytes = null;
        while (i < numChars) {
            c = s.charAt(i);
            switch (c) {
                case '+':
                    sb.append(' ');
                    i++;
                    needToChange = true;
                    break;
                case '%':
                    try {
                        if (bytes == null) {
                            bytes = new byte[(numChars-i)/3];
                        }
                        int pos = 0;

                        while ( ((i+2) < numChars) &&
                                (c=='%')) {
                            int v = Integer.parseInt(s.substring(i+1,i+3),16);
                            if (v < 0) {
                                throw new IllegalArgumentException("UrlUtilsEncode: Illegal hex characters in escape (%) pattern - negative value");
                            }
                            bytes[pos++] = (byte) v;
                            i+= 3;
                            if (i < numChars) {
                                c = s.charAt(i);
                            }
                        }

                        if ((i < numChars) && (c=='%')) {
                            throw new IllegalArgumentException(
                                    "UrlUtilsEncode: Incomplete trailing escape (%) pattern");
                        }

                        sb.append(new String(bytes, 0, pos, enc));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(
                                "UrlUtilsEncode: Illegal hex characters in escape (%) pattern - "
                                        + e.getMessage());
                    }
                    needToChange = true;
                    break;
                default:
                    sb.append(c);
                    i++;
                    break;
            }
        }

        return (needToChange? sb.toString() : s);
    }
}
