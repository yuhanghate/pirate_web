package com.yuhang.novel.pirate.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * @author yuhang
 * @description: 组件接口加密
 * @date 2021/3/9 4:58 PM
 */
public class ZujianEncryptionUtils {

    /**
     * 固定的密钥
     */
    private final static String privateKey = "Gxfchbnl03251659";

    /**
     * 
     * @param taxId
     *            税号
     * @param taxDiscId
     *            盘号
     * @param startDate
     *            开始日期
     * @param endDate
     *            结果日期
     * @return
     */
    public static String encrypt(String taxId, String taxDiscId, Date startDate, Date endDate) {
        String userInfo = createUserInfo(taxId, taxDiscId, startDate, endDate);
        byte[] bytes = createByte256Empty();
        byte[] privateKey = getByteFromPrivateKey();
        byte[] convert = convert(bytes, privateKey);

        byte[] base64 = base64(convert, userInfo);
        String encode = Base64.getEncoder().encodeToString(base64);
        return StringUtils.rightPad(encode, 160, "!");
    }

    /**
     * 把密钥进行转换加密
     * 
     * @param arr
     * @param key_arr
     * @return
     */
    private static byte[] convert(byte[] arr, byte[] key_arr) {
        int j = 0;
        for (int i = 0; i < 256; i++) {

            j = (j + getUnsignedByte(arr[i]) + getUnsignedByte(key_arr[i])) % 256;

            byte tem = arr[i];
            arr[i] = arr[j];
            arr[j] = tem;
        }

        return arr;
    }

    /**
     * 创建一个 256的 byte数组
     *
     * 按0-255顺序填充
     * 
     * @return
     */
    private static byte[] createByte256Empty() {
        byte[] arr = new byte[256];

        for (int i = 0; i < 256; i++) {
            arr[i] = new Integer(i).byteValue();
        }
        return arr;
    }

    /**
     * 把密钥 转成 byte[]
     * 
     * @return
     */
    private static byte[] getByteFromPrivateKey() {

        /**
         * 转成Ascii码
         */
        byte[] ascii = privateKey.getBytes(StandardCharsets.US_ASCII);
        byte[] key_arr = new byte[256];

        for (int i = 0; i < 256; i++) {

            /**
             * 进行 模 处理
             */
            key_arr[i] = ascii[i % (ascii.length)];
        }

        return key_arr;
    }

    /**
     * 把用户信息拼成一串明文的内容
     * 
     * @param taxId
     * @param taxDiscId
     * @param startDate
     * @param endDate
     * @return
     */
    private static String createUserInfo(String taxId, String taxDiscId, Date startDate, Date endDate) {

        String start = DateUtil.format(startDate, "yyyyMMdd");;
        String end = DateUtil.format(endDate, "yyyyMMdd");
        String tmp = DateUtil.format(startDate, "ddyyyyMM");

        return taxId + "@" + taxDiscId + "@" + start + "@" + end + "@1@32@003@V1@004&005&006&007&009&025&026@53@999@@"
            + tmp + "@@1@";
    }

    /**
     * 自定义 base64 进行加密
     * 
     * @param arr1
     * @param str
     * @return
     */
    private static byte[] base64(byte[] arr1, String str) {
        byte[] textBytes = str.getBytes(StandardCharsets.US_ASCII);
        byte[] out = new byte[textBytes.length];

        int i = 0;
        int j = 0;

        for (int k = 0; k < textBytes.length; k++) {
            i = (i + 1) % 256;
            j = (j + getUnsignedByte(arr1[i])) % 256;

            byte tem = arr1[i];
            arr1[i] = arr1[j];
            arr1[j] = tem;

            int t = (getUnsignedByte(arr1[i]) + getUnsignedByte(arr1[j])) % 256;
            out[k] = (byte)(textBytes[k] ^ arr1[t]);
        }

        return out;

    }

    /**
     * int类型转无符号
     * 
     * @param b
     * @return
     */
    private static int getUnsignedByte(byte b) {
        return b & 0x0FF;
    }
}
