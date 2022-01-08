package com.example.demo.pingshi.jwt;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64UrlCodec;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @description  按加密逻辑模拟jwo.io
 * @date 2022-01-07 16:42
 */

public class JWTDemo {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        JSONObject header = new JSONObject(true);
        header.put("alg", "HS256");
        header.put("typ", "JWT");
        Base64UrlCodec codec = new Base64UrlCodec();
        String HeaderStr = codec.encode(header.toJSONString().getBytes(StandardCharsets.UTF_8));
        System.out.println("header:" + HeaderStr);
        JSONObject claims = new JSONObject(true);
        claims.put("sub", "1234567890");
        claims.put("name", "John Doe");
        claims.put("iat", 1516239022);
        String claimsStr = codec.encode(claims.toJSONString().getBytes(StandardCharsets.UTF_8));
        System.out.println("claims:" + claimsStr);
        Mac sha256_HMAC = Mac.getInstance(SignatureAlgorithm.HS256.getJcaName());
        String secret = "your-256-bit-secret";
        SecretKeySpec key = new SecretKeySpec(secret.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        sha256_HMAC.init(key);
        String needSignature=HeaderStr+"."+claimsStr;
        byte[] bytes = sha256_HMAC.doFinal(needSignature.getBytes());
        String signature = codec.encode(bytes);
        System.out.println("signature:"+signature);
        System.out.println("jwt:"+needSignature+"."+signature);
    }
}
