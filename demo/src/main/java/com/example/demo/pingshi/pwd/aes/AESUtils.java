package com.example.demo.pingshi.pwd.aes;

import com.alibaba.fastjson.JSON;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/**
 * @description 对称加密 aes
 * @date 2022-04-12 13:35
 */

public class AESUtils {

	/**
	 * 加密
	 * @param content 明文
	 * @param key 加解密规则 访客系统提供key
	 * @return String 密文
	 */
	public static String aesEncode(String content, String key) {
		if (content == null || content.length() < 1) {
			return null;
		}
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom random=SecureRandom.getInstance("SHA1PRNG");
			random.setSeed(key.getBytes());
			kgen.init(128, random);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
			byte[] byteResult = cipher.doFinal(byteContent);
			StringBuilder sb = new StringBuilder();
			for (byte b : byteResult) {
				String hex = Integer.toHexString(b & 0xFF);
				if (hex.length() == 1) {
					hex = '0' + hex;
				}
				sb.append(hex.toUpperCase());
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密
	 * @param content 密文
	 * @param key 加解密规则
	 * @return String 明文
	 */
	public static String aesDecode(String content, String key) {
		if (content == null || content.length() < 1) {
			return null;
		}
		if (content.trim().length() < 19) {
			return content;
		}
		byte[] byteResult = new byte[content.length() / 2];
		for (int i = 0; i < content.length() / 2; i++) {
			int high = Integer.parseInt(content.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(content.substring(i * 2 + 1, i * 2 + 2), 16);
			byteResult[i] = (byte) (high * 16 + low);
		}
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom random=SecureRandom.getInstance("SHA1PRNG");
			random.setSeed(key.getBytes());
			kgen.init(128, random);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
			byte[] result = cipher.doFinal(byteResult);
			return new String(result);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		try {
			Map<String, Object> content = new HashMap<>();
			content.put("name","zy");
			content.put("age",23);
			String secretText = AESUtils.aesEncode(JSON.toJSONString(content),
					"myKey131420");
			System.out.println("密文:" + secretText);

			String plainText = AESUtils.aesDecode(secretText, "myKey131420");
			System.out.println("明文:" + plainText);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
