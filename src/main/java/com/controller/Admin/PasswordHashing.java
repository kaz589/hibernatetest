package com.controller.Admin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHashing {
    public static void main(String[] args) {
        String password = "mySecretPassword";  // 你的原始密碼
        String hashedPassword = hashPassword(password);
        System.out.println("Hashed Password: " + hashedPassword);
    }

    // 使用 SHA-256 對密碼進行雜湊
    public static String hashPassword(String password) {
        try {
            // 創建 MessageDigest 實例，指定使用 SHA-256 演算法
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            // 將密碼轉換為位元組並進行雜湊
            byte[] hashedBytes = messageDigest.digest(password.getBytes());

            // 將雜湊的位元組數組轉換為十六進位字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                // 將每個 byte 轉換為兩位十六進位的字符串
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error while hashing password", e);
        }
    }
}
