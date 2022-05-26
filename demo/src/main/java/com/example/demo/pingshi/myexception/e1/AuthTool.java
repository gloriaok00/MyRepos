package com.example.demo.pingshi.myexception.e1;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

/**
 * @description 授权工具类
 */

@Component
public class AuthTool {

    //获取jwt claims
    public static Claims getJwtClaims(String jwt) {
        return Jwts.parser().setSigningKey("aW90S2V5").parseClaimsJws(jwt).getBody();
    }

}
