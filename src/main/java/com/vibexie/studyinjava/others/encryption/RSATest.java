package com.vibexie.studyinjava.others.encryption;

import com.vibexie.studyinjava.utils.Log;

import java.math.BigInteger;
import java.util.Map;

public class RSATest {
    private static String publicKey, privateKey;

    public static void main(String[] args) {
        String data = "09876543210987654321";
        generatePublicAndPrivateKey();
        byte[] encodedData = publicKeyEncode(data, publicKey);
        privateKeyDecode(encodedData, privateKey);

        String signData = "12345678901234567890";
        String sign = privateSign(signData, privateKey);
        verifySign(signData, publicKey, sign);
    }

    private static void generatePublicAndPrivateKey() {
        Log.p("\n产生公钥秘钥");
        try {
            long time = System.currentTimeMillis();
            Map<String, Object> keyMap = RSA.initKey();
            Log.p("共耗时：" + (System.currentTimeMillis() - time) + "ms");
            publicKey = RSA.getPublicKey(keyMap);
            privateKey = RSA.getPrivateKey(keyMap);
            Log.p("公钥 = %s", publicKey);
            Log.p("秘钥 = %s", privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] publicKeyEncode(String data, String publicKey) {
        Log.p("\n使用公钥加密");
        try {
            byte[] encodeData = RSA.encryptByPublicKey(data.getBytes(), publicKey);
            String encodeStr = new BigInteger(1, encodeData).toString(16);
            Log.p("使用公钥加密: %s", data);
            Log.p("加密结果: %s", encodeStr);
            return encodeData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String privateKeyDecode(byte[] data, String privateKey) {
        Log.p("\n使用私钥解密");
        try {
            String encodeStr = new BigInteger(1, data).toString(16);
            Log.p("使用私钥解密: %s", encodeStr);

            byte[] decodeData = RSA.decryptByPrivateKey(data, privateKey);
            String decodeStr = new String(decodeData);
            Log.p("解密结果: %s", decodeStr);
            return decodeStr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String privateSign(String data, String privateKey) {
        Log.p("\n使用私钥签名");
        try {
            String sign = RSA.sign(data.getBytes(), privateKey);
            Log.p("私钥签名: %s", data);
            Log.p("获得签名: %s", sign);
            return sign;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String verifySign(String data, String publicKey, String sign) {
        Log.p("\n验证签名");
        try {
            boolean ok = RSA.verify(data.getBytes(), publicKey, sign);
            Log.p("验证签名:%s", ok ? "成功" : "失败");
            return sign;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
