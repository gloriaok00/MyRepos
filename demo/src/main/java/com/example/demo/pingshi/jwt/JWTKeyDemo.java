package com.example.demo.pingshi.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @description jjwt的api key那里就是需要放base64加密后的字符串
 * @date 2022-01-16 23:41
 * @date 2022-05-15 12:08
 */

public class JWTKeyDemo {

    private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;



    public Date getExpirationDate(int expirationInMinutes) {
        return new Date(System.currentTimeMillis() + (expirationInMinutes * 60 * 1000));
    }

    public Claims getClaimsForToken(String token) {
        return Jwts.parser().setSigningKey("aW90S2V5").parseClaimsJws(token).getBody();

    }

    public String generateToken(String name, int expirationInMinutes) {

        JwtBuilder builder = Jwts.builder().setSubject(name).setIssuedAt(new Date())
                .setExpiration(getExpirationDate(expirationInMinutes)).signWith(SIGNATURE_ALGORITHM, "aW90S2V5");
        String[] xx = {
                "VIEW_SERVER_INFO",
                "REST",
                "ADMIN_CONSOLE",
                "ADMINISTER_USERS",
                "ADMINISTER_USER_SELF",
                "ADMINISTER_TENANTS",
                "ADMINISTER_TENANT_SELF",
                "ADMINISTER_SCHEDULES",
                "SCHEDULE_COMMANDS"};
        builder.claim("auth", xx);
        builder.claim("user_name", "super_admin");
        builder.claim("password", "super_admin");
        builder.claim("tenantId", 1);
        String[] yy = {
                "14:/user/list",
                "11:/role/list",
                "24:/menu/list",
                "18:/role/assign/menus",
                "20:/role/update",
                "13:/user/assign/roles",
                "10:/role/create",
                "15:/user/update",
                "19:/role/assign/permissions",
                "22:/permission/list",
                "12:/user/create",
                "17:/user/reset/password",
                "21:/role/delete",
                "16:/user/delete"
        };
        builder.claim("authorities", yy);
        builder.claim("client_id", "iot_web");
        return builder.compact();
    }

    public static void main(String[] args) {
        JWTKeyDemo cc = new JWTKeyDemo();
        String jwt = cc.generateToken("admin", 60);
        //String jwt="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbiIsInBhc3N3b3JkIjoic3VwZXJfYWRtaW4iLCJhdXRoIjpbIlZJRVdfU0VSVkVSX0lORk8iLCJSRVNUIiwiQURNSU5fQ09OU09MRSIsIkFETUlOSVNURVJfVVNFUlMiLCJBRE1JTklTVEVSX1VTRVJfU0VMRiIsIkFETUlOSVNURVJfVEVOQU5UUyIsIkFETUlOSVNURVJfVEVOQU5UX1NFTEYiLCJBRE1JTklTVEVSX1NDSEVEVUxFUyIsIlNDSEVEVUxFX0NPTU1BTkRTIl0sInVzZXJfbmFtZSI6InN1cGVyX2FkbWluIiwic2NvcGUiOlsiYXBwIl0sInRlbmFudElkIjoxLCJleHAiOjE2NDI3NjMxNTYsImF1dGhvcml0aWVzIjpbIjE0Oi91c2VyL2xpc3QiLCIxMTovcm9sZS9saXN0IiwiMjQ6L21lbnUvbGlzdCIsIjE4Oi9yb2xlL2Fzc2lnbi9tZW51cyIsIjIwOi9yb2xlL3VwZGF0ZSIsIjEzOi91c2VyL2Fzc2lnbi9yb2xlcyIsIjEwOi9yb2xlL2NyZWF0ZSIsIjE1Oi91c2VyL3VwZGF0ZSIsIjE5Oi9yb2xlL2Fzc2lnbi9wZXJtaXNzaW9ucyIsIjIyOi9wZXJtaXNzaW9uL2xpc3QiLCIxMjovdXNlci9jcmVhdGUiLCIxNzovdXNlci9yZXNldC9wYXNzd29yZCIsIjIxOi9yb2xlL2RlbGV0ZSIsIjE2Oi91c2VyL2RlbGV0ZSJdLCJqdGkiOiJlY2FmMjQ0MC1hZmUxLTRhNjctYmZiNy1hZjFhYzZjN2MxNGMiLCJjbGllbnRfaWQiOiJpb3Rfd2ViIn0.hbNDSTaXLKcZ3unEBFGJUZajPz3r4DUEflXnt9dfm74";
        System.out.println(jwt);
        Claims vv = cc.getClaimsForToken(jwt);
        System.out.println(vv.getSubject());
        System.out.println(vv.get("authorities"));
    }

}
