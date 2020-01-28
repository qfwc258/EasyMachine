package com.walixiwa.easy.machine.util;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Native解码
 * @author Administrator
 */
public class NativeDecoder {
    private static Pattern pattern = Pattern.compile("\\\\u([0-9a-fA-F]{4})");
    public static String decode(String str) {
        Charset set = Charset.forName("UTF-16");
        Matcher m = pattern.matcher(str);
        int start = 0;
        int start2;
        StringBuilder sb = new StringBuilder();
        while (m.find(start)) {
            start2 = m.start();
            if (start2 > start) {
                String seg = str.substring(start, start2);
                sb.append(seg);
            }
            String code = m.group(1);
            int i = 0;
            if (code != null) {
                i = Integer.valueOf(code, 16);
            }
            byte[] bb = new byte[4];
            bb[0] = (byte) ((i >> 8) & 0xFF);
            bb[1] = (byte) (i & 0xFF);
            ByteBuffer b = ByteBuffer.wrap(bb);
            sb.append(String.valueOf(set.decode(b)).trim());
            start = m.end();
        }
        start2 = str.length();
        if (start2 > start) {
            String seg = str.substring(start, start2);
            sb.append(seg);
        }
        return sb.toString();
    }
}
