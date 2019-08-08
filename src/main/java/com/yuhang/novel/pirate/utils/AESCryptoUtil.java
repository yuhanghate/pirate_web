package com.yuhang.novel.pirate.utils;

import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;

public class AESCryptoUtil {

    // 加密算法
    private static final String ALG = "DES";
    // 字符编码
    private static final String ENC = "UTF-8";
    // 密钥正规化算法
    private static final String SEC_NORMALIZE_ALG = "MD5";

    // 加密
    public static String encrypt(String secret, String data) throws Exception {
        MessageDigest dig = MessageDigest.getInstance(SEC_NORMALIZE_ALG);
        byte[] key = dig.digest(secret.getBytes(ENC));
        SecretKeySpec secKey = new SecretKeySpec(key, ALG);

        Cipher aesCipher = Cipher.getInstance(ALG);
        byte[] byteText = data.getBytes(ENC);

        aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
        byte[] byteCipherText = aesCipher.doFinal(byteText);

        Base64 base64 = new Base64();
        return new String(base64.encode(byteCipherText), ENC);
    }

    // 解密
    public static String decrypt(String secret, String ciphertext) throws Exception {
        MessageDigest dig = MessageDigest.getInstance(SEC_NORMALIZE_ALG);
        byte[] key = dig.digest(secret.getBytes(ENC));
        SecretKeySpec secKey = new SecretKeySpec(key, ALG);

        Cipher aesCipher = Cipher.getInstance(ALG);
        aesCipher.init(Cipher.DECRYPT_MODE, secKey);
        Base64 base64 = new Base64();
        byte[] cipherbytes = base64.decode(ciphertext.getBytes());
        byte[] bytePlainText = aesCipher.doFinal(cipherbytes);

        return new String(bytePlainText, ENC);
    }

    public static void main(String[] args) {
        String secret = "111122223333444455556sdfdsfdsfdsfdsfdsfdsfdsfdsfdsfdsfdsfdsf66677778888";
        String data = "1234567890";
        try {
            System.out.println("key=" + secret + ",original data=" + data);
            long start = System.currentTimeMillis();
            String encryptData = AESCryptoUtil.encrypt(secret, data);
//            String encryptData = RxEncryptTool.encrypt3DES(data.getBytes(), secret.getBytes()).toString();
            System.out.println("encryptData=" + encryptData + ", cost=" + (System.currentTimeMillis() - start));
            start = System.currentTimeMillis();
            String decryptData = AESCryptoUtil.decrypt(secret, encryptData);
            System.out.println("decryptData=" + decryptData + ", cost=" + (System.currentTimeMillis() - start));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}