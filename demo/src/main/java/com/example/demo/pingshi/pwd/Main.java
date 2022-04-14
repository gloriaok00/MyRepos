package com.example.demo.pingshi.pwd;


import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {
      /*  byte[] input = new byte[] { 0x01, 0x02, 0x7f, 0x00 };
        String b64encoded = Base64.getUrlEncoder().encodeToString(input);
        System.out.println(b64encoded);
        byte[] output = Base64.getUrlDecoder().decode(b64encoded);
        System.out.println(Arrays.toString(output));*/
        String content = "eyJwYXNzd29yZCI6InN1cGVyX2FkbWluIiwidXNlcl9uYW1lIjoic3VwZXJfYWRtaW4iLCJzY29wZSI6WyJhcHAiXSwidGVuYW50SWQiOjIsImV4cCI6MTY0MTY0MDUxOCwiYXV0aG9yaXRpZXMiOlsiMTE65YiX5Li-6KeS6ImyIiwiMTk65YiG6YWN6LWE5rqQIiwiMTY65Yig6Zmk55So5oi3IiwiMTA65Yib5bu66KeS6ImyIiwiMTU65pu05paw55So5oi3IiwiMTQ65YiX5Li-55So5oi3IiwiMjI65YiX5Li-6LWE5rqQIiwiMjQ65YiX5Li-6I-c5Y2VIiwiMjA65pu05paw6KeS6ImyIiwiMTM65YiG6YWN6KeS6ImyIiwiMTI65Yib5bu655So5oi3IiwiMTc66YeN572u5a-G56CBIiwiMjE65Yig6Zmk6KeS6ImyIiwiMTg65YiG6YWN6I-c5Y2VIl0sImp0aSI6IjFlODU3YWNmLWJjMWItNGE5OS05MWJmLWU5NWZlM2U0YWNlNyIsImNsaWVudF9pZCI6ImlvdF93ZWIifQ";
       /* byte[] claims = Codecs.b64UrlDecode(content);
        String str = new String(claims, StandardCharsets.UTF_8);
        System.out.println(str);*/


        byte[] output = Base64.getUrlDecoder().decode(content.getBytes(StandardCharsets.UTF_8));
        String str1 = new String(output, StandardCharsets.UTF_8);
        System.out.println(str1);
    }
}
