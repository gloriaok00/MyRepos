package com.example.demo.pingshi.jwt;

import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @description jwt学习 模拟生成jwt.io上默认的那个
 * @date 2022-01-08 09:07
 */

public class JWTUtils {

    static String SECRETKEY = "your-256-bit-secret";

    /**
     * 由字符串生成加密key
     */
    public static SecretKey generalKey(String stringKey) {
        SecretKey key = new SecretKeySpec(stringKey.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        return key;
    }

    /**
     * 创建jwt
     */
    public static String createJWT(String uuid, Map<String, Object> claims, Map<String, Object> headers) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey key = generalKey(SECRETKEY);
        JwtBuilder builder = Jwts.builder().setId(uuid).setClaims(claims).setHeader(headers)
                .signWith(signatureAlgorithm, key);
        return builder.compact();
    }

    /**
     * 解密jwt，获取实体
     */
    public static Claims parseJWT(String jwt) throws ExpiredJwtException, UnsupportedJwtException,
            MalformedJwtException, SignatureException, IllegalArgumentException {
        SecretKey key = generalKey(SECRETKEY);
        return Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).getBody();
    }

    /**
     * 入口
     */
    public static void main(String[] args) {

        Map<String, Object> claimsMap = new LinkedHashMap<>();
        claimsMap.put("sub", "1234567890");
        claimsMap.put("name", "John Doe");
        claimsMap.put("iat", 1516239022);
        Map<String, Object> headers = new LinkedHashMap<>();
        headers.put("alg", "HS256");
        headers.put("typ", "JWT");
        String token = createJWT(UUID.randomUUID().toString(), claimsMap, headers);
        System.out.println(token);
        Claims claims = parseJWT(token);
        String name = (String) claims.get("name");
        System.out.println("解析name: " + name);

    }
}

