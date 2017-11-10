package com.go2going;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Objects;
import java.util.Scanner;

/**
 * 项目名称：  testcode<br>
 * 类名称：  AES<br>
 * 描述：在加密数据很多的时候会出现解析错误
 *
 * @author wangqiang
 * 创建时间：  2017/11/9 0009 10:52
 */
public class AES {

    private static final byte[] salt = Base64.getDecoder().decode("bzeRemGWVro=");
    private static String password = "";
    private static byte[] iv;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请选择模式(1->加密，2->解密)：");

        int count = 0;

        String mode = "";
        while (scanner.hasNext()) {
            if (count == 0) {
                mode = scanner.next();
                sw(mode, count++, null);
            } else {
                sw(mode, count++, scanner.next());
            }
        }
    }

    private static void sw(String mode, int count, String value) {
        switch (mode) {
            case "1":
                //            加密
                if (count == 0) {
                    System.out.print("请输入密匙：");
                } else if (count == 1) {
                    password = value;
                    System.out.print("请输入加密文本：");
                } else if (count == 2) {
                    encrypt(value);

                    System.out.print("结束！！！");
                    System.exit(0);
                }
                break;
            case "2":
                //            解密
                if (count == 0) {
                    System.out.print("请输入密匙：");
                } else if (count == 1) {
                    password = value;
                    System.out.print("请输入种子：");
                } else if (count == 2) {
                    iv = Base64.getDecoder().decode(value);
                    System.out.print("请输入解密文本：");
                } else if (count == 3) {
                    decryptProxy(Base64.getDecoder().decode(value.getBytes()));
                    System.out.print("结束！！！");
                    System.exit(0);
                }
                break;
            default:
                System.out.print("输入参数非法：" + mode);
                System.exit(-1);
        }
    }

    private static void encrypt(String text) {
        try {

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey());
            AlgorithmParameters params = cipher.getParameters();
            iv = params.getParameterSpec(IvParameterSpec.class).getIV();
            System.out.println("生成的随机种子，请妥善保存：" + Base64.getEncoder().encodeToString(iv));
            byte[] ciphertext = cipher.doFinal(text.getBytes("UTF-8"));
            if (Objects.equals(decrypt(ciphertext), text)) {
                System.out.println("加密结果，请妥善保存：" + Base64.getEncoder().encodeToString(ciphertext));
            } else {
                System.out.println("加密结果数据校验失败！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void decryptProxy(byte[] ciphertext) {
        String plaintext = decrypt(ciphertext);
        System.out.println("解密结果：" + plaintext);
    }

    private static String decrypt(byte[] ciphertext) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(), new IvParameterSpec(iv));
            return new String(cipher.doFinal(ciphertext), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 生成key
     *
     * @return
     */
    private static SecretKey getSecretKey() {
        SecretKey tmp = null;
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 256);
            tmp = factory.generateSecret(spec);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return new SecretKeySpec(tmp.getEncoded(), "AES");
    }
}
